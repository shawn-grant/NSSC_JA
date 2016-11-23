package com.codecomplete.student_council_ja;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity  extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
    }

    public void onClick(View v){
        switch (v.getId()){
           
            case R.id.sendEmail:
                sendEmail();
                break;

            case R.id.facebook:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com/nsscja")));
                break;

            case R.id.twitter:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://twitter.com/nssc_ja")));
                break;

            case R.id.instagram:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://instagram.com/nssc_ja")));
                break;

            case R.id.youtube:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://youtube.com/nsscja")));
                break;

        }
    }

    public void sendEmail() {
        Log.i("Send email", "");
        EditText subject = (EditText)findViewById(R.id.subject);
        EditText body = (EditText)findViewById(R.id.body);

        String[] TO = {"nsscja@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
