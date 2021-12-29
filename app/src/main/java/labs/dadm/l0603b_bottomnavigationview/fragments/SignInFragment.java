/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0603b_bottomnavigationview.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import labs.dadm.l0603b_bottomnavigationview.R;

// Displays an UI to let the user sign in into a system.
// It includes no business logic, just for show.
// It also adds actions to the ActionBar.
public class SignInFragment extends Fragment {

    // Required empty public constructor.
    public SignInFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The Fragment can now add actions to the ActionBar and react when they are clicked
        setHasOptionsMenu(true);
    }

    // Creates the View associated to this Fragment from a Layout resource.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    // This method is executed when the activity is created to populate the ActionBar with actions.
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_signin, menu);
    }

    // This method is executed when any action from the ActionBar is selected.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Determine the action to take place according to the Id of the action selected
        if (item.getItemId() == R.id.mSignin) {
            // Notify the user that this action has been selected
            Toast.makeText(getContext(), R.string.menu_fragment_signin, Toast.LENGTH_SHORT).show();
            return true;
        }
        // There was no custom behaviour for that action, so let the system take care of it
        return super.onOptionsItemSelected(item);
    }
}
