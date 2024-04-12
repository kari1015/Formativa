package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    // inicializacion de los fragments
    inicio_Fragment inicio1 = new inicio_Fragment();
    inicio2_Fragment inicio2 = new inicio2_Fragment();

    FrameLayout frm_home1;
    BottomNavigationView btn_menu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frm_home1 = findViewById(R.id.frm_home1);
        btn_menu1 = findViewById(R.id.btn_menu);
        btn_menu1.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.naf_inicio){
                    loadFragment(inicio1);
                    return true;

                }else{
                    if(item.getItemId() == R.id.naf_inicio2){
                        loadFragment(inicio2);
                        return true;
                    }

                }

                return false;
            }
        });

    }
    // imageView en el primer fragment del xml
    //spinner en el segundo fragment
    public void loadFragment(Fragment fr){
        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
        tr.replace(R.id.frm_home1,fr);
        tr.commit();
    }

}