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
            final Bundle bundle = new Bundle();
            bundle.putString("username", "David");

            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fcvLayout, LogInFragment.class, bundle)
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

        Class<? extends Fragment> fragment = null;
        Bundle bundle = null;

        // Determine the action to take place according to the Id of the action selected
        final int selectedItem = item.getItemId();
        if (selectedItem == R.id.mLoginNavigation) {
            // Display LogInFragment
            fragment = LogInFragment.class;
            // Set the information to pass an initial username to the Fragment
            bundle = new Bundle();
            bundle.putString("username", "David");
            // Display the LogInFragment title on the ActionBar
            getSupportActionBar().setTitle(R.string.title_login_fragment);
        } else if (selectedItem == R.id.mSignInNavigation) {
            // Display SignInFragment
            fragment = SignInFragment.class;
            // Display the SignInFragment title on the ActionBar
            getSupportActionBar().setTitle(R.string.title_signin_fragment);
        } else if (selectedItem == R.id.mListNavigation) {
            // Display ListStringFragment
            fragment = ListStringFragment.class;
            // Display the ListStringFragment title on the ActionBar
            getSupportActionBar().setTitle(R.string.title_list_fragment);
        } else if (selectedItem == R.id.mGridNavigation) {
            // Display GridViewFragment
            fragment = GridImageFragment.class;
            // Display the GridViewFragment title on the ActionBar
            getSupportActionBar().setTitle(R.string.title_grid_fragment);
        }

        if (fragment != null) {
            // Replace the existing Fragment by the new one
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fcvLayout, fragment, bundle)
                    .commit();
        }

        return true;
    }

}