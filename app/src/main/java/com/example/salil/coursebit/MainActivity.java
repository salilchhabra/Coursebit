package com.example.salil.coursebit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
public void findmap(View view)
{int  tag=Integer.parseInt(view.getTag().toString());
    Intent intent=new Intent(getApplicationContext(),webview.class);
    intent.putExtra("newsid",tag);
    startActivity(intent);



}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finishAffinity();
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

        if (id == R.id.rating) {
            Intent intent=new Intent(getApplicationContext(),rating.class);
            startActivity(intent);
        }
        else if (id == R.id.login) {
           Intent intent=new Intent(getApplicationContext(),login.class);
           startActivity(intent);
        }
        else if (id == R.id.aboutus) {
            new android.app.AlertDialog.Builder(this)
                    .setTitle("about us")
                    .setMessage("copyright by \n salil5chhabra@gmail.com")
                    .setPositiveButton("ok",null)
                    .show();
        }

        else if (id == R.id.exit) {
            new android.app.AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage("do you want to quit the app")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                            Toast.makeText(MainActivity.this, "app closed", Toast.LENGTH_SHORT).show();
                        }


                    })
                    .setNegativeButton("no", null)
                    .show();
        }
            else if (id == R.id.nav_share) {
            try {
                Intent n = new Intent(Intent.ACTION_SEND);
                n.setType("text/plain");
                n.putExtra(Intent.EXTRA_SUBJECT, "my application name");
                String saux = "\n let me recommend you this application\n\n";
                saux = saux + "http://play.google.com/store/apps/details?id=the.package.id\n\n";
                n.putExtra(Intent.EXTRA_TEXT, saux);
                startActivity(Intent.createChooser(n, "choose one"));
            } catch (Exception e) {
                System.out.print(e);
            }
        }
                else if (id == R.id.feedback) {

                Intent intent=new Intent(getApplicationContext(),feedback.class);
                startActivity(intent);
            }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
