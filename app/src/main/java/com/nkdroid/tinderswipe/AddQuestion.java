package com.nkdroid.tinderswipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class AddQuestion extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpage);

        Button gobackbtn = (Button) findViewById(R.id.gobackbutton);
        Button submitquestionbtn = (Button) findViewById(R.id.submitquestion);
        final EditText optionOne = (EditText) findViewById(R.id.editText1);
        final EditText optionTwo = (EditText) findViewById(R.id.editText2);

        submitquestionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String one = optionOne.getText().toString();
                //String two = optionTwo.getText().toString();
                optionOne.setText("");
                optionTwo.setText("");
            }
        });

        gobackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddQuestion.this, MainActivity.class));
            }
        });
    }
}
