package com.codecomplete.student_council_ja;

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends Activity implements View.OnClickListener {

    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        flipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        flipper.setInAnimation(this, R.anim.slide_in_left);
        flipper.setOutAnimation(this, R.anim.slide_in_right);

        AddFloatingMenu();
    }

    public void AddFloatingMenu(){
        ImageView homeIcon = new ImageView(this);
        homeIcon.setImageResource( R.drawable.home);

        ImageView articlesIcon = new ImageView(this);
        articlesIcon.setImageResource(R.drawable.articles);

        ImageView contactIcon = new ImageView(this);
        contactIcon.setImageResource( R.drawable.report);

        ImageView icon = new ImageView(this);
        icon.setImageResource(R.drawable.button_action);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();


        SubActionButton button1 = new SubActionButton.Builder(this).setContentView(homeIcon).build();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flipper.getDisplayedChild()!=0) {
                    flipper.setDisplayedChild(0);
                }
            }
        });
        SubActionButton button2 = new SubActionButton.Builder(this).setContentView(articlesIcon).build();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flipper.getDisplayedChild()!=1) {
                    flipper.setDisplayedChild(1);
                }
            }
        });
        SubActionButton button3 = new SubActionButton.Builder(this).setContentView(contactIcon).build();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flipper.getDisplayedChild()!=2) {
                    flipper.setDisplayedChild(2);
                }
            }
        });

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1, 60, 60)
                .addSubActionView(button2, 60, 60)
                .addSubActionView(button3, 60, 60)
                .attachTo(actionButton)
                .build();
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.gallery:
                startActivity(new Intent("android.intent.action.GALLERY"));
                break;
            //HOME

            //ARTICLES


            //CONTACT PAGE
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
            Toast.makeText(MainActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
