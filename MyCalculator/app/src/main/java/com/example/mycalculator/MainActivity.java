package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int DIVIDE = 0;
    private final int ADD=1;
    private final int SUBTRACT=2;
    private final int MULTIPLY=4;
    private final int REMAINDER =3;

    private TextView answerTextview;

    private float answerValue = 0.0f;
    private float firstValue = 0.0f;
    private float secondValue = 0.0f;
    private int operator = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextview = findViewById(R.id.main_TextView);
    }

    private void clearField(){
        answerTextview.setText("0");
        secondValue=0f;
        firstValue=0f;
        operator=0;
        answerValue=0f;
    }

    private void setOperator(int operator){
        this.operator=operator;
        firstValue=Float.parseFloat(answerTextview.getText().toString());
        answerTextview.setText("0");
    }

    private void calculate(){
        secondValue = Float.parseFloat(answerTextview.getText().toString());
        switch (operator){
            case ADD:
                answerValue=firstValue + secondValue;
                break;
            case SUBTRACT:
                answerValue=firstValue - secondValue;
                break;
            case MULTIPLY:
                answerValue=firstValue * secondValue;
                break;
            case DIVIDE:
                answerValue=firstValue / secondValue;
                break;
            case REMAINDER:
                answerValue=firstValue % secondValue;
                break;
        }
        answerTextview.setText(answerValue+"");
}
    private void addNumber(int value){
        if(answerTextview.getText().equals("0"))
            answerTextview.setText("");

        answerTextview.setText(answerTextview.getText().toString() + value);
    }

    private void removeNumber(){
        if(answerTextview.getText().toString().trim().length() > 0 && !answerTextview.getText().toString().equals("0"))
            answerTextview.setText(answerTextview.getText().toString().substring(0, answerTextview.length()-1));
        }


    public void onClick(View view){
        switch(view.getId()){
            case R.id.clear_Button:
                clearField();
                break;
            case R.id.add_Button:
                this.setOperator(ADD);
                break;
            case R.id.subtract_Button:
                this.setOperator(SUBTRACT);
                break;
            case R.id.divide_Button:
                this.setOperator(DIVIDE);
                break;
            case R.id.decimal_Button:
                break;
            case R.id.multiply_Button:
                this.setOperator(MULTIPLY);
                break;
            case R.id.remainder_Button:
                this.setOperator(REMAINDER);
                break;
            case R.id.back_Button:
                removeNumber();
                break;
            case R.id.one_Button:
                addNumber(1);
                break;
            case R.id.two_Button:
                addNumber(2);
                break;
            case R.id.three_Button:
                addNumber(3);
                break;
            case R.id.four_Button:
                addNumber(4);
                break;
            case R.id.five_Button:
                addNumber(5);
                break;
            case R.id.six_Button:
                addNumber(6);
                break;
            case R.id.seven_Button:
                addNumber(7);
                break;
            case R.id.eight_Button:
                addNumber(8);
                break;
            case R.id.nine_Button:
                addNumber(9);
                break;
            case R.id.zero_Button:
                addNumber(0);
                break;
            case R.id.equal_Button:
                calculate();
                break;
        }
    }
}
