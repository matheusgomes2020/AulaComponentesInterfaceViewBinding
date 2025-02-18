package com.matheus.aulacomponentesinterfaceviewbinding

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.matheus.aulacomponentesinterfaceviewbinding.databinding.ActivityToolbarActionBarBinding

class ToolbarActionBarActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityToolbarActionBarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView( binding.root )
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarToolbar()


        //inicializarActionBar()

    }

    private fun inicializarToolbar() {

        binding.btnAbrirNova.setOnClickListener {
            startActivity(Intent(this, NovaActivity::class.java))
        }

        binding.includeToolbar.toolbarPrincipal.title = "Youtube"
        binding.includeToolbar.toolbarPrincipal.setTitleTextColor(
            ContextCompat.getColor(this, R.color.white)
        )
        /*
        binding.toolbarPrincipal.inflateMenu(R.menu.menu_principal)
        binding.toolbarPrincipal.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_adicionar -> {
                    Toast.makeText(applicationContext, "Adicionar", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_pesquisar -> {
                    Toast.makeText(applicationContext, "Pesquisar", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_configuracoes -> {
                    Toast.makeText(applicationContext, "Configurações", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_sair -> {
                    Toast.makeText(applicationContext, "Sair", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                else -> {
                    false
                }
            }
        }

         */
        //binding.toolbarPrincipal.setSubtitle("Descrição do vídeo")
        setSupportActionBar( binding.includeToolbar.toolbarPrincipal )
        inicializarActionBar()
    }

    private fun inicializarActionBar() {

        addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_principal, menu)
                }
                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when (menuItem.itemId) {
                        R.id.item_adicionar -> Toast.makeText(applicationContext, "Adicionar", Toast.LENGTH_SHORT).show()
                        R.id.item_pesquisar -> Toast.makeText(applicationContext, "Pesquisar", Toast.LENGTH_SHORT).show()
                        R.id.item_configuracoes ->  Toast.makeText(applicationContext, "Configurações", Toast.LENGTH_SHORT).show()
                        R.id.item_sair -> Toast.makeText(applicationContext, "Sair", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            }
        )
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_principal, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.item_adicionar -> {
//                Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
//            }
//            R.id.item_pesquisar -> {
//                Toast.makeText(this, "Pesquisar", Toast.LENGTH_SHORT).show()
//            }
//            R.id.item_configuracoes -> {
//                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
//            }
//            R.id.item_sair -> {
//                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//
//        return true
//    }

}