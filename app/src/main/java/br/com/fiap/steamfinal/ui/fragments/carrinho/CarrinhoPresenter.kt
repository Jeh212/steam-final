package br.com.fiap.steamfinal.ui.fragments.carrinho

import android.content.SharedPreferences
import br.com.fiap.steamfinal.model.Carrinho
import br.com.fiap.steamfinal.model.Jogo
import br.com.fiap.steamfinal.ui.fragments.amigos.AmigosContrato
import com.google.gson.Gson

class CarrinhoPresenter(
    private val view: CarrinhoContrato.CarrinhoView,
    val sharedPreferences: SharedPreferences?, ) : CarrinhoContrato.CarrinhoPresenter {

    var carrinhoList = ArrayList<Jogo>()

    override fun obtemCarrinho() {
        view.mostraCarrinho(populandoJogo() ?: ArrayList<Jogo>())
    }

    fun populandoJogo() : ArrayList<Jogo>{
        val jogoJson = sharedPreferences?.getString("carrinho", null)
        if(jogoJson != null){
            val gson = Gson()
            val jogoObject = gson.fromJson(jogoJson, Carrinho::class.java)
            carrinhoList = jogoObject.jogo
        }
        return carrinhoList
    }
}