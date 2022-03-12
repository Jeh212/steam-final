package br.com.fiap.steamfinal.ui.fragments.amigos

import br.com.fiap.steamfinal.model.Amigos

interface AmigosContrato {

    interface AmigosView {
        fun mostraAmigos(list :MutableList<Amigos>)
    }

    interface AmigosPresenter {
        fun obtemListaAmigos()
    }
}