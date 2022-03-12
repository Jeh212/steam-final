package br.com.fiap.steamfinal.ui.activity.detalhejogo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.databinding.ActivityDetalhesJogoBinding
import br.com.fiap.steamfinal.model.Jogo

class DetalhesJogoActivity : AppCompatActivity(), DetalheJogoContrato.DetalheJogoView {

    lateinit var binding: ActivityDetalhesJogoBinding

    var jogo: Jogo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesJogoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar!!.hide()

        jogo = intent.getParcelableExtra("jogoClicado")
        if(jogo != null){
            val presenter = DetalheJogoPresenter(jogo!!, this, getSharedPreferences("jogoSendoAdicionadoCarrinho", Context.MODE_PRIVATE))
            presenter.getCarrouselView()
            presenter.getDetalhesJogo()
            presenter.verificaJogoExisteCarrinho()
            if(binding.idBotaoCarrinhoAdd.isEnabled){
                binding.idBotaoCarrinhoAdd.setOnClickListener {
                    binding.idBotaoCarrinhoAdd.isEnabled = false
                    presenter.getDetalhesJogoParaMandarAoCarrinho()
                }
            }
        }

    }

    override fun mostraCarousel(img:IntArray) {
        binding.carouselView.pageCount = img.size
        binding.carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(img[position])
        }
    }

    override fun mostraDetalhesJogo(jogo: Jogo) {
        binding.nomeJogoTx.text = jogo.nome
        binding.idCategoria.text = jogo.categoria
        binding.idDescricaoJogo.text = jogo.descricao
    }

    override fun adicionandoJogoCarrinho(adicionado: Boolean) {
        if(adicionado){
            Toast.makeText(this, "Adicionado ao carrinho", Toast.LENGTH_SHORT).show()
        }
    }

    override fun mostraBotaoAdicionaCarrinho(opcao: Boolean) {
        binding.idBotaoCarrinhoAdd.isEnabled = opcao
    }
}