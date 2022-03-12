package br.com.fiap.steamfinal.ui.fragments.amigos

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.fiap.steamfinal.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AmigosFragmentTest {

    @Test
    fun listagemAmigosAbrindoCorretamente(){
        val cenario = launchFragmentInContainer<AmigosFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView_amigos))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


}