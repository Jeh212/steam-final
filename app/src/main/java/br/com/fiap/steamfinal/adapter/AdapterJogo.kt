package br.com.fiap.steamfinal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.model.Jogo
import java.util.ArrayList

class AdapterJogo(private val jogos: ArrayList<Jogo>, var clickJogo : ClickJogo): RecyclerView.Adapter<AdapterJogo.JogoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val jogoLista = LayoutInflater.from(parent.context).inflate(R.layout.jogos, parent, false)
        val holder = JogoViewHolder(jogoLista)
        return holder
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        holder.foto.setImageResource(jogos[position].foto)
        holder.nome.text = jogos[position].nome
        holder.descricao.text = jogos[position].descricao
        holder.preco.text = jogos[position].preco


        holder.constraintLayout.setOnClickListener{
            clickJogo.clickJogo(jogos.get(position))

        }
    }

    interface ClickJogo {
        fun clickJogo(jogo: Jogo)
    }

    override fun getItemCount(): Int = jogos.size

    inner class JogoViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.fotoJogo)
        val nome = itemView.findViewById<TextView>(R.id.nomeJogo)
        val descricao = itemView.findViewById<TextView>(R.id.descricaoJogo)
        val preco = itemView.findViewById<TextView>(R.id.precoJogo)


        val constraintLayout = itemView.findViewById<ConstraintLayout>(R.id.item_jogo)
    }
}