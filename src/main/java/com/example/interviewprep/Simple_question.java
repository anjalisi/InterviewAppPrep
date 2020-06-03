package com.example.interviewprep;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Simple_question extends AppCompatActivity implements View.OnClickListener
{
    //Variable obj of text to speech
    TextToSpeech ttsobject;
    int result;

    private static final String default_string="Press \"A\" Button for the Answer";

    TextView tvquestion, tvanswer, tvtotallength_yy,tvpresentindex_xx;
    Button bleft, bshow, bright;
    int index;

    String[] simple_question, simple_answers;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.questions);

        //Codes to add ActionBar
        LinearLayout question_ll=(LinearLayout)findViewById(R.id.questions_page_titlebar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.questions_title_bar);

        Button bspeak=(Button)findViewById(R.id.bspeak);
        Button bmute=(Button)findViewById(R.id.bstop_mute);
        TextView tv_category=(TextView)findViewById(R.id.tv_questions_titlebar);
        tv_category.setText("Simple Questions");


            //Initialize index
            index=0;
            /*Doing the initializations of the textview and buttons*/
            tvquestion=(TextView)findViewById(R.id.tvquestion);
            tvanswer=(TextView)findViewById(R.id.tvanswer);
            tvtotallength_yy=(TextView)findViewById(R.id.tvyy);
            tvpresentindex_xx=(TextView)findViewById(R.id.tvxx);

            bleft=(Button)findViewById(R.id.bleft);
            bshow=(Button)findViewById(R.id.bshowanswer);
            bright=(Button)findViewById(R.id.bright);

            /*Get values from string-arrays in xml files*/
            simple_question= getResources().getStringArray(R.array.simple_ques);
            simple_answers= getResources().getStringArray(R.array.simple_ans);

            /*Set onClickListener for buttons and Speak and MUTE*/
            bright.setOnClickListener(this);
            bshow.setOnClickListener(this);
            bleft.setOnClickListener(this);
            bspeak.setOnClickListener(this);
            bmute.setOnClickListener(this);


            /*Setting index of ques*/
            tvquestion.setText(simple_question[index]);
            tvanswer.setText(default_string);
            tvpresentindex_xx.setText(String.valueOf(index+1)+" / ");//tranform int to string
            tvtotallength_yy.setText(String.valueOf(simple_question.length));

            //TEXTTOSPEECH
        ttsobject=new TextToSpeech(Simple_question.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status)
            {
                if(status== TextToSpeech.SUCCESS)
                {
                    result= ttsobject.setLanguage(Locale.US);       //Setting language to UK access
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported in device", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bleft:
                tvanswer.setText(default_string);
                index--;
                if(index==-1)
                {
                    index=simple_question.length-1;//goes to last element
                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index+1)+" / ");

                }
                else {
                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1) + " / ");
                }
                break;

            case R.id.bright:
                tvanswer.setText(default_string);
                index++;
                if(index==simple_question.length){
                    index=0;
                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index+1)+" / ");
                }
                else {
                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1) + " / ");
                }
                break;

            case R.id.bshowanswer:
                tvanswer.setText(simple_answers[index]);
                break;

            case R.id.bspeak:
                if(result== TextToSpeech.LANG_NOT_SUPPORTED || result== TextToSpeech.LANG_MISSING_DATA)
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported in device", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(tvanswer.getText().toString().equals(default_string))
                    {

                    }
                    else {
                        ttsobject.speak(simple_answers[index], TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
                break;

            case R.id.bstop_mute:
                if(ttsobject!=null)
                    ttsobject.stop();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(ttsobject!=null)
        {
            ttsobject.stop();
            ttsobject.shutdown();
        }
    }
}
