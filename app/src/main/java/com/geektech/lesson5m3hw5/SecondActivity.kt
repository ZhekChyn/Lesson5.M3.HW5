package com.geektech.lesson5m3hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.geektech.lesson5m3hw5.databinding.ActivityMainBinding
import com.geektech.lesson5m3hw5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra("key.fv")
        binding.etValue.setText(text)

        initListeners()
    }

    private fun initListeners() {
        binding.send.setOnClickListener {
            val intent = Intent()
            intent.putExtra("Result", binding.etValue.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}