package br.com.fiap.steamfinal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.model.Amigos

class AmigosAdapter(private val amigos: MutableList<Amigos>) : RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmigosViewHolder {
        val amigos = LayoutInflater.from(parent.context).inflate(R.layout.amigos, parent, false)
        val holder = AmigosViewHolder(amigos)
        return holder
    }

    override fun onBindViewHolder(holder: AmigosViewHolder, position: Int) {
        holder.foto.setImageResource(amigos[position].foto)
        holder.nomeUsuario.text = amigos[position].nomeUsuario
        holder.nomeJogoExecutdo.text = amigos[position].nomeJogoExecutado

    }

    override fun getItemCount(): Int = amigos.size

    inner class AmigosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.fotoAmigo)
        val nomeUsuario = itemView.findViewById<TextView>(R.id.nomeAmigo)
        val nomeJogoExecutdo = itemView.findViewById<TextView>(R.id.jogoExecutando)
    }
}