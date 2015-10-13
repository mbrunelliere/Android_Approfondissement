package com.gobelins.mbrunelliere.hellocrm;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gobelins.mbrunelliere.hellocrm.user.LoginFragment;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginListener{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LoginFragment fragment = new LoginFragment();

        //instantiate Fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContainer, new LoginFragment())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuMainLoginItem) {
            //login clicked
            return true;
        }else if (item.getItemId() == R.id.menuMainLoginItem) {
            //register clicked
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onLoginClicked(CharSequence loginName, CharSequence loginPassword) {
        Log.d(TAG, "onLoginClicked in Activity " + loginName + " : " + loginPassword);
        Snackbar.make(findViewById(R.id.mainWrapper),"snarckbar !", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    public void onClick(View v){
                        Log.d(TAG,"undo");
                    }
                })
                .show();
    }
}
