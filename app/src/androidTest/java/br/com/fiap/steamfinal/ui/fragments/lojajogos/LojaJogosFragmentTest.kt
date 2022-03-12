package br.com.fiap.steamfinal.ui.fragments.lojajogos

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.adapter.AdapterJogo
import br.com.fiap.steamfinal.db.entity.JogoEntity
import br.com.fiap.steamfinal.model.Jogo
import br.com.fiap.steamfinal.ui.fragments.carrinho.CarrinhoFragment
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class LojaJogosFragmentTest {

    @Test
    fun listagemJogosAbrindoCorretamente(){
        val cenario = launchFragmentInContainer<LojaJogosFragment>()
        onView(withId(R.id.recyclerView_jogos)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun escolhendoPrimeiroItemParaVerificarODetalheDoJogo(){
        val cenario = launchFragmentInContainer<LojaJogosFragment>()
        onView(withId(R.id.recyclerView_jogos)).perform(actionOnItemAtPosition<AdapterJogo.JogoViewHolder>(0, click()))
        onView(withId(R.id.detalhes_jogo_id)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}