/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0603b_bottomnavigationview.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import labs.dadm.l0603b_bottomnavigationview.R;
import labs.dadm.l0603b_bottomnavigationview.fragments.GridImageFragment;
import labs.dadm.l0603b_bottomnavigationview.fragments.ListStringFragment;
import labs.dadm.l0603b_bottomnavigationview.fragments.LogInFragment;
import labs.dadm.l0603b_bottomnavigationview.fragments.SignInFragment;

/**
 * Provides access to different Fragments by means of a NavigationDrawer.
 * To ease its use with material Design components, the default ActionBar will be replaced by
 * a ToolBar, and this activity should implement the onNavigationItemSelectedListener.
 */
public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        // Sets the listener to be notified when any element of the BottomNavigationView is clicked
        ((BottomNavigationView) findViewById(R.id.bottomView)).setOnNavigationItemSelectedListener(this);

        // If the activity is being created for the first time, then display the LoginFragment,
        // otherwise let the system recreate whatever was being displayed previously
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new LogInFragment())
                    .commit();
        }

    }

    /**
     * This method is called whenever an item in the NavigationView is clicked.
     * Replace the Fragment that is being displayed by the one selected.
     * Change the title displayed in the Actionbar accordingly.
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        String tag = null;

        // Determine the action to take place according to the Id of the action selected
        final int selectedItem = item.getItemId();
        if (selectedItem == R.id.mLoginNavigation) {
            // Display LogInFragment

            // Get or create a new LogInFragment
            tag = "login";
            fragment = getSupportFragmentManager().findFragmentByTag(tag);
            if (fragment == null) {
                fragment = LogInFragment.newInstance("David");
            }
            // Display the LogInFragment title on the ActionBar
            getSupportActionBar().setTitle(R.string.title_login_fragment);
        } else if (selectedItem == R.id.mSignInNavigation) {
            // Display SignInFragment

            // Get or create a new SignInFragment
            tag = "signin";
            fragment = getSupportFragmentManager().findFragmentByTag(tag);
            if (fragment == null) {
                fragment = new SignInFragment();
            }
            // Display the SignInFragment title on the ActionBar
            getSupportActionBar().setTitle(R.string.title_signin_fragment);
        } else if (selectedItem == R.id.mListNavigation) {
            // Display ListStringFragment

            // Get or create a new ListStringFragment
            tag = "list";
            fragment = getSupportFragmentManager().findFragmentByTag(tag);
            if (fragment == null) {
                fragment = new ListStringFragment();
            }
            // Display the ListStringFragment title on the ActionBar
            getSupportActionBar().setTitle(R.string.title_list_fragment);
        } else if (selectedItem == R.id.mGridNavigation) {
            // Display GridViewFragment

            // Get or create a new GridViewFragment
            tag = "grid";
            fragment = getSupportFragmentManager().findFragmentByTag(tag);
            if (fragment == null) {
                fragment = new GridImageFragment();
            }
            // Display the GridViewFragment title on the ActionBar
            getSupportActionBar().setTitle(R.string.title_grid_fragment);
        }

        // Replace the existing Fragment by the new one
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment, tag)
                .commit();

        return true;
    }

}