package br.com.fiap.steamfinal.ui.activity.main

import android.content.Context
import br.com.fiap.steamfinal.db.dao.JogoDAO
import br.com.fiap.steamfinal.db.entity.JogoEntity

class MainPresenter(private var cxt:Context) : MainContrato.ContratoPresenter {
    override fun inserirJogosNaTabelaTbJogos() {
        val jogoDAO = JogoDAO(cxt)
        val jogo1 = JogoEntity(
            1,
            "Counter Strike: Global Offensive",
            "O Counter-Strike: Global Offensive (CS:GO) melhora a jogabilidade de ação baseada em equipes na qual foi pioneiro quando lançado há 19 anos. O CS:GO contém novos mapas, personagens e armas, além de contar com versões atualizadas de conteúdos do CS clássico (como de_dust2).",
            "FPS",
            "R$25,00"
        )
        val jogo2 = JogoEntity(
            2,
            "Dead By Daylight",
            "Dead by Daylight é um jogo de terror multiplayer (4vs1) onde um jogador assume o papel do assassino selvagem, e os outros quatro jogadores jogam como sobreviventes, tentando escapar do assassino e evitar ser pego e morto.",
            "Terror",
            "R$49,00"
        )
        jogoDAO.adicionarJogo(jogo1)
        jogoDAO.adicionarJogo(jogo2)
    }


}