package br.com.fiap.steamfinal.ui.fragments.lojajogos

import android.content.Context
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.db.dao.JogoDAO
import br.com.fiap.steamfinal.db.entity.JogoEntity
import br.com.fiap.steamfinal.db.entity.toJogo
import br.com.fiap.steamfinal.model.Jogo
import java.util.*

class LojaJogosPresenter(private val context: Context,
                         private val view: LojaJogosContrato.LojaJogosView) : LojaJogosContrato.LojaJogosPresenter {
    override fun obtemJogos() {
        view.mostraJogos(buscarJogosDB())
    }


    private fun buscarJogosDB() : ArrayList<Jogo>{
        val jogoDAO = JogoDAO(context)
        val listagemJogos = jogoDAO.listar()
        val arrayList = ArrayList<Jogo>()
        for (item in listagemJogos){
            val jogo = item.toJogo()
            jogo.foto = pegarFotoJogoById(item.id)
            arrayList.add(jogo)
        }
        return arrayList
    }

    fun pegarFotoJogoById(id: Int) : Int {
        if ("1".equals(id.toString())){
            return R.drawable.csgo
        } else if ("2".equals(id.toString())){
            return R.drawable.dbd
        }
        return 0
    }
}