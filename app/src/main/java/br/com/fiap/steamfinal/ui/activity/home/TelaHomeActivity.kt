package br.com.fiap.steamfinal.ui.activity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.ui.fragments.amigos.AmigosFragment
import br.com.fiap.steamfinal.ui.fragments.carrinho.CarrinhoFragment
import br.com.fiap.steamfinal.ui.fragments.lojajogos.LojaJogosFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaHomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var amigosFragment: AmigosFragment
    private lateinit var lojaJogosFragment: LojaJogosFragment
    private lateinit var carrinhoFragment: CarrinhoFragment
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_home)

        supportActionBar!!.hide()

        amigosFragment = AmigosFragment()
        lojaJogosFragment = LojaJogosFragment()
        carrinhoFragment = CarrinhoFragment()

        bottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener (this)

        setFragment(lojaJogosFragment)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.loja_home -> {
                setFragment(lojaJogosFragment)
            }
            R.id.carrinho_home -> {
                setFragment(carrinhoFragment)
            }
            R.id.amigos_home -> {
                setFragment(amigosFragment)
            }
        }
        return true
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragments, fragment)
        fragmentTransaction.commit()
    }

}