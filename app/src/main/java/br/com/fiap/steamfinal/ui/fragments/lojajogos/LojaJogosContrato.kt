package br.com.fiap.steamfinal.ui.fragments.lojajogos

import br.com.fiap.steamfinal.model.Jogo
import java.util.ArrayList

interface LojaJogosContrato {

    interface LojaJogosView {
        fun mostraJogos(list : ArrayList<Jogo>)
    }

    interface LojaJogosPresenter {
        fun obtemJogos()
    }
}