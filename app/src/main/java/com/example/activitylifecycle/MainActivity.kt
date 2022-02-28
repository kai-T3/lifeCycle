package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.mymodels.MyData

class MainActivity : AppCompatActivity() {

    private lateinit var myValue: MyData
    //var myValue: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "onCreate")
        //create an object, will not be destroyed after activity is destroyed
        myValue = ViewModelProvider(this).get(com.example.activitylifecycle.mymodels.MyData::class.java)

        val btn: Button = findViewById(R.id.btnOk)
        val tvName: TextView = findViewById(R.id.tvName)
        val tvAge: TextView = findViewById(R.id.tvAge)

        myValue.name.observe(this, Observer {
            newName -> tvName.text = newName
        })
        myValue.age.observe(this, Observer {
                newAge -> tvAge.text = newAge.toString()
        })

//        //if null, first time
//        if(savedInstanceState != null){
//            myValue = savedInstanceState.getString("value").toString();
//            tv.text = myValue
//        }

        if (myValue.name.value!= ""){
            //tv.text = myValue.name.value.toString()
        }

        btn.setOnClickListener(){
            myValue.name.value = "John"
            myValue.age.value = 21
            //display()
//            //after clicking btn OK
//            tv.text = myValue.name
        }
    }

//    //to save data's state without losing value
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("value", myValue)
//    }

//    fun display(){
//        val tv: TextView = findViewById(R.id.tvResult)
//    }


    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }
}