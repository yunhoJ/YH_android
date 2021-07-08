package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private  Bundle bundle;
    private BottomNavigationView navi;
    private Fragment_A fragment_a;
    private Fragment_B fragment_b;
    private Fragment_C fragment_c;
    private Fragment_D fragment_d;
    private Fragment_D_2 fragment_d_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navi = findViewById(R.id.navi);

        fragment_a = new Fragment_A();
        fragment_b = new Fragment_B();
        fragment_c = new Fragment_C();
        fragment_d = new Fragment_D();
        fragment_d_2 = new Fragment_D_2();

        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_b).commit();// getSupportFragmentManager() 프레그 먼트 관리하는 객체


        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int selectItem = item.getItemId();

                if (selectItem == R.id.page1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_a).commit();

                } else if (selectItem == R.id.page2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_b).commit();

                } else if (selectItem == R.id.page3) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_c).commit();

                } else if (selectItem == R.id.page4) {
                    if(true) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_d).commit();
                    }
//                    else{
//                        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_d_2).commit();
//                        }
                }

                return true;
            }
        });

        ;


    };

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle){
        this.bundle = bundle;
    }
}