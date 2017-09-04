package com.example.admin.w1wenavigationdrawer;

import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

import java.io.IOException;
import java.io.InputStream;

public class PDFActivity extends AppCompatActivity {

    PDFView mPDFView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPDFView = (PDFView) findViewById(R.id.pdfView);


        /*
        Uri.Builder builder = new Uri.Builder();
builder.scheme("https")
    .authority("www.myawesomesite.com")
    .appendPath("turtles")
    .appendPath("types")
    .appendQueryParameter("type", "1")
    .appendQueryParameter("sort", "relevance")
    .fragment("section-name");
String myUrl = builder.build().toString();

*/
        AssetManager assetManager = getAssets();
        InputStream input;
        try {
            input = assetManager.open("Eloquent_JavaScript.pdf");

            OnDrawListener onDrawListener = null;
            OnLoadCompleteListener onLoadCompleteListener = null;
            OnPageChangeListener onPageChangeListener = null;
            OnPageScrollListener onPageScrollListener = null;
            OnErrorListener onErrorListener = null;
            OnRenderListener onRenderListener = null;
            OnTapListener onTapListener = null;
            mPDFView.fromAsset("Eloquent_JavaScript.pdf")
                    .enableSwipe(true) // allows to block changing pages using swipe
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    // allows to draw something on the current page, usually visible in the middle of the screen
                    .onDraw(onDrawListener)
                    // allows to draw something on all pages, separately for every page. Called only for visible pages
                    .onDrawAll(onDrawListener)
                    .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
                    .onPageChange(onPageChangeListener)
                    .onPageScroll(onPageScrollListener)
                    .onError(onErrorListener)
                    .onRender(onRenderListener) // called after document is rendered for the first time
                    // called on single tap, return true if handled, false to toggle scroll handle visibility
                    .onTap(onTapListener)
                    .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                    .password(null)
                    .scrollHandle(null)
                    .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                    // spacing between pages in dp. To define spacing color, set view background
                    .spacing(0)
                    .load();


            // Log.d("TEST", "onCreate: " + input.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
