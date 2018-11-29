package ca.bcit.engineering.project.zilong.dt2scores.feature;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import ca.bcit.engineering.project.zilong.dt2scores.feature.model.Match;
import ca.bcit.engineering.project.zilong.dt2scores.feature.model.MatchData;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isJavascriptEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test for Main Acidity and Search Result
 */
@RunWith(AndroidJUnit4.class)
public class TestMainActivity {

    private List<Match> matchList;

    public static String NO_RESULT_FOUND = "No Result";


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * get the fragment manager
     */
    @Before
    public void init() {
        mActivityRule.getActivity()
                .getSupportFragmentManager().beginTransaction();

        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        matchList = MatchData.getMatchList();

        if (matchList.size() < 2) {
            throw new RuntimeException("Must take two photos first to set up for app test.");
        }
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("ca.bcit.engineering.project.zilong.dt2scores.feature.test", appContext.getPackageName());
    }

    /**
     * test the start of the app
     */
    @Test
    public void testMenuLoad() {
        Log.d("TestMainActivity", "testMenuLoad");

        onView(withId(R.id.ViewPager)).check(matches((isDisplayed())));
        onView(withId(R.id.navigation)).check(matches((isDisplayed())));
        onView(withId(R.id.navigation_score)).check(matches((isDisplayed())));
        onView(withId(R.id.navigation_news)).check(matches((isDisplayed())));
        onView(withId(R.id.navigation_video)).check(matches((isDisplayed())));

    }


    /**
     * test the start of the app
     */
    @Test
    public void testMatchLoad() {
        Log.d("TestMainActivity", "testMatchLoad");
        onView(withId(R.id.navigation_score)).check(matches((isDisplayed()))).perform(click());
        onView(withId(R.id.list)).check(matches((isDisplayed())));

    }

    @Test
    public void testNewsLoad() {
        Log.d("TestMainActivity", "testNewsLoad");
        onView(withId(R.id.navigation_news)).check(matches((isDisplayed()))).perform(click());

//        onWebView(Matchers.allOf(isDisplayed(), isJavascriptEnabled()))
//                .withElement(findElement(Locator.TAG_NAME, "article"))
//                .perform(webClick());
    }

    @Test
    public void testVideoLoad() {
        Log.d("TestMainActivity", "testVideoLoad");
        onView(withId(R.id.navigation_video)).check(matches((isDisplayed()))).perform(click());

//        onWebView(Matchers.allOf(isDisplayed(), isJavascriptEnabled()))
//                .withElement(findElement(Locator.CLASS_NAME, "compact-media-item"))
//                .perform(webClick());
    }
}
