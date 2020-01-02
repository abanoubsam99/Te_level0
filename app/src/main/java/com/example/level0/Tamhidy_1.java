package com.example.level0;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.TextView;

import com.example.level0.Al7an.A011;
import com.example.level0.Al7an.A012;
import com.example.level0.Al7an.A013;
import com.example.level0.Ash.Ash_A01;
import com.example.level0.Coptic.C01;
import com.example.level0.Games.games;
import com.example.level0.Quizes.QuizCatalogue;
import com.example.level0.R;
import com.example.level0.Taks.Taks_A01;
import com.example.level0.catalog;

public class Tamhidy_1 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamhidy_1);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = findViewById( R.id.toolbar2 );
        toolbar.setTitle("تـي اجـيــا    Level 0 ");
        setSupportActionBar( toolbar );


        android.support.v4.app.FragmentTransaction Transaction = getSupportFragmentManager().beginTransaction();
        A011 Fregment = new A011();
        Transaction.add( R.id.fram_t1, Fregment );
        Transaction.commit();

        DrawerLayout drawerLayout = findViewById( R.id.drwer );

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );

        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById( R.id.nav );
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById( R.id.drwer);
        if (drawerLayout.isDrawerOpen( GravityCompat.START )) {
            drawerLayout.closeDrawer( GravityCompat.START );
        } else {
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
           super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;

        if (itemId == R.id.t1_01)
        {   fragment=new A011();
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        } else if (itemId == R.id.t2_01) {
            fragment=new A012();
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        } else if (itemId == R.id.t3_01) {
            fragment=new A013();
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        } else if (itemId == R.id.C_01) {
            fragment=new C01();
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        } else if (itemId == R.id.A_01) {
          fragment=new Ash_A01();
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        } else if(itemId==R.id.T_01){
            fragment=new Taks_A01();
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        }

        else if(itemId==R.id.catalog_01){
            fragment=new catalog();
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        }

        else if(itemId==R.id.gam_01){
            intent = new Intent(this, games.class);
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        }
        else if(itemId==R.id.quiz_01){
            intent = new Intent(this, QuizCatalogue.class);
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        }
        else if(itemId==R.id.moraga_01){
            intent = new Intent(this, Morag3a.class);
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        }
        else {
          intent=openfacebook("110490343647850");
            A011.mediaPlayer.stop();
            A012.mediaPlayer.stop();
            A013.mediaPlayer.stop();
        }

        if (fragment != null) {
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace( R.id.fram_t1, fragment );
            transaction.commit();


        } else {
            startActivity( intent );
        }
        DrawerLayout drawerLayout= findViewById( R.id.drwer );
        drawerLayout.closeDrawer( GravityCompat.START );
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
