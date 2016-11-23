package com.codecomplete.student_council_ja;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goto_articles:
                startActivity(new Intent("android.intent.action.ARTICLES"));
            break;

            case R.id.goto_gallery:
                startActivity(new Intent("android.intent.action.GALLERY"));
                break;

            case R.id.goto_contact:
                startActivity(new Intent("android.intent.action.CONTACT"));
                break;

            case R.id.goto_about:
                startActivity(new Intent("android.intent.action.ABOUT"));
                break;
        }
    }
}
