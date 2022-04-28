package com.geektech.lesson5m3hw5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.geektech.lesson5m3hw5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var launchForResult = registerForActivityResult(
        StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val text = result.data?.getStringExtra("Result")
            binding.etValue.setText(text)
        }
    }

    private var name = "Zhyrgalbek"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.send.setOnClickListener {
            if (binding.etValue.text.isNotEmpty()){
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("key.fv", binding.etValue.text.toString())
                launchForResult.launch(intent)
            } else{
                Toast.makeText(this, "Edit text can not be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}