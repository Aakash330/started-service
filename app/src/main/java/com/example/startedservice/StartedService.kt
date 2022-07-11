package com.example.startedservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

class StartedService :Service() {


    //Started serive-it is run on main .
    //it is run seprate from calling componnent
    //it block the ui if it long running operation
    //it doesn't return the value of calling component
    /*if want to send the data calling component to started aservice then we
    pass the value by intent but it can't return the value to calling component
    if we want to return value then you can use bound service or resultReciver
    and broadcast Receiver

     */
    /* use startService(intent) to start the servoce if service is not running the it will
    be instantiated and started
    onCreate()-it will call first time when service is start
    onStartCommond()-it will called after onCreate .
    note:- if service is already running then only onStartCommand will be run.

     */
    //to start the StartService we need to Context

    //stopService(intent)- we pass the intent to stop the service
    //note- started service will be run until you won't call stopService(intent)
    /*note -doen't matter how many times you called startService(intent) but
    if want stop the service then call StopService(intent) then service will be stoped
     */
    //stopSelf() :- it called from inside service class to stop the service
    //to clled the stopSelf() we stop the service partial not fully
     /*note :-if you want use started service as long running operation then we have make
       another thread otherwise it will be block the ui and second option is use intent service
       because it run on background thread
      */
    //note :- if you want to stop the service the u have to call explicitly stopService()


    //it is runs first time
    override fun onCreate() {
        Log.d("excute", "onCreate")

        super.onCreate()
    }
    //onStartCommand() important for StartedService
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val song:String?=intent!!.getStringExtra("song")
        Log.d("excute", "onStartCommand")

        if(song !=null)
            DownLoadSongInBackground(song)
          // DownLoadSong(song)

        return START_REDELIVER_INTENT
    }


    /*in Started service and bound service in both case onBind method
    override but in Started service onBind() method return null
     */

    override fun onBind(p0: Intent?): IBinder? {
        Log.d("excute", "on Bind called")

        return null
    }



    //it called when when service is not longer being used
    override fun onDestroy() {
        Log.d("excute", "on Destroy")

        super.onDestroy()
    }

    //it freeze the ui becouse it running on main thread
    fun DownLoadSong(song :String)
    {
        Log.d("started", "DownLoading Song started : "+song)

        try {
            Thread.sleep(4000)
            Log.d("started", "DownLoading Song started : "+Thread.currentThread().name)

        }catch (exception:Exception)
        {
            exception.printStackTrace()
        }
        Log.d("started", "DownLoading Song complete: "+song)
        /*thread {
            Log.d("started", "DownLoading Song started : "+song)
            Log.d("started", "DownLoading Song started : "+Thread.currentThread().name)
            Thread.sleep(4000)
            Log.d("started", "DownLoading Song complete: "+song)
        }*/
    }

    //DownLoad song in backGrond
    fun DownLoadSongInBackground(song:String)
    {
        Log.d("started", "DownLoading Song started : "+song)


        thread {
            Thread.sleep(4000)
            Log.d("started", "DownLoading Song complete: "+song)

        }
    }


}