package com.codecomplete.student_council_ja;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        TextView devText =(TextView)findViewById(R.id.dev);
        devText.setClickable(true);
        devText.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://shawn-grant.github.io'>Developer: Shawn Grant</a>";
        devText.setText(Html.fromHtml(text));

        TextView teamTV =(TextView)findViewById(R.id.cortechx);
        teamTV.setClickable(true);
        teamTV.setMovementMethod(LinkMovementMethod.getInstance());
        String text2 = "<a href='http://cortechx.github.io'>(Cotechx)</a>";
        teamTV.setText(Html.fromHtml(text2));
    }
}
