package com.example.level0;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.level0.Al7an.A011;
import com.example.level0.Al7an.A012;
import com.example.level0.Al7an.A013;
import com.example.level0.Al7an.A021;
import com.example.level0.Al7an.A022;
import com.example.level0.Al7an.A023;
import com.example.level0.Ash.Ash_A02;
import com.example.level0.Coptic.C02;
import com.example.level0.Games.games;
import com.example.level0.Quizes.QuizCatalogue;
import com.example.level0.Taks.Taks_A02;

public class Tamhidy_2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamhidy_2);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("تـي اجـيــا    Level 0 ");
        setSupportActionBar(toolbar);


        android.support.v4.app.FragmentTransaction Transaction = getSupportFragmentManager().beginTransaction();
        A021 Fregment = new A021();
        Transaction.add(R.id.fram_t2, Fregment);
        Transaction.commit();

        DrawerLayout drawerLayout = findViewById(R.id.drwer_t2);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_t2);
        navigationView.setNavigationItemSelectedListener(Tamhidy_2.this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drwer_t2);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;
        if (itemId == R.id.t1_02) {
            fragment = new A021();
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        } else if (itemId == R.id.t2_02) {
            fragment = new A022();
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();

        } else if (itemId == R.id.t3_02) {
            fragment = new A023();
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        } else if (itemId == R.id.C_02) {
            fragment = new C02();
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        } else if (itemId == R.id.A_02) {
            fragment = new Ash_A02();
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        } else if (itemId == R.id.T_02) {
            fragment = new Taks_A02();
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        } else if (itemId == R.id.catalog_02) {
            fragment = new catalog();
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        }
        else if (itemId == R.id.gam_02) {
            intent = new Intent(this, games.class);
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        }
        else if (itemId == R.id.quiz_02) {
            intent = new Intent(this, QuizCatalogue.class);
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        }
        else if(itemId==R.id.moraga_02){
            intent = new Intent(this, Morag3a.class);
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        }
        else {
            intent=openfacebook("110490343647850");
            A021.mediaPlayer.stop();
            A022.mediaPlayer.stop();
            A023.mediaPlayer.stop();
        }

        if (fragment != null) {
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fram_t2, fragment);
            transaction.commit();
        } else {
            startActivity(intent);
        }
        DrawerLayout drawerLayout = findViewById(R.id.drwer_t2);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    public  static Intent openfacebook(String id){

        try {
            return new Intent(Intent.ACTION_VIEW,Uri.parse("fb://page/"+id));

        }
        catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"+id));

        }

    }
}
