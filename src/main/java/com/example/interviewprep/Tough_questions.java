package com.example.interviewprep;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Tough_questions extends AppCompatActivity implements View.OnClickListener
{
    //Variable obj of text to speech
    TextToSpeech ttsobject;
    int result;

    private static final String default_string="Press \"A\" Button for the Answer";

    int index;
    TextView tvquestion, tvanswer, tvtotallength_yy,tvpresentindex_xx;
    Button bleft, bshow, bright;
    String[] tough_question, tough_answers;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        /*Doing the initializations of the textview and buttons*/
        tvquestion=(TextView)findViewById(R.id.tvquestion);
        tvanswer=(TextView)findViewById(R.id.tvanswer);
        tvtotallength_yy=(TextView)findViewById(R.id.tvyy);
        tvpresentindex_xx=(TextView)findViewById(R.id.tvxx);

        bleft=(Button)findViewById(R.id.bleft);
        bshow=(Button)findViewById(R.id.bshowanswer);
        bright=(Button)findViewById(R.id.bright);

        tough_question= getResources().getStringArray(R.array.tough_ques);
        tough_answers= getResources().getStringArray(R.array.tough_ans);

        //Codes to add ActionBar
        LinearLayout question_ll=(LinearLayout)findViewById(R.id.questions_page_titlebar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.questions_title_bar);

        Button bspeak=(Button)findViewById(R.id.bspeak);
        Button bmute=(Button)findViewById(R.id.bstop_mute);
        TextView tv_category=(TextView)findViewById(R.id.tv_questions_titlebar);
        tv_category.setText("Tough Questions");


        /*Set onClickListener for buttons*/
        bright.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bleft.setOnClickListener(this);

        index=0;
        /*Setting index of ques*/
        tvquestion.setText(tough_question[index]);
        tvanswer.setText(default_string);
        tvpresentindex_xx.setText(String.valueOf(index+1)+" / ");//tranform int to string
        tvtotallength_yy.setText(String.valueOf(tough_question.length));

        ttsobject=new TextToSpeech(Tough_questions.this, new TextToSpeech.OnInitListener() {
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
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bleft:
                tvanswer.setText(default_string);
                index--;
                if(index==-1)
                {
                    index=tough_question.length-1;//goes to last element
                    tvquestion.setText(tough_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index+1)+" / ");

                }
                else {
                    tvquestion.setText(tough_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1) + " / ");
                }
                break;

            case R.id.bright:
                tvanswer.setText(default_string);
                index++;
                if(index==tough_question.length){
                    index=0;
                    tvquestion.setText(tough_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index+1)+" / ");
                }
                else {
                    tvquestion.setText(tough_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1) + " / ");
                }
                break;

                case R.id.bshowanswer:
                tvanswer.setText(tough_answers[index]);
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
                        ttsobject.speak(tough_answers[index], TextToSpeech.QUEUE_FLUSH, null);
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
