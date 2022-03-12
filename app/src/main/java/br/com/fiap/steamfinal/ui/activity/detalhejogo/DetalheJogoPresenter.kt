package br.com.fiap.steamfinal.ui.activity.detalhejogo

import android.content.SharedPreferences
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.model.Carrinho
import br.com.fiap.steamfinal.model.Jogo
import com.google.gson.Gson
import java.lang.Exception
import java.lang.RuntimeException

class DetalheJogoPresenter(
    var jogo: Jogo,
    val view: DetalheJogoContrato.DetalheJogoView,
    val sharedPreferences: SharedPreferences
) : DetalheJogoContrato.DetalheJogoPresenter {
    override fun getCarrouselView() {
        view.mostraCarousel(verificaJogo(jogo.id))
    }

    override fun getDetalhesJogo() {
        view.mostraDetalhesJogo(jogo)
    }

    override fun getDetalhesJogoParaMandarAoCarrinho() {
        try {
            val gson = Gson()
            val carrinho = sharedPreferences.getString("carrinho", null) //Buscando carrinho no preferences
            var objectCarrinho: Carrinho? = null
            if (carrinho == null) {
                objectCarrinho = Carrinho(ArrayList<Jogo>()) //Criando um novo objeto carrinho, caso não há nenhum adicionado
            } else {
                objectCarrinho = gson.fromJson(carrinho, Carrinho::class.java)
            }

            objectCarrinho!!.jogo.add(jogo)

            val edit = sharedPreferences.edit()
            val jsonString = gson.toJson(objectCarrinho)
            edit.putString("carrinho", jsonString)
            edit.apply()
            view.adicionandoJogoCarrinho(true)

        }catch (ex: RuntimeException){
            view.adicionandoJogoCarrinho(false)
        }

    }

    override fun verificaJogoExisteCarrinho() {
        val gson = Gson()
        val carrinho = sharedPreferences.getString("carrinho", null)

        if(carrinho != null){
            val objectCarrinho = gson.fromJson(carrinho, Carrinho::class.java)
            view.mostraBotaoAdicionaCarrinho(true)
            for(item in objectCarrinho.jogo){
               if(jogo.nome.equals(item.nome)){
                   view.mostraBotaoAdicionaCarrinho(false)
                   break
               }
            }
        } else {
            view.mostraBotaoAdicionaCarrinho(true)
        }

    }

    fun verificaJogo(id:Int) : IntArray {
        if("1".equals(id.toString())){
            return intArrayOf(
                R.drawable.csgo1,
                R.drawable.csgo2,
                R.drawable.csgo3,
                R.drawable.csgo4,
                R.drawable.csgo5
            )
        } else if ("2".equals(id.toString())) {
            return intArrayOf(
                R.drawable.dbdmain,
                R.drawable.dbd1,
                R.drawable.dbd2,
                R.drawable.dbd3,
                R.drawable.dbd4)
        }
        return intArrayOf()
    }


}