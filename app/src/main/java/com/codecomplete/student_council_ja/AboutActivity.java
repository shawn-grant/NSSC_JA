package com.codecomplete.student_council_ja;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_nssc);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_nssc_read_more:
                String p1=getString(R.string.about_nssc_1);
                String p2=getString(R.string.about_nssc_2);
                String p3=getString(R.string.about_nssc_3);
                new AlertDialog.Builder(this).setTitle("ABOUT US").setMessage(p1 + "\n\n" + p2 + "\n\n" + p3).show();
                break;

            case R.id.mission_vision_view_more:
                if(findViewById(R.id.mission_vision).getVisibility()==View.GONE){
                    findViewById(R.id.mission_vision).setVisibility(View.VISIBLE);
                    findViewById(R.id.mission_vision_view_more).setRotation(180);
                }else {
                    findViewById(R.id.mission_vision).setVisibility(View.GONE);
                    findViewById(R.id.mission_vision_view_more).setRotation(0);
                }
                break;

            case R.id.objectives_view_more:
                if(findViewById(R.id.objectives).getVisibility()==View.GONE){
                    findViewById(R.id.objectives).setVisibility(View.VISIBLE);
                    findViewById(R.id.objectives_view_more).setRotation(180);
                }else {
                    findViewById(R.id.objectives).setVisibility(View.GONE);
                    findViewById(R.id.objectives_view_more).setRotation(0);
                }
                break;
        }
    }
}
