package com.enike.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomnav = findViewById(R.id.buttomnavibar);
        bottomnav.setOnNavigationItemSelectedListener(navibar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new Call_fragment()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navibar = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case  R.id.call_icon:
                    selectedFragment = new Call_fragment();
                    break;
                case  R.id.chat_icon:
                    selectedFragment = new Chats_fragment();
                    break;
                case  R.id.search_icon:
                    selectedFragment = new Search_fragment();
                    break;
                case  R.id.downloads_icon:
                    selectedFragment = new Downloads_fragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selectedFragment).commit();

            return true;
        }
    };
}
