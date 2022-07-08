package com.example.calculator;

import static android.text.TextUtils.substring;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button seven,six,five,four,three,two,one,zero,nine,eight,delete,add,sub,div,mul,equal ;
    private TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        answer = findViewById(R.id.answer);
        answer.setText("");

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        delete = findViewById(R.id.delete);
        add = findViewById(R.id.plus);
        sub = findViewById(R.id.minus);
        mul = findViewById(R.id.multiply);
        div = findViewById(R.id.div);
        equal = findViewById(R.id.equal);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        delete.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View view) {


        String result = answer.getText().toString();
        switch (view.getId()){
            case R.id.nine:
                result += "9";
                answer.setText(result);
                break;
            case R.id.eight:
                result += "8";
                answer.setText(result);
                break;
            case R.id.seven:
                result += "7";
                answer.setText(result);
                break;
            case R.id.six:
                result += "6";
                answer.setText(result);
                break;
            case R.id.five:
                result += "5";
                answer.setText(result);
                break;
            case R.id.four:
                result += "4";
                answer.setText(result);
                break;
            case R.id.three:
                result += "3";
                answer.setText(result);
                break;
            case R.id.two:
                result += "2";
                answer.setText(result);
                break;
            case R.id.one:
                result += "1";
                answer.setText(result);
                break;
            case R.id.zero:
                result += "0";
                answer.setText(result);
                break;
            case R.id.delete:
                if(!result.equals("")){
                    result = substring(result, 0, result.length() - 1);
                    answer.setText(result);
                }
                break;
            case R.id.plus:
                result += "+";
                answer.setText(result);
                break;
            case R.id.multiply:
                result += "*";
                answer.setText(result);
                break;
            case R.id.minus:
                result += "-";
                answer.setText(result);
                break;
            case R.id.div:
                result += "/";
                answer.setText(result);
                break;
            case R.id.equal:
                try {
                    if (!result.equals("")) {
                        Bodmas b = new Bodmas(result);
                        Toast.makeText(this, "" + b.newAnswer, Toast.LENGTH_SHORT).show();
                        answer.setText(b.newAnswer + "");
                    }
                }
                catch (Exception e){
                    Toast.makeText(this, "Wrong values", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}