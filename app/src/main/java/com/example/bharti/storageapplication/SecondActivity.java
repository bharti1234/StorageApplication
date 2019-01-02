package com.example.bharti.storageapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class SecondActivity extends Activity {

    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);
    }

    public void save(View view) {

        String u= t1.getText().toString();
        String p=t2.getText().toString();
        try{
            FileOutputStream fout = openFileOutput("LoginDetails.txt", Context.MODE_PRIVATE);
            fout.write(u.getBytes());
            fout.write(p.getBytes());
            Toast.makeText(this,"Great! Your login details are saved successfully!",Toast.LENGTH_LONG).show();
            fout.close();

        }catch(Exception e){
            Log.d("Exception :",e.getMessage());
        }
    }

    public void next(View view) {

        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);

    }
}
