
package com.openclassrooms.entrevoisins.neighbour_list;


import android.support.test.espresso.contrib.RecyclerViewActions;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;

import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;

import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    private List<Neighbour> mNeighbourList = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;



    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);


    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT-1));
    }


    /**
     * When we click on one neighbour, the detail page will be displayed
     */
    @Test
    public void myNeighboursList_selectedNeighbour_shouldDisplayDetailPage() {
        // Given : We click on one neighbour to get DetailActivity
        onView(withId(R.id.list_neighbours)).check(matches(isDisplayed())) ;
                // When perform a click  on one neighbour
        onView(withId(R.id.list_neighbours)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        // Then : Open DetailActivity
        onView(withId(R.id.frame_layout_detail_activity)).check(matches(isDisplayed())) ;
    }

    /**
     * When the detail page are opened , we check that the Name of the current neighbour are displayed
     */
    @Test
    public void myNeighbourDetail_selectedNeighbour_shouldDisplayNeighbourName() {

        // Given : We click on one neighbour to get DetailActivity
        onView(withId(R.id.list_neighbours)).check(matches(isDisplayed())) ;
        // When perform a click  on one neighbour
        onView(withId(R.id.list_neighbours)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.frame_layout_detail_activity)).check(matches(isDisplayed())) ;
        // Then : ensure that the neighbour name are the same of the selected neighbour
        onView(withId(R.id.title_TextView)).check(matches(withText(mNeighbourList.get(0).getName()))) ;
    }

    /**
     * Show favorites neighbours (only favorites neighbours) in favorites list
     */
    @Test
    public void myFavoritesNeighbours_scrollAction_ShouldDisplayOnlyFavoritesNeighbours() {

        // Given : Favorites list is not null (just 1 item)
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.frame_layout_detail_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.floating_Button))
                .perform(click());
        onView(withId(R.id.ac_return))
                .perform(click());
        onView(withId(R.id.main_content)).check(matches(isDisplayed())) ;
        // scroll to favorites tab with Click event (like swipe or scroll move)
        onView(withText("FAVORITES")).perform(scrollTo(),click());
        // Show favorites neighbours (only favorites neighbours)
        onView(withId(R.id.Favorites_RecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.frame_layout_detail_activity)).check(matches(isDisplayed()));
        // Then : ensure that the neighbour name are the same of the selected neighbour
        onView(withId(R.id.title_TextView)).check(matches(withText(this.mNeighbourList.get(0).getName())));
    }
}