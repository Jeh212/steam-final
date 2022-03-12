package br.com.fiap.steamfinal.db.entity

import br.com.fiap.steamfinal.model.Jogo

data class JogoEntity (

    var id: Int = 0,
    var nome: String = "",
    var descricao: String = "",
    var categoria: String = "",
    var preco: String = ""
)

fun JogoEntity.toJogo() : Jogo {
    return Jogo (
            foto = 0,
            id = this.id,
            nome = this.nome,
            descricao = this.descricao,
            categoria = this.categoria,
            preco = this.preco
            )
}