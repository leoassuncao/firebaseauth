package br.com.leoassuncao.firebaselogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by leonardo.filho on 05/01/2018.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.activity_main));
        setSupportActionBar(toolbar);

    }

    @Override
    public void onBackPressed() {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_main:
                return true;

            case  R.id.nav_settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;

            case R.id.nav_images:
                startActivity(new Intent(MainActivity.this, ImagesActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
