package com.example.android.keepclone;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
android.support.v7.widget.Toolbar toolbar;
    private RelativeLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    private Button change;
    int clickcount = 1;
    int changecount = 1;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Notes");
        toolbar.setTitleTextColor(Color.WHITE);
        mLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
//        change = (Button)findViewById(R.id.change);
        mButton.setOnClickListener(onClick());
//        change.setOnClickListener(change());
        TextView textView = new TextView(this);
        textView.setText("New text");


    }
    private OnClickListener onClick() {
        return new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(changecount%2!=0){
                mLayout.addView(createNewTextView(mEditText.getText().toString()));
                mEditText.setText("");}
                else{
                    mLayout.addView(createNewTextViewL(mEditText.getText().toString()));
                    mEditText.setText("");}
            }
        };}


//    private OnClickListener change() {
//        return new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        };}

    private TextView createNewTextView(String text) {
        if(clickcount%2==0){
        final LayoutParams lparams = new LayoutParams(507, LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setId(clickcount);
        lparams.addRule(RelativeLayout.RIGHT_OF, clickcount-1);
        lparams.addRule(RelativeLayout.BELOW,clickcount-2);
        lparams.setMargins(0,10,20,10);
        textView.setLayoutParams(lparams);
        textView.setText(text);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(Color.BLACK);
        textView.setElevation(6);
        textView.setPadding(20,20,20,20);
        textView.setBackgroundResource(R.drawable.customshape);
        clickcount = clickcount+1;
        saveDataToPreferences(context, "strEventName", textView.toString());
        return textView;}
        else{
            final LayoutParams lparams = new LayoutParams(517, LayoutParams.WRAP_CONTENT);
            final TextView textView = new TextView(this);
            textView.setId(clickcount);
            lparams.addRule(RelativeLayout.BELOW, clickcount-2);
            lparams.setMargins(20,10,20,10);
            textView.setLayoutParams(lparams);
            textView.setText(text);
            textView.setTextSize(20);
            textView.setTypeface(null, Typeface.BOLD);
            textView.setTextColor(Color.BLACK);
            textView.setElevation(6);
            textView.setPadding(20,20,20,20);
            textView.setBackgroundResource(R.drawable.customshape);
            clickcount = clickcount+1;
            saveDataToPreferences(context, "strEventName", textView.toString());
            return textView;
        }
    }
    private TextView createNewTextViewL(String text){
        final LayoutParams lparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setId(clickcount);
        lparams.addRule(RelativeLayout.BELOW, clickcount-1);
        lparams.setMargins(20,10,20,10);
        textView.setLayoutParams(lparams);
        textView.setText(text);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(Color.BLACK);
        textView.setElevation(6);
        textView.setPadding(20,20,20,20);
        textView.setBackgroundResource(R.drawable.customshape);
        clickcount = clickcount+1;
        saveDataToPreferences(context, "strEventName", textView.toString());
        return textView;
    }
    public static void saveDataToPreferences(Context context, String key,
                                             String value) {
        SharedPreferences prefs = context.getSharedPreferences("your package name",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public static String getDataFromPreferences(Context context, String key) {

        SharedPreferences prefs = context.getSharedPreferences("your package name",
                Context.MODE_PRIVATE);
        return prefs.getString(key, Constants.DATA);
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg=" ";
        switch(item.getItemId()){
            case R.id.search:
                msg = "search";
                break;
            case R.id.relative:
            {changecount = changecount + 1;
                msg = "settings";
                if(changecount%2==0){
                TextView updateText;
                for (int i = 0; i < mLayout.getChildCount(); i++) {
                    updateText = (TextView) mLayout.getChildAt(i);
                    String notes = updateText.getText().toString();
                    final LayoutParams lparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                    updateText.setId(clickcount);
                    lparams.addRule(RelativeLayout.BELOW, clickcount-1);
                    lparams.setMargins(20,10,20,10);
                    updateText.setLayoutParams(lparams);
                    updateText.setText(notes);
                    updateText.setTextSize(20);
                    updateText.setTypeface(null, Typeface.BOLD);
                    updateText.setTextColor(Color.BLACK);
                    updateText.setElevation(6);
                    updateText.setPadding(20,20,20,20);
                    updateText.setBackgroundResource(R.drawable.customshape);
                    clickcount = clickcount+1;

                }
                    }
                else{
                        TextView updateText2;
                        for (int i = 0; i < mLayout.getChildCount(); i++) {
                            updateText2 = (TextView) mLayout.getChildAt(i);
                            String notes2 = updateText2.getText().toString();
                            if(clickcount%2==0){
                                final LayoutParams lparams = new LayoutParams(507, LayoutParams.WRAP_CONTENT);
                                updateText2.setId(clickcount);
                                lparams.addRule(RelativeLayout.RIGHT_OF, clickcount-1);
                                lparams.addRule(RelativeLayout.BELOW,clickcount-2);
                                lparams.setMargins(0,10,20,10);
                                updateText2.setLayoutParams(lparams);
                                updateText2.setText(notes2);
                                updateText2.setTextSize(20);
                                updateText2.setTypeface(null, Typeface.BOLD);
                                updateText2.setTextColor(Color.BLACK);
                                updateText2.setElevation(6);
                                updateText2.setPadding(20,20,20,20);
                                updateText2.setBackgroundResource(R.drawable.customshape);
                                clickcount = clickcount+1;}
                            else{
                                final LayoutParams lparams = new LayoutParams(517, LayoutParams.WRAP_CONTENT);
                                updateText2.setId(clickcount);
                                lparams.addRule(RelativeLayout.BELOW, clickcount-2);
                                lparams.setMargins(20,10,20,10);
                                updateText2.setLayoutParams(lparams);
                                updateText2.setText(notes2);
                                updateText2.setTextSize(20);
                                updateText2.setTypeface(null, Typeface.BOLD);
                                updateText2.setTextColor(Color.BLACK);
                                updateText2.setElevation(6);
                                updateText2.setPadding(20,20,20,20);
                                updateText2.setBackgroundResource(R.drawable.customshape);
                                clickcount = clickcount+1;
                            }}
                    }
                break;}
        }
        Toast.makeText(this,msg+" clicked",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
