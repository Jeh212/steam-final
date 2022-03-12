package br.com.fiap.steamfinal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.model.Jogo

class CarrinhoAdapter(private var carrinho:ArrayList<Jogo>, var remove: RemoverJogo) : RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrinhoViewHolder {
        val carrinho = LayoutInflater.from(parent.context).inflate(R.layout.carrinho, parent, false)
        val holder = CarrinhoViewHolder(carrinho)
        return holder
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        holder.fotoJogoCarrinho.setImageResource(carrinho[position].foto)
        holder.nomeJogoCarrinho.text = carrinho[position].nome
        holder.botaoRemoverJogoCarrinho.setOnClickListener {
            println("$position   ----- POSICAL ATUAL")
            remove.removendoJogo(carrinho.get(holder.adapterPosition))
            this.carrinho.removeAt(holder.adapterPosition)
            this.notifyItemRemoved(holder.adapterPosition)
        }

    }

    interface RemoverJogo {
        fun removendoJogo(jogo:Jogo)
    }

    override fun getItemCount(): Int = carrinho.size

    inner class CarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoJogoCarrinho = itemView.findViewById<ImageView>(R.id.fotoJogoCarrinho)
        val nomeJogoCarrinho = itemView.findViewById<TextView>(R.id.nomeJogoCarrinho)
        val botaoRemoverJogoCarrinho = itemView.findViewById<Button>(R.id.remover_item)
    }
}