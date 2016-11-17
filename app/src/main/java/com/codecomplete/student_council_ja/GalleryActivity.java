package com.codecomplete.student_council_ja;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class GalleryActivity extends Activity {

    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        flipper=(ViewFlipper)findViewById(R.id.imgflipper);
        flipper.setInAnimation(this, R.anim.slide_in_left);
        flipper.setOutAnimation(this, R.anim.slide_in_right);

        LoadImages();
        AddFloatingMenu();
    }

    public void AddFloatingMenu() {
        ImageView backIcon = new ImageView(this);
        backIcon.setImageResource(R.drawable.arrow);
        backIcon.setRotation(180);

        ImageView forwardIcon = new ImageView(this);
        forwardIcon.setImageResource(R.drawable.arrow);

        ImageView icon = new ImageView(this);
        icon.setImageResource(R.drawable.button_action);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();

        SubActionButton button1 = new SubActionButton.Builder(this).setContentView(backIcon).build();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.showPrevious();
            }
        });

        SubActionButton button2 = new SubActionButton.Builder(this).setContentView(forwardIcon).build();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.showNext();
            }
        });

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1, 60, 60)
                .addSubActionView(button2, 60, 60)
                .attachTo(actionButton)
                .build();
    }



    public void LoadImages(){
        flipper.removeAllViews();

        String portfolioPath ="http://nsscja.org/images/portfolio/";
        Document doc = null;

        try {
             doc = Jsoup.connect(portfolioPath).get();
        }catch (IOException e){
            e.printStackTrace();
        }

        for (Element file : doc.select("td.right td a")) {
            if (file.attr("href").endsWith(".jpg") || file.attr("href").endsWith(".jpeg") || file.attr("href").endsWith(".png")) {
                System.out.println(file.attr("href"));
                ImageView iv = new ImageView(this);
                Picasso.with(this).load(portfolioPath + file.attr("href")).into(iv);
                flipper.addView(iv, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            }
        }
    }
}
