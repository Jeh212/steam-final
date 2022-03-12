package br.com.fiap.steamfinal.ui.fragments.lojajogos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.adapter.AdapterJogo
import br.com.fiap.steamfinal.model.Jogo
import br.com.fiap.steamfinal.ui.activity.detalhejogo.DetalhesJogoActivity

class LojaJogosFragment : Fragment(), AdapterJogo.ClickJogo, LojaJogosContrato.LojaJogosView {

    private var recyclerView : RecyclerView? = null
    private var jogosAdapter : AdapterJogo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_loja_jogos, container, false)

        configurationRecyclerView(view)

        val presenter = LojaJogosPresenter(requireContext(), this)
        presenter.obtemJogos()
        return view
    }

    private fun configurationRecyclerView(view: View){
        recyclerView = view.findViewById(R.id.recyclerView_jogos)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.setHasFixedSize(true)
    }

    override fun clickJogo(jogo: Jogo) {
        val intent = Intent(requireContext(), DetalhesJogoActivity::class.java)
        intent.putExtra("jogoClicado", jogo)
        startActivity(intent)
    }

    override fun mostraJogos(list: java.util.ArrayList<Jogo>) {
        jogosAdapter = AdapterJogo(list, this)
        recyclerView?.adapter = jogosAdapter
    }

}