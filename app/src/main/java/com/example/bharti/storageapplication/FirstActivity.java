package com.example.bharti.storageapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Thread t = new Thread(){
            public void run()
            {
                try
                {
                    Thread.sleep(3000);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                    startActivity(intent);
                    FirstActivity.this.finish();
                }
            }
        };
        t.start();
    }


}

