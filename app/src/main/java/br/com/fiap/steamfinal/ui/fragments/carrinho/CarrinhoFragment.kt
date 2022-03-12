package br.com.fiap.steamfinal.ui.fragments.carrinho

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.adapter.CarrinhoAdapter
import br.com.fiap.steamfinal.model.Carrinho
import br.com.fiap.steamfinal.model.Jogo
import com.google.gson.Gson

class CarrinhoFragment : Fragment(), CarrinhoContrato.CarrinhoView, CarrinhoAdapter.RemoverJogo {

    private var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carrinho, container, false)

        configurationRecyclerView(view)

        val presenter = CarrinhoPresenter(this, this.activity?.getSharedPreferences("jogoSendoAdicionadoCarrinho", Context.MODE_PRIVATE))
        presenter.obtemCarrinho()

        return view
    }

    private fun configurationRecyclerView(view: View){
        recyclerView = view.findViewById(R.id.recyclerView_carrinho)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.setHasFixedSize(true)
    }

    override fun mostraCarrinho(list: ArrayList<Jogo>) {
        recyclerView?.adapter = CarrinhoAdapter(list, this)

    }

    override fun removendoJogo(jogo: Jogo) {
        val sharedPreferences = this.activity?.getSharedPreferences("jogoSendoAdicionadoCarrinho", Context.MODE_PRIVATE)
        val jogoJson = sharedPreferences?.getString("carrinho", "")
       println(jogoJson)
        val gson = Gson()
        val jogoObject = gson.fromJson(jogoJson, Carrinho::class.java)
        jogoObject.jogo.remove(jogo)

        val toJson = gson.toJson(jogoObject)
        println(toJson)
        val edit = sharedPreferences?.edit()
        edit?.putString("carrinho", toJson)
        edit?.apply()


    }

}