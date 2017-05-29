package com.example.aguis.etecapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aguis.etecapp.fragments.ElectronicApplianceFragment;
import com.example.aguis.etecapp.fragments.HomeApplianceFragment;
import com.example.aguis.etecapp.fragments.PagerAdapter;
import com.example.aguis.etecapp.fragments.VideoGameFragment;
import com.facebook.AccessToken;
import com.facebook.internal.Logger;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (AccessToken.getCurrentAccessToken() == null) {
            goLoginScreen();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout(view);
            }
        });*/

        viewPager = (ViewPager) findViewById(R.id.mViewPager_ID);
        this.addPages();

        tabLayout = (TabLayout) findViewById(R.id.mTab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);

    }

    private void addPages() {
        PagerAdapter pagerAdapter = new PagerAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new VideoGameFragment());
        pagerAdapter.addFragment(new HomeApplianceFragment());
        pagerAdapter.addFragment(new ElectronicApplianceFragment());

        viewPager.setAdapter(pagerAdapter);
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_logout:
                logout();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    // *************************************************************************************************************************************

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
