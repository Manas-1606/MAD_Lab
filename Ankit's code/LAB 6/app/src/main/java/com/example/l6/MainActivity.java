package com.example.l6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.menu_home: getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_main, new FacultyFragment()).commit();
                return true;

            case R.id.menu_course: getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_main, new CoursesFragment()).commit();
                return true;

            case R.id.menu_admission: getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_main, new AdmissionFragment()).commit();
                return true;

            case R.id.menu_faculty: getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_main, new FacultyFragment()).commit();
                return true;

//            case R.id.menu_contact: getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container_main, new ContactFragment()).commit();
//                return true;
//
//            case R.id.menu_about: getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container_main, new AboutFragment()).commit();
//                return true;

            default: return true;
        }
    }
}
