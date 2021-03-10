package com.akexorcist.lovelyrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akexorcist.lovelyrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
