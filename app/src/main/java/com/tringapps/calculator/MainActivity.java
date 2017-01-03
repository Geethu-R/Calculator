package com.tringapps.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.tringapps.calculator.R.id.seven;
import static com.tringapps.calculator.R.id.textSpacerNoButtons;
import static com.tringapps.calculator.R.id.zero;

public class
MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView input, output;
    Button zero, one, two, three, four, five, six, seven, eight, nine, del, divide, multiply, subtract, add, dot;
    StringBuffer str = new StringBuffer("");
    int firstFlag, secondFlag, operatorFlag, firstNumber, secondNumber, resultNUm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        dot = (Button) findViewById(R.id.dot);
        del = (Button) findViewById(R.id.del);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        subtract = (Button) findViewById(R.id.subtract);
        add = (Button) findViewById(R.id.add);

        firstFlag = 0;
        secondFlag = 0;
        operatorFlag = 0;
        firstNumber = 0;
        secondNumber = 0;
        resultNUm = 0;


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
        dot.setOnClickListener(this);
        del.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        subtract.setOnClickListener(this);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.zero):
                str.append("0");
                input.setText(str);
                gotANumber(0);
                break;


            case (R.id.one):

                str.append("1");
                input.setText(str);
                gotANumber(1);

                break;


            case (R.id.two):

                str.append("2");
                input.setText(str);
                gotANumber(2);

                break;


            case (R.id.three):

                str.append("3");
                input.setText(str);
                gotANumber(3);
                break;


            case (R.id.four):

                str.append("4");
                input.setText(str);
                gotANumber(4);
                break;
            case (R.id.five):

                str.append("5");
                input.setText(str);
                gotANumber(5);

                break;
            case (R.id.six):

                str.append("6");
                input.setText(str);
                gotANumber(6);

                break;
            case (R.id.seven):

                str.append("7");
                input.setText(str);
                gotANumber(7);

                break;
            case (R.id.eight):

                str.append("8");
                input.setText(str);
                gotANumber(8);
                break;
            case (R.id.nine):

                str.append("9");
                input.setText(str);
                if (firstFlag == 1) {
                    firstNumber = (firstNumber * 10) + 9;
                } else if (firstNumber == 0) {
                    firstNumber = 9;
                    firstFlag = 1;
                } else if (secondFlag == 1) {
                    secondNumber = (secondNumber * 10) + 9;
                } else if (secondNumber == 0) {
                    secondNumber = 9;
                    secondFlag = 1;
                }

                break;
            case (R.id.dot):

                str.append(".");
                input.setText(str);
                break;
            case (R.id.equal):
                input.setText(str);
                if (firstFlag == 1) {
                    firstFlag = 0;
                    operatorFlag = 1;
                } else if (secondFlag == 1 && operatorFlag == 1) {
                    secondFlag = 0;
                    operatorFlag = 0;
                    equal(firstNumber, secondNumber);
                } else if (secondFlag == 1) {
                    secondFlag = 0;
                    equal(firstNumber, secondNumber);
                }
                break;
            case (R.id.del):

                str.append("1");
                input.setText(str);
                break;
            case (R.id.divide):

                str.append("÷");
                input.setText(str);
                gotOperator(4);

                break;
            case (R.id.multiply):

                str.append("X");
                input.setText(str);
                gotOperator(3);

                break;
            case (R.id.subtract):

                str.append("-");
                input.setText(str);
                gotOperator(2);
                break;
            case (R.id.add):

                str.append("+");
                input.setText(str);
                if (firstFlag == 1) {
                    firstFlag = 0;
                    operatorFlag = 1;
                } else if (secondFlag == 1 && operatorFlag == 1) {
                    secondFlag = 0;
                    calculate(operatorFlag);
                } else if (secondFlag == 1) {
                    secondFlag = 0;
                    calculate(operatorFlag);
                    operatorFlag = 1;
                }
                break;

        }
    }

    private void gotOperator(int i) {

        if (firstFlag == 1) {
            firstFlag = 0;
            operatorFlag = i;
        } else if (secondFlag == 1 && operatorFlag == i) {
            secondFlag = 0;
            calculate(operatorFlag);
        } else if (secondFlag == 1) {
            secondFlag = 0;
            calculate(operatorFlag);
            operatorFlag = i;
        }


    }

    private void gotANumber(int i) {
        if (firstFlag == 1) {
            firstNumber = (firstNumber * 10) + i;
        } else if (firstNumber == 0) {
            firstNumber = i;
            firstFlag = 1;
        } else if (secondFlag == 1) {
            secondNumber = (secondNumber * 10) + i;
        } else if (secondNumber == 0) {
            secondNumber = i;
            secondFlag = 1;
        }

    }

    private void equal(int firstNumber, int secondNumber) {

    }


    private void calculate(int flag) {
        if (flag == 1) {
            resultNUm = firstNumber + secondNumber;
            firstNumber = resultNUm;
            secondNumber = 0;
            String str = String.valueOf(resultNUm);
            output.setText(str);
            firstFlag = 2;
//            operatorFlag = 0;

        }
        if (flag == 2) {
            resultNUm = firstNumber - secondNumber;
            firstNumber = resultNUm;
            secondNumber = 0;
            String str = String.valueOf(resultNUm);
            output.setText(str);
            firstFlag = 2;
//            operatorFlag = 0;

        }
        if (flag == 3) {
            resultNUm = firstNumber * secondNumber;
            firstNumber = resultNUm;
            secondNumber = 0;
            String str = String.valueOf(resultNUm);
            output.setText(str);
            firstFlag = 2;
//            operatorFlag = 0;

        }
        if (flag == 4) {
            resultNUm = firstNumber / secondNumber;
            firstNumber = resultNUm;
            secondNumber = 0;
            String str = String.valueOf(resultNUm);
            output.setText(str);
            firstFlag = 2;
//            operatorFlag = 0;

        }
    }

}
