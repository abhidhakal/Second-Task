package com.example.task2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var messageBinding : ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var username : String? = null
    var password : String? = null
    var checkbox : Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        messageBinding = ActivityMainBinding.inflate(layoutInflater)
        var view = messageBinding.root
        setContentView(view)

        messageBinding.loginBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, DashBoard::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        sharedPreferences = this.getSharedPreferences("userValue", MODE_PRIVATE)

        username = messageBinding.usernamebar.text.toString()
        password = messageBinding.passwordbar.text.toString()
        checkbox = messageBinding.rememberme.isChecked

        var editor = sharedPreferences.edit()
        editor.putString("username",username)
        editor.putString("message",password)
        editor.putBoolean("checkbox",checkbox!!)

        editor.apply()

        super.onPause()

        Toast.makeText(applicationContext,"data saved",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        sharedPreferences = this.getSharedPreferences("userValue", MODE_PRIVATE)

        username = sharedPreferences.getString("username","")
        password = sharedPreferences.getString("message","")
        checkbox = sharedPreferences.getBoolean("remember",false)

        messageBinding.usernamebar.setText(username)
        messageBinding.passwordbar.setText(password)
        messageBinding.rememberme.isChecked=checkbox!!

        super.onResume()
    }
}