package com.example.admin.w1wenavigationdrawer;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    SlideShowAdapter mAdapter;
    ViewPager mViewPager;
    CircleIndicator mCircleIndicator;


    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navagation_drawer);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.viewPager_id);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circleindicator_id);

        mAdapter = new SlideShowAdapter(this);
        mViewPager.setAdapter(mAdapter);

        mCircleIndicator.setViewPager(mViewPager);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        mNavigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.item1_id:
                aboutApp();
                //Toast.makeText(getApplicationContext(), "Item 1 is selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2_id:
                Toast.makeText(getApplicationContext(), "Item 2 is selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3_id:
                Toast.makeText(getApplicationContext(), "Item 3 is selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_id:
                Toast.makeText(getApplicationContext(), "Search icon is selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.car_id:
                Toast.makeText(getApplicationContext(), "Car icon is selected", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void aboutApp() {
        AlertDialog alertDialog;
        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Click Ok to open our website...");


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mobileappscompany.com/"));
                startActivity(browserIntent);
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                System.out.println("cancel");
            }
        });

        alertDialog = builder.create();

        alertDialog.show();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        Intent intent;
        switch (id){

            case R.id.inbox_id:
                intent = new Intent(this, CalculatorActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Calculator open",Toast.LENGTH_LONG).show();

                break;


            case R.id.starred_id:
                intent = new Intent(this, WebViewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"starred",Toast.LENGTH_LONG).show();

                break;


            case R.id.sent_id:

                Toast.makeText(getApplicationContext(),"sent mail",Toast.LENGTH_LONG).show();

                break;


            case R.id.drafts_id:

                Toast.makeText(getApplicationContext(),"drafts",Toast.LENGTH_LONG).show();

                break;


            case R.id.allmail_id:

                Toast.makeText(getApplicationContext(),"all mail",Toast.LENGTH_LONG).show();

                break;


            case R.id.trash_id:

                Toast.makeText(getApplicationContext(),"trash",Toast.LENGTH_LONG).show();

                break;


            case R.id.spam_id:

                Toast.makeText(getApplicationContext(),"spam",Toast.LENGTH_LONG).show();

                break;

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;

    }


}

