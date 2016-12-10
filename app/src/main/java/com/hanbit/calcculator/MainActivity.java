package com.hanbit.calcculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.calcculator.domain.CalcDTO;
import com.hanbit.calcculator.service.CalcService;
import com.hanbit.calcculator.service.CalcServiceImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //연산하지 않고 선언만 한다.
    EditText et_num1,et_num2;
    Button  bt_plus, bt_minus, bt_multi, bt_divide, bt_result;
    TextView tv_result;
    int result;

    CalcService service;
    CalcDTO cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_num1 = (EditText) findViewById(R.id.et_num1);
        et_num2 = (EditText) findViewById(R.id.et_num2);
        bt_plus = (Button) findViewById(R.id.bt_plus);
        bt_minus = (Button) findViewById(R.id.bt_minus);
        bt_multi = (Button) findViewById(R.id.bt_multi);
        bt_divide = (Button) findViewById(R.id.bt_divide);
        bt_result = (Button) findViewById(R.id.bt_result);
        tv_result = (TextView) findViewById(R.id.tv_result);
        result = 0;

        service = new CalcServiceImpl();
        cal = new CalcDTO();

        bt_plus.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_multi.setOnClickListener(this);
        bt_divide.setOnClickListener(this);
        bt_result.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(et_num1.getText().toString());
        int num2 = Integer.parseInt(et_num2.getText().toString());

        cal.setNum1(num1);
        cal.setNum2(num2);

        switch (v.getId()){
            case R.id.bt_plus:
                result = service.plus(cal);
                break;
            case R.id.bt_minus:
                result = service.minus(cal);
                break;
            case R.id.bt_multi:
                result = service.multi(cal);
                break;
            case R.id.bt_divide:
                result = service.divide(cal);
                break;
            case R.id.bt_result:
                tv_result.setText("result : " + result);
                break;
        }
    }

}
