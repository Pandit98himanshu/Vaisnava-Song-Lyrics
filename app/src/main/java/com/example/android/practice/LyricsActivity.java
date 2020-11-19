package com.example.android.practice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LyricsActivity extends AppCompatActivity {

    private String mName, mText;
    private TextView mDetailsTextView, mLyricsTextView, mTranslationTextView;
    private boolean mFlag;
    private float textSize, mCurrTextSize;;
    private int rawResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);

/*
        // Adds back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this line shows back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // --------- OR --------- //

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
 */

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /**
         * Hides floating action button
         */
        //fab.hide();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mFlag){
                    Snackbar.make(view, "Removed from favourites.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_border));
                    mFlag = false;
                }
                else if(!mFlag){
                    Snackbar.make(view, "Added to favourites.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite));
                    mFlag = true;
                }
            }
        });


        // Get position & song mName for opening lyrics & displaying mName in title bar respectively.
        Intent in = this.getIntent();
        mName = in.getStringExtra("title");

        // Set title as song mName
        this.setTitle((CharSequence) mName);

        /**
         * Adding song details to TextView
         */
        rawResourceId = in.getIntExtra("detailsResourceId", 0);
        mText = new ReadRawTextFile().readRawTextFile(getApplicationContext(), rawResourceId);
        mDetailsTextView = (TextView) findViewById(R.id.details);
        mDetailsTextView.setText((CharSequence) mText);

        /**
         * Adding song lyrics to TextView
         */
        rawResourceId = in.getIntExtra("lyricsResourceId", 0);
        mText = new ReadRawTextFile().readRawTextFile(getApplicationContext(), rawResourceId);
        mLyricsTextView = (TextView) findViewById(R.id.lyrics);
        mLyricsTextView.setText((CharSequence) mText);

        /**
         * Adding song translation to TextView
         */
        rawResourceId = in.getIntExtra("translationResourceId", 0);
        mText = new ReadRawTextFile().readRawTextFile(getApplicationContext(), rawResourceId);
        mTranslationTextView = (TextView) findViewById(R.id.translation);
        mTranslationTextView.setText((CharSequence) mText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu. This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.text_size_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.increase_font_size:
                /**
                 * Increases font size
                 */
                textSize = mLyricsTextView.getTextSize();
                textSize += getResources().getDimension(R.dimen.change_font_by);

                mDetailsTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                mLyricsTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                mTranslationTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                return true;

            case R.id.decrease_font_size:
                /**
                 * Decreases font size
                 */
                textSize = mLyricsTextView.getTextSize();
                textSize -= getResources().getDimension(R.dimen.change_font_by);

                mDetailsTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                mLyricsTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                mTranslationTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
