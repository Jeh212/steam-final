package br.com.fiap.steamfinal.ui.activity.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.steamfinal.databinding.ActivityMainBinding
import br.com.fiap.steamfinal.ui.activity.home.TelaHomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar!!.hide()

        val mainPresenter = MainPresenter(this)
        mainPresenter.inserirJogosNaTabelaTbJogos()

        binding.buttonIniciarSessao.setOnClickListener{
            val intent = Intent(this, TelaHomeActivity::class.java)
            startActivity(intent)
        }
    }
}