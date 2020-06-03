package com.example.interviewprep;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FrontPage extends AppCompatActivity implements View.OnClickListener {
/*S1: INITIALIZE THE 4 BUTTONS*/
    Button bsimple, btough, bseeotherapps, brateapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Codes to add ActionBar
        LinearLayout front_ll=(LinearLayout)findViewById(R.id.front_page_titlebar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.frontpage_title_bar);

        bsimple=(Button)findViewById(R.id.bsq);
        btough=(Button)findViewById(R.id.btq);
        bseeotherapps=(Button)findViewById(R.id.boap);
        brateapp=(Button)findViewById(R.id.brp);

        bsimple.setOnClickListener(this);
        btough.setOnClickListener(this);
        bseeotherapps.setOnClickListener(this);
        brateapp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bsq:
                Intent i=new Intent(FrontPage.this, Simple_question.class);
                startActivity(i);
                break;

            case R.id.btq:
                Intent j=new Intent(FrontPage.this, Tough_questions.class);
                startActivity(j);
                break;
            //Use Implicit Intents
            case R.id.boap:
                try
                {
                    //link enclosed includes publisher name
                    Uri uri1 = Uri.parse("market://search?q=Drama"); //include the link to be opened
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                    startActivity(goToMarket1);
                }
                catch (ActivityNotFoundException e)
                {
                    //link enclosed opens in browser, if play store is not present
                    Uri uri1 = Uri.parse("http://play.google.com/store/search?q=Drama"); //include the link to be opened
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                    startActivity(goToMarket1);
                }
                break;

            //Use Implicit Intents
            case R.id.brp:
                try {
                    //link enclosed opens in play store
                    Uri uri1 = Uri.parse("market://details?id=" + getPackageName()); //include the link to be opened
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                    startActivity(goToMarket1);
                }
                catch (ActivityNotFoundException e){
                    //link enclosed opens in browser, if play store is not present
                    Uri uri1 = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName()); //include the link to be opened
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                    startActivity(goToMarket1);
                }
                break;
        }
    }
}
