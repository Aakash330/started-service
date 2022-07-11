package com.example.startedservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.startedservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartservice.setOnClickListener {
             runService()

        }
        binding.btnStop.setOnClickListener{
            stopService()
        }


    }



    private fun runService() {
     for (song :String in SimpleData.getSong())
        {
       val intent=Intent(this@MainActivity,StartedService::class.java)
            intent.putExtra("song",song)
            startService(intent)
        }
    }

    private fun stopService() {

        val intent=Intent(this@MainActivity,StartedService::class.java)
        stopService(intent)
        Toast.makeText(this@MainActivity, "service stopped ", Toast.LENGTH_SHORT).show()
    }
}