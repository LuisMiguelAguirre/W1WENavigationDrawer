package com.example.admin.w1wenavigationdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://developer.android.com/guide/webapps/webview.html");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goWeb(View view) {
        EditText editText = (EditText) findViewById(R.id.eInputValue);
        Toast.makeText(getApplicationContext(),editText.getText().toString(),Toast.LENGTH_LONG).show();

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(editText.getText().toString());
    }
}
