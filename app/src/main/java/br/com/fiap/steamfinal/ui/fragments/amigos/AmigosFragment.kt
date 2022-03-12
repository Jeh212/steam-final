package br.com.fiap.steamfinal.ui.fragments.amigos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.adapter.AmigosAdapter
import br.com.fiap.steamfinal.model.Amigos
import br.com.fiap.steamfinal.ui.fragments.carrinho.CarrinhoPresenter

class AmigosFragment : Fragment(), AmigosContrato.AmigosView {

    private var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_amigos, container, false)

        configurationRecyclerView(view)

        val presenter = AmigosPresenter(
            this)
        presenter.obtemListaAmigos()

        return view
    }



    private fun configurationRecyclerView(view: View){
        recyclerView = view.findViewById(R.id.recyclerView_amigos)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.setHasFixedSize(true)
    }

    override fun mostraAmigos(list: MutableList<Amigos>) {
        recyclerView?.adapter = AmigosAdapter(list)
    }



}