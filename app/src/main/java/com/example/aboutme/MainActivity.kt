package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myName : MyName = MyName("Florencia Olivera")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // It's to bind data between layout and main activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }

    }

    private fun addNickname(view : View) {

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()

            invalidateAll() // to can refresh properties
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
