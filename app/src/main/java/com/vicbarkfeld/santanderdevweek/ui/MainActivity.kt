package com.vicbarkfeld.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vicbarkfeld.santanderdevweek.R
import com.vicbarkfeld.santanderdevweek.data.Conta

    class MainActivity : AppCompatActivity() {

        private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            result.bindOnView()
        })
    }

   private fun Conta.bindOnView() {
        findViewById<TextView>(R.id.tv_agencia).text = agencia
        findViewById<TextView>(R.id.tv_conta_corrente).text = numero
        findViewById<TextView>(R.id.tv_saldo).text = saldo
        findViewById<TextView>(R.id.tv_saldo_limite).text = limite
        findViewById<TextView>(R.id.tv_usuario).text = cliente.nome
        findViewById<TextView>(R.id.tv_cartao_final_value).text = cartao.numeroCartao
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("CLICK", "Click no item 1")
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }
}