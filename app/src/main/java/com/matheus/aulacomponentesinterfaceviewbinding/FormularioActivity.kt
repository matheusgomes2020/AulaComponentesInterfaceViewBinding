package com.matheus.aulacomponentesinterfaceviewbinding

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.datepicker.OnSelectionChangedListener
import com.google.android.material.snackbar.Snackbar
import com.matheus.aulacomponentesinterfaceviewbinding.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView( binding.root )

        with(binding) {

            spinnerExibicao()

            btnEnviar.setOnClickListener { view ->


                spinnerSelecionarItem()
                //caixaDialogAlerta()
                //exibirSnackbar( view )
                //switchToggle()
               // radioButton()
                //checkbox()
            }



            /*
            rbMasculino.setOnClickListener {  }
            rbMasculino.setOnCheckedChangeListener {  buttonView, isChecked -> }
             */

            cbConfirmacao.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if (isChecked) "Sim" else "Não"
                textResultado.text = "valor selecionado: $resultado"
            }

            /*
            cbConfirmacao.setOnClickListener {
                val selecionado = binding.cbConfirmacao.isChecked
                val resultado = if (selecionado) "Sim" else "Não"
                textResultado.text = "valor selecionado: $resultado"
            }
             */

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun switchToggle() {

        val switchMarcado = binding.switchNotificacoes.isChecked
        val toggleMarcado = binding.toggleAtivo.isChecked

        val  texto = "&switch=$switchMarcado&toggle=$toggleMarcado"
        binding.textResultado.text = texto

    }

    private fun radioButton() {

        val masculino = binding.rbMasculino.isChecked

        //binding.textResultado.text = if ( masculino ) "Masculino" else "Feminino"

        val idItemSElecionado = binding.rgSexo.checkedRadioButtonId
        binding.textResultado.text = when (idItemSElecionado) {
            R.id.rbMasculino -> "Masculino"
            R.id.rbFeminino -> "Feminino"
            else -> "Nada selecionado"
        }

        binding.rgSexo.clearCheck()

        /*
        if (selecionadoMasculino) {

        } else if( binding.rbFeminino.isChecked ) {

        } else {

        }
        */

    }

    private fun checkbox() {
        val selecionado = binding.cbConfirmacao.isChecked
        val resultado = if (selecionado) "Sim" else "Não"
        binding.textResultado.text = "valor selecionado: $resultado"
    }

    private fun exibirSnackbar( view: View ) {

        val snackbar = Snackbar.make(view,
            "Alteração feita com sucesso",
            Snackbar.LENGTH_LONG
        )


        snackbar.setAction("Desfazer") {
            Toast.makeText(this, "Desfeito", Toast.LENGTH_SHORT).show()
        }

        /*snackbar.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.red
            )
        )

        snackbar.setBackgroundTint(
            ContextCompat.getColor(
                this,
                R.color.yellow
            )
        )
         */

        snackbar.show()


    }

    private fun caixaDialogAlerta() {

        AlertDialog.Builder(this)
        .setTitle("Confirmar exclusão do item?")
        .setMessage("Tem certeza que quer remover?")
            .setNegativeButton("cancelar") { dialog, posicao ->
                Toast.makeText(this, "Cancelar ($posicao)", Toast.LENGTH_SHORT).show() }
            .setPositiveButton("remover") { dialog, posicao ->
                Toast.makeText(this, "Remover ($posicao)", Toast.LENGTH_SHORT).show() }
                .setCancelable( false ).setNeutralButton( "ajuda" ) { dialog, posicao ->
                Toast.makeText(this, "Ajuda ($posicao)", Toast.LENGTH_SHORT).show() }
                    .setIcon(R.drawable.ic_alerta_24)
                    .create()
                    .show()

        /*
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Confirmar exclusão do item?")
        alertBuilder.setMessage("Tem certeza que quer remover?")

        alertBuilder.setNegativeButton("cancelar") { dialog, posicao ->
            Toast.makeText(this, "Cancelar ($posicao)", Toast.LENGTH_SHORT).show()
        }

        alertBuilder.setPositiveButton("remover") { dialog, posicao ->
            Toast.makeText(this, "Remover ($posicao)", Toast.LENGTH_SHORT).show()
        }

        alertBuilder.setCancelable( false )
        alertBuilder.setNeutralButton( "ajuda" ) { dialog, posicao ->
            Toast.makeText(this, "Ajuda ($posicao)", Toast.LENGTH_SHORT).show()
        }

        alertBuilder.setIcon(R.drawable.ic_alerta_24)

        val alertDialog = alertBuilder.create()
        alertDialog.show()
         */

    }

    private fun spinnerExibicao() {

        /*val categorias = listOf(
            "Selecione uma categoria",
            "Eletrônicos", "Roupas", "Móveis", "Roupas"
        )*/
        /*val categorias = resources.getStringArray(
            R.array.categorias
        )
        binding.spinnerCategorias.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            categorias
        )*/

        binding.spinnerCategorias.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.categorias,
            android.R.layout.simple_spinner_dropdown_item
        )

        /*binding.spinnerCategorias.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //val itemSelecionado = parent?.getItemAtPosition(position)
                val itemSelecionado = parent?.selectedItem
                binding.textResultado.text = itemSelecionado.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }*/

    }


    private fun spinnerSelecionarItem() {

        val itemSelecionado = binding.spinnerCategorias.selectedItemPosition
        val itemPosicao = binding.spinnerCategorias.selectedItemPosition

        if (itemSelecionado == 0) {
            binding.textResultado.text = "Selecione um item"
        } else {
            binding.textResultado.text = "item selecionado: $itemSelecionado - posição: $itemPosicao"
        }



    }

}