package br.com.fiap.steamfinal.ui.activity.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import br.com.fiap.steamfinal.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TelaHomeActivityTest {


    @get:Rule
    val rule = ActivityTestRule<TelaHomeActivity>(TelaHomeActivity::class.java)

    @Test
    fun abrindoLojaDeJogos(){
        onView(withId(R.id.loja_home)).perform(click())
        onView(withId(R.id.fragment_loja_jogos_id)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun abrindoCarrinhoDeCompras(){
        onView(withId(R.id.carrinho_home)).perform(click())
        onView(withId(R.id.carrinho_compras_id)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun abrindoListagemAmigos(){
        onView(withId(R.id.amigos_home)).perform(click())
        onView(withId(R.id.amigos_id)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}