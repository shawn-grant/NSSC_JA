package com.codecomplete.student_council_ja;

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        WebView webView= (WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });
        webView.loadUrl("file:///android_asset/feeds.html");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ListView lv = new ListView(this);
        final String[] items={"A Guide for Student Councillors.pdf", "CCRC_UNICEF.pdf", "Child Care and Protection Act.pdf",
                "EA Regulations 1980.pdf","MANAGING COUNCILS presentation.pdf","NCE manual inside pages.pdf",
                "NSSC Constitution-Revised.pdf","NSSC FEATURE 2015.pdf", "nssc_brochure.pdf", "nssc_brochure_2.pdf",
                "OCR Presentation.pdf","Overview of the NSSC.pdf","Overview of the NSSC_2.pdf",
                "Roles and Responsibilities of Staff Advisors PRESENTATION.pdf","School Board Audit Form.pdf",
                "Schools Directory 2013 no maps.pdf","Student Council Template for Conducting Sessions.pdf",
                "Voting Portal usage.pdf"};
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url="http://nsscja.org/resources/"+ items[position];
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });

        switch (item.getItemId()){
            case R.id.menu_info:
                break;

            case R.id.menu_resources:
                new AlertDialog.Builder(this).setTitle("NSSC Resources").setView(lv).show();
                break;

            case R.id.menu_web:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://nsscja.org")));
                break;

            case R.id.menu_settings:
                startActivity(new Intent("android.intent.action.SETTINGS"));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
