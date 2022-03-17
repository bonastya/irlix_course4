package com.example.irlix_course4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import com.example.irlix_course4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var mImgNumber = 1

    companion object{
        const val REQUEST_CODE = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val imageView = binding.imageView
        val view = binding.root
        setContentView(view)

        var button = binding.button

        button.setOnClickListener {
            val questionIntent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivityForResult(questionIntent, REQUEST_CODE)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = binding.imageView


        if (requestCode == REQUEST_CODE) {
            imageView.setImageResource(getImgId(resultCode))
            mImgNumber=resultCode
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putInt("KEY", mImgNumber)
        }
        super.onSaveInstanceState(outState)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        var key = 1
        savedInstanceState?.run {
            key = getInt("KEY", 1)
        }
        mImgNumber = key
        val imageView = binding.imageView
        imageView.setImageResource(getImgId(key))
        super.onRestoreInstanceState(savedInstanceState)
    }


    private fun getImgId(i:Int): Int {
        return when (i) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            else -> R.drawable.three
        }

    }

}