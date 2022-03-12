package br.com.fiap.steamfinal.ui.fragments.carrinho


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import br.com.fiap.steamfinal.R
import br.com.fiap.steamfinal.adapter.CarrinhoAdapter
import br.com.fiap.steamfinal.ui.activity.main.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CarrinhoFragmentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun carrinhoActivityTest() {
        Thread.sleep(500)

        onView(withId(R.id.button_iniciar_sessao)).perform(click())

        Thread.sleep(700)

        onView(withId(R.id.recyclerView_jogos)).perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        Thread.sleep(700)

        onView(withId(R.id.id_botao_carrinho_add)).perform(click())

        pressBack()

        Thread.sleep(700)

        onView(withId(R.id.recyclerView_jogos)).perform(actionOnItemAtPosition<ViewHolder>(1, click()))

        Thread.sleep(700)

        onView(withId(R.id.id_botao_carrinho_add)).perform(click())

        pressBack()

        Thread.sleep(700)

        onView(withId(R.id.carrinho_home)).perform(click())

        onView(withId(R.id.recyclerView_carrinho)).check(ViewAssertions.matches(isDisplayed()))

    }
    
}
