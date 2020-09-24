package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
           b_add, b_sub, b_mul, b_div, b_clr, b_modulo, b_equal, b_dot, b_plusminus;

   private TextView tv1, tv2;

   private final char ADDITION = '+';
   private final char SUBTRACTION = '-';
   private final char MULTIPLICATION = '*';
   private final char DIVISION = '/';
   private final char EQUAL = '=';
   private final char MODULAS = '%';
   private final char EXTRA = '@';
   private char ACTION;
   private double val1 = Double.NaN;
   private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 =(Button) findViewById(R.id.btn_0);
        b1 = (Button) findViewById(R.id.btn_1);
        b2 = (Button) findViewById(R.id.btn_2);
        b3 = (Button) findViewById(R.id.btn_3);
        b4 = (Button) findViewById(R.id.btn_4);
        b5 = (Button)findViewById(R.id.btn_5);
        b6 = (Button) findViewById(R.id.btn_6);
        b7 = (Button)findViewById(R.id.btn_7);
        b8 = (Button)findViewById(R.id.btn_8);
        b9 = (Button)findViewById(R.id.btn_9);
        b_add = (Button)findViewById(R.id.btn_add);
        b_sub = (Button)findViewById(R.id.btn_sub);
        b_mul =(Button) findViewById(R.id.btn_multi);
        b_div = (Button)findViewById(R.id.btn_divide);
        b_clr = (Button)findViewById(R.id.btn_clear);
        b_modulo = (Button)findViewById(R.id.btn_modulo);
        b_equal = (Button)findViewById(R.id.btn_equal);
        b_dot = (Button)findViewById(R.id.btn_dot);
        b_plusminus = (Button)findViewById(R.id.btn_plusminus);

        tv1 = (TextView) findViewById(R.id.input);
        tv2 = (TextView) findViewById(R.id.output);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                tv1.setText(tv1.getText().toString() + "0");
            }
        });

        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                tv1.setText(tv1.getText().toString() + ".");
            }

        });

        // btn_add
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv1.getText().length()>0){
                        ACTION = ADDITION;
                        operation();
                    //tv2.setText(val1 + "+");
                    if (!ifDouble()) {
                        tv2.setText(val1 + "+");
                    } else {
                        tv2.setText((int) val1 + "+");
                    }
                    tv1.setText(null);
                }
                else{
                    tv2.setText("Error");
                }
            }
        });

        // btn_sub
        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv1.getText().length()>0){
                    ACTION = SUBTRACTION;
                    operation();
                    //tv2.setText(val1 + "-");
                    if (!ifDouble()) {
                        tv2.setText(val1 + "-");
                    } else {
                        tv2.setText((int) val1 + "-");
                    }
                    tv1.setText(null);
                }
                else{
                    tv2.setText("Error");
                }
            }
        });

        // btn_division
        b_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv1.getText().length()>0){
                    ACTION = DIVISION;
                    operation();
                    //tv2.setText(val1 + "/");
                    if (!ifDouble()) {
                        tv2.setText(val1 + "/");
                    } else {
                        tv2.setText((int) val1 + "/");
                    }
                    tv1.setText(null);
                }
                else{
                    tv2.setText("Error");
                }
            }
        });

        // btn_mul
        b_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv1.getText().length()>0){
                    ACTION = MULTIPLICATION;
                    operation();
                    //tv2.setText(val1 + "*");
                    if (!ifDouble()) {
                        tv2.setText(val1 + "*");
                    } else {
                        tv2.setText((int) val1 + "*");
                    }
                    tv1.setText(null);
                }
                else{
                    tv2.setText("Error");
                }
            }
        });

        //btn_modulo
        b_modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv1.getText().toString().length()>0){
                    ACTION = MODULAS;
                    operation();
                    if(!ifDouble()){
                        tv2.setText(val1 + "%");
                    }
                    else{
                        tv2.setText((int)val1 + "%");
                    }
                    tv1.setText(null);
                }
                else{
                    tv2.setText("Error");
                }
            }
        });

        //btn_equal
        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv1.getText().length()>0){
                    operation();
                    ACTION = EQUAL;
                    if(!ifDouble()){
                        tv2.setText(String.valueOf(val1));
                    }
                    else{
                        tv2.setText(String.valueOf((int) val1));
                    }
                    tv1.setText(null);
                }
                else{
                    tv2.setText("Error");
                }
            }
        });

        //btn_clear
        b_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv1.getText().toString().length()>0){
                    CharSequence name = tv1.getText().toString();
                    tv1.setText(name.subSequence(0, name.length() - 1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    tv1.setText("");
                    tv2.setText("");
                }
            }
        });

        //btn_plusminus
        b_plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tv1.getText().toString().isEmpty() || !tv2.getText().toString().isEmpty()){
                    val1 = Double.parseDouble(tv1.getText().toString());
                    ACTION = EXTRA;
                    tv2.setText("-" + tv1.getText().toString());
                    tv1.setText("");
                }
                else{
                    tv2.setText("Error");
                }
            }
        });
    }

    // check if input is type of Double or not
    private boolean ifDouble() {
        return val1 == (int)val1;
    }

    // perform diff operation
    private void operation() {
        if(!(Double.isNaN(val1))) {
            if (tv2.getText().toString().charAt(0) == '-') {
                val1 = (-1) * val1;
            }

            val2 = Double.parseDouble(tv1.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 += val2;
                    break;
                case SUBTRACTION:
                    val1 -= val2;
                    break;
                case MULTIPLICATION:
                    val1 *= val2;
                    break;
                case DIVISION:
                    val1 /= val2;
                    break;
                case MODULAS:
                    val1 %= val2;
                    break;
                case EQUAL:
                    break;
            }
        }else
        {
            val1 = Double.parseDouble(tv1.getText().toString());

        }
    }

    private void ifErrorOnOutput() {
        if (tv2.getText().toString().equals("Error")) {
            tv2.setText("");
        }
    }

    // Reduce textsize to 20sp if too many digits.
    private void exceedLength() {
        if(tv1.getText().toString().length()>10){
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        }
    }
}