package com.tboys.expressdelivery.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tboys.expressdelivery.R;
import com.tboys.expressdelivery.fragment.LoginFragment;
import com.tboys.expressdelivery.fragment.RegisterFragment;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    FragmentManager fm;
    TextView textView_toolbar_title;
    boolean isFlag = false;
    Button button_login;
    Button button_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolBar_login);
        textView_toolbar_title = (TextView) findViewById(R.id.textView_title);
        button_login = (Button) findViewById(R.id.button_login);
        button_register = (Button) findViewById(R.id.button_register);
        fm = getSupportFragmentManager();
        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //首次显示界面
        fm.beginTransaction().replace(R.id.frameLayout_login, loginFragment).commit();
    }

    public void changeTab(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                fm.beginTransaction().replace(R.id.frameLayout_login, loginFragment).commit();
                textView_toolbar_title.setText("登录快捷快递");
                toolbar.getMenu().removeItem(R.menu.menu_acitivity_register);
                invalidateOptionsMenu();
                isFlag = false;
                break;
            case R.id.button_register:
                textView_toolbar_title.setText("注册账号");
                fm.beginTransaction().replace(R.id.frameLayout_login, registerFragment).commit();
                isFlag = true;
                invalidateOptionsMenu();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isFlag) {
            getMenuInflater().inflate(R.menu.menu_acitivity_register, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_next) {

        }
        return super.onOptionsItemSelected(item);
    }
}
