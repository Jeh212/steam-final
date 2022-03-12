package br.com.fiap.steamfinal.ui.activity.detalhejogo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
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
class DetalhesJogoActivityTest {

    @get:Rule
    val rule = ActivityTestRule<DetalhesJogoActivity>(DetalhesJogoActivity::class.java)

    @Test
    fun abrindoCarouselView(){
        onView(withId(R.id.carousel_view)).check(matches(isDisplayed()))
    }


}