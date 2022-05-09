/*
package com.example.wordsapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
//1) Specify a test runner if you haven't already.
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    //2)Create a test function called navigate_to_words_nav_component().
    //3)Working with Navigation Components in tests requires some setup.
    // In the navigate_to_words_nav_component() method, create a test instance of the navigation controller.
    @Test
    fun navigate_to_words_nav_component() {
    val navController = TestNavHostController(
        ApplicationProvider.getApplicationContext()
    )
    //4) Navigation Components drive the UI using Fragments. There is a fragment equivalent of ActivityScenarioRule that
    //can be used to isolate a fragment for testing,which is why the fragment-specific dependency is required.
    // This can be very useful for testing a fragment that requires a lot of navigation to reach, because it can instead be
    // launched without any additional code to handle navigating to it.
    val letterListScenario = launchFragmentInContainer<LetterListFragment>(themeResId =
    R.style.Theme_Words)
    //5) Lastly, we need to explicitly declare which navigation graph we want the nav controller to use for the fragment launched.
    letterListScenario.onFragment { fragment ->

        navController.setGraph(R.navigation.nav_graph)

        Navigation.setViewNavController(fragment.requireView(), navController)
    }
    //6) Now trigger the event that prompts the navigation.
    onView(withId(R.id.recycler_view))
    .perform(RecyclerViewActions
    .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
    assertEquals(navController.currentDestination?.id, R.id.wordListFragment)
}
}*/
