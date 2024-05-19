 package com.example.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchApiData()
    }


    fun fetchApiData() {

        CoroutineScope(Dispatchers.IO).launch {
            try{
                val apiKey = "3d4b58cf626544e18ce0417958e99817"
                val apiClient = MyApiClient(apiKey)

                val response = apiClient.fetchData()

                CoroutineScope(Dispatchers.Main).launch {
                    Log.d("@dhiru"," aaja  ${response.status}")
                        if (response.status == "ok") {


//                        val intent = Intent(this@MainActivity,ShowContent::class.java)
//                        startActivity(intent)
//                        finish()

                        Log.d("@dhiru", "${response.totalResults}")
                        // handle successful response
                    } else {
                        Toast.makeText(this@MainActivity,"Invalid credentials", Toast.LENGTH_LONG).show()
                        Log.d("@dhiru", "error")
                        // handle error response
                    }

                }
            }
            catch (e:Exception){
                Log.d("@dhiru","$e")
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(this@MainActivity, "Invalid credentials", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}