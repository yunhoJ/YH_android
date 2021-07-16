package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static Context my_context;
    public String url="";
    public String content = "";
    private Bundle bundle;
    private BottomNavigationView navi;
    private Fragment_A fragment_a;
    private Fragment_B fragment_b;
    private Fragment_C fragment_c;
    private Fragment_D fragment_d;
    private Fragment_D_2 fragment_d_2;
    private Apply_page apply_page;
    private Search_Child search_child;
    private Login login;

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
        apply_page = new Apply_page();
        search_child=new Search_Child();
        login = new Login();




        Intent intent=getIntent();
        String response= intent.getStringExtra("response");

        if(response==null)
        {
            Log.v("test","위실행");
            getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_b).commit();// getSupportFragmentManager() 프레그 먼트 관리하는 객체
        }else
        {
            Log.v("test","아래실행");
            getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, search_child).commit();// getSupportFragmentManager() 프레그 먼트 관리하는 객체
        }

        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int selectItem = item.getItemId();

                if (selectItem == R.id.page1) {//커뮤니티
                    if (PreferenceManager.getString(getApplicationContext(), "Login").equals("")) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, login).commit();
                    }else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_a).commit();
                    } Log.v("prefer1", PreferenceManager.getString(getApplicationContext(), "Login"));
                } else if (selectItem == R.id.page2) {//홈버튼

                    getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_b).commit();

                } else if (selectItem == R.id.page3) {//맞춤정책
                    if (PreferenceManager.getString(getApplicationContext(), "Login").equals("")) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, login).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_c).commit();
                    }
                    Log.v("prefer1", PreferenceManager.getString(getApplicationContext(), "Login"));

                } else if (selectItem == R.id.page4) {
                    if (PreferenceManager.getString(getApplicationContext(), "Login").equals("")) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_d_2).commit();
                    }
                    else{
                        getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment, fragment_d).commit();
                        }
                }

                return true;
            }
        });

        ;

        my_context = this;
    }

    ;

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}