package br.com.fiap.steamfinal.ui.fragments.amigos

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.adapter.AmigosAdapter
import br.com.fiap.steamfinal.model.Amigos
import java.util.*

class AmigosPresenter(private val view: AmigosContrato.AmigosView) : AmigosContrato.AmigosPresenter {

    override fun obtemListaAmigos() {
        view.mostraAmigos(addListAmigos())
    }


    private fun addListAmigos() : MutableList<Amigos>{
            return Arrays.asList(Amigos (R.drawable.haakzao,"Marcos","Counter-Strike: Global Offensive"),
            Amigos (R.drawable.hideki,"Jean","Counter-Strike: Global Offensive"),
            Amigos (R.drawable.zoro,"Shino","Counter-Strike: Global Offensive"),
            Amigos (R.drawable.hisoka,"Rodrigo","Counter-Strike: Global Offensive")
            )
    }
}