package com.example.sql_test;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

    private ListView listView;
    Cursor cur_del;
    String res;
    private TextView textc, textf, textfinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        listView = findViewById(R.id.listView);
        textc = findViewById(R.id.textcolor);
        textf = findViewById(R.id.textfn);
        textfinal = findViewById(R.id.textfinal);
        String color = getIntent().getStringExtra("color");
        String function = getIntent().getStringExtra("function");
        textc.setText(color);
        textf.setText(function);
        // get the list of users from the previous activity
        /*
        User[] users = (User[]) getIntent().getSerializableExtra("users");
        */
        // create an array list to hold the list of users
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<User> dataholder;
        /*
        for (User user : users) {
            userList.add(user);
        }
        */

        Cursor cursor = new dbmanager(this).readalldata();
        cur_del = cursor;

        //String name = read_first();
        //textfinal.setText(name);

        if(color == "red")
        {
            if(function == "bgc")
                textfinal.setBackgroundColor(Color.RED);
            else if(function == "fc")
                textfinal.setTextColor(Color.RED);
            else if(function == "dc")
                res = delete_entry();
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        }

        else if(color == "blue")
        {
            if(function == "bgc")
                textfinal.setBackgroundColor(Color.BLUE);
            else if(function == "fc")
                textfinal.setTextColor(Color.BLUE);
            else if(function == "dc")
                res = delete_entry();
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        }

        else if(color == "green")
        {
            if(function == "bgc")
                textfinal.setBackgroundColor(Color.GREEN);
            else if(function == "fc")
                textfinal.setTextColor(Color.GREEN);
            else if(function == "dc")
                res = delete_entry();
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        }


        while (cursor.moveToNext()) {
            User user1 = new User(cursor.getString(1));
            userList.add(user1);
        }
       // cursor.close();
        // create an array adapter to display the list of users in the ListView
        ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);
        listView.setAdapter(adapter);
    }
/*
    private void output_from_db()
    {
        Cursor cursor = new dbmanager(this).readalldata();
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String email = cursor.getString(1);
            User user = new User(name, email);
            //userList.add(user);
        }
        cursor.close();

    }

*/

    private String delete_entry()
    {
        int idcolumn = cur_del.getColumnIndex("id");
        int id = cur_del.getInt(idcolumn);
        String msg = new dbmanager(this).delete_entry(id);
        return msg;
    }

    private String read_first(){
    int idcol = cur_del.getColumnIndex("name");
    String txt = cur_del.getString(idcol);
    return txt;
    }
}