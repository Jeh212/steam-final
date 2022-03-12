package br.com.fiap.steamfinal.ui.fragments.carrinho

import br.com.fiap.steamfinal.model.Jogo

interface CarrinhoContrato {

    interface CarrinhoView {
        fun mostraCarrinho(list :ArrayList<Jogo>)
    }

    interface CarrinhoPresenter {
        fun obtemCarrinho()
    }
}