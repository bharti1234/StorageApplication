package com.example.bharti.storageapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;

public class ThirdActivity extends Activity {

    EditText t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        t3=(EditText)findViewById(R.id.editText3);
        t4=(EditText)findViewById(R.id.editText4);
    }

    public void load(View view) {
        try
        {
            FileInputStream fin = openFileInput("LoginDetails.txt");
            int r;
            StringBuffer str = new StringBuffer();
            while((r=fin.read())!=-1)
            {
                str.append((char)r);
            }
            String userName = str.substring(0,str.indexOf(" "));
            String password = str.substring(str.indexOf(" ")+1);
            t3.setText(userName);
            t4.setText(password);
            Toast.makeText(this,"Records are loaded successfully!", Toast.LENGTH_LONG).show();
            fin.close();
        }catch(Exception e)
        {
            Log.d("Exception : ",e.getMessage());
        }

    }

    public void back(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);

    }
}
