package com.example.mycalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView result_tv, solution_tv;
    MaterialButton ButtonC, ButtonAC, ButtonOB, ButtonCB;
    MaterialButton Button0, Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9;
    MaterialButton ButtonAdd, ButtonSub, ButtonMul, ButtonDiv;
    MaterialButton ButtonEq, ButtonDot;
    private TextView solutionTv;
    private ScrollView verticalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        result_tv = findViewById(R.id.result_tv);
        solution_tv = findViewById(R.id.solution_tv);
        verticalScrollView = findViewById(R.id.verticalScrollView);

        solution_tv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                verticalScrollView.post(() -> verticalScrollView.fullScroll(View.FOCUS_DOWN));
            }
        });

        assignID(ButtonC,R.id.button_c);
        assignID(ButtonAC,R.id.button_ac);
        assignID(ButtonOB,R.id.button_ob);
        assignID(ButtonCB,R.id.button_cb);
        assignID(Button0,R.id.button_0);
        assignID(Button1,R.id.button_1);
        assignID(Button2,R.id.button_2);
        assignID(Button3,R.id.button_3);
        assignID(Button4,R.id.button_4);
        assignID(Button5,R.id.button_5);
        assignID(Button6,R.id.button_6);
        assignID(Button7,R.id.button_7);
        assignID(Button8,R.id.button_8);
        assignID(Button9,R.id.button_9);
        assignID(ButtonAdd,R.id.button_addition);
        assignID(ButtonSub,R.id.button_subtract);
        assignID(ButtonMul,R.id.button_multiply);
        assignID(ButtonDiv,R.id.button_devide);
        assignID(ButtonDot,R.id.button_dot);
        assignID(ButtonEq,R.id.button_equal);

    }

    void assignID(MaterialButton btn,int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String finalResult=("");
        MaterialButton Button = (MaterialButton) v;
        String ButtonText = Button.getText().toString();
        String DataToCalculate = solution_tv.getText().toString();

        if(ButtonText.equals("AC")){
            solution_tv.setText("");
            result_tv.setText("");
            return;
        }
        if(ButtonText.equals("=")) {
            solution_tv.setText(result_tv.getText());
            return;
        }
        if(ButtonText.equals("C")) {
            if(DataToCalculate.length()!=1){
                DataToCalculate = DataToCalculate.substring(0, DataToCalculate.length()-1);
            }else {
                solution_tv.setText("");
                result_tv.setText("");
                return;
            }

        }else {
            DataToCalculate = DataToCalculate + ButtonText;
        }
        solution_tv.setText((DataToCalculate));

        finalResult = getResult(DataToCalculate);

        if(!finalResult.equals("Err")){
            result_tv.setText(finalResult);
        }
    }

    String getResult(String data) {
        try {
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        } catch (Exception e) {
            return "Err";
        }
    }

}
