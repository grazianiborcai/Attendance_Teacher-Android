package com.krav.att.attendance_teacher.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.krav.att.attendance_teacher.Parcelable.People;
import com.krav.att.attendance_teacher.R;
import com.krav.att.attendance_teacher.Requests.AsyncTask.HttpRequestTask;
import com.krav.att.attendance_teacher.Requests.FragmentRequest.LoginRequestFragment;
import com.krav.att.attendance_teacher.Requests.Interface.OnTaskFinished;
import com.krav.att.attendance_teacher.Shared.UserDataShared;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnTaskFinished {

    private LoginRequestFragment mRequestFragment;
    private UserDataShared user;
    private NavigationView navigationView;
    private boolean updateUser = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*ArrayList<People> pList = getIntent().getParcelableArrayListExtra(HttpRequestTask.RESULTS);*/
        user = UserDataShared.carregar(this);

        setHeaderView(navigationView);

            FragmentManager fm = getSupportFragmentManager();
            mRequestFragment = (LoginRequestFragment) fm.findFragmentByTag(LoginRequestFragment.TAG_TASK_SELECT_USER);

            // If the Fragment is non-null, then it is currently being
            // retained across a configuration change.
            if (mRequestFragment == null) {
                mRequestFragment = LoginRequestFragment.newInstance(this);
                fm.beginTransaction().add(mRequestFragment, LoginRequestFragment.TAG_TASK_SELECT_USER).commit();
            }
        updateUser = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (updateUser && !getIntent().hasExtra("from_login_activity")) {
            mRequestFragment.execute(user.getoAuth());
            updateUser = !updateUser;
        }
    }

    private void setHeaderView(NavigationView navView) {
        View v = navView.getHeaderView(0);
        TextView name = (TextView) v.findViewById(R.id.client_name);
        TextView email = (TextView) v.findViewById(R.id.client_email);
        name.setText(user.getName());
        email.setText(user.getEmail());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void postExecute(Intent intent) {
        try {
            ArrayList<People> pList = intent.getParcelableArrayListExtra(HttpRequestTask.RESULTS);
            People userData = pList.get(0);
            user.setPeopleID(userData.getPeopleID());
            user.setCountryID(userData.getCountryID());
            user.setName(userData.getName());
            user.setBirthDate(userData.getBirthDate());
            user.setEnrollmentNumber(userData.getEnrollmentNumber());
            user.setGradeDate(userData.getGradeDate());
            user.setEmail(userData.getEmail());
            user.setCelphone(userData.getCelphone());
            user.setPhone(userData.getPhone());
            user.setAddress1(userData.getAddress1());
            user.setAddress2(userData.getAddress2());
            user.setPostalCode(userData.getPostalCode());
            user.setBloodType(userData.getBloodType());
            user.setAllergy(userData.getAllergy());
            user.setAllergyDesc(userData.getAllergyDesc());
            user.setNextGradeExam(userData.getNextGradeExam());
            user.setWhereOther(userData.getWhereOther());
            user.setLookingOther(userData.getLookingOther());
            user.setPassword(userData.getPassword());
            user.setEnrTypeID(userData.getEnrTypeID());
            user.setoAuth(userData.getoAuth());
            user.setoAuthDate(userData.getoAuthDate());
            user.setUserAgent(userData.getUserAgent());
            user.setRegionID(userData.getRegionID());
            user.setGradeID(userData.getGradeID());
            user.setBirthDateS(userData.getBirthDateS());
            user.setGradeDateS(userData.getGradeDateS());
            user.setNextGradeExamS(userData.getNextGradeExamS());
            user.setGenderID(userData.getGenderID());
            user.setWhereID(userData.getWhereID());
            user.setLookID(userData.getLookID());
            user.save(this);
            setHeaderView(navigationView);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cancelled() {

    }

    @Override
    public void animation(boolean b) {

    }
}
