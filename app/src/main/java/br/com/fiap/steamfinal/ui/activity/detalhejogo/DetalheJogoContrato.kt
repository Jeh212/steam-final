package br.com.fiap.steamfinal.ui.activity.detalhejogo

import br.com.fiap.steamfinal.model.Jogo

interface DetalheJogoContrato {

    interface DetalheJogoView {
        fun mostraCarousel(int:IntArray)
        fun mostraDetalhesJogo(jogo: Jogo)
        fun adicionandoJogoCarrinho(adicionado: Boolean)
        fun mostraBotaoAdicionaCarrinho(opcao: Boolean)
    }

    interface DetalheJogoPresenter {
        fun getCarrouselView()
        fun getDetalhesJogo()
        fun getDetalhesJogoParaMandarAoCarrinho()
        fun verificaJogoExisteCarrinho()
    }
}