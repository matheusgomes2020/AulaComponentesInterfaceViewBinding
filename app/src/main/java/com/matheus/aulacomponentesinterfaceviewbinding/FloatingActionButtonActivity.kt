package com.matheus.aulacomponentesinterfaceviewbinding

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.matheus.aulacomponentesinterfaceviewbinding.databinding.ActivityFloatingActionButtonBinding

class FloatingActionButtonActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFloatingActionButtonBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView( binding.root )

        with(binding) {
            fabBotao.setOnClickListener {

                groupMenu.visibility = if (groupMenu.isVisible) {
                    View.INVISIBLE
                } else {
                    View.VISIBLE
                }

            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}