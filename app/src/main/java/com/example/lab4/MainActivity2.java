package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private Button btn_send;
    private RadioGroup rg0,rg1;
    private EditText et_drink;

    private String sugar = "無糖";
    private String ice = "微冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rg0 = findViewById(R.id.radioGroup);
        rg1 = findViewById(R.id.radioGroup3);
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_drink = findViewById(R.id.et_drink);
                String drink = et_drink.getText().toString();
                Bundle bundle = new Bundle();
                Intent intent = new Intent();
                bundle.putString("Sugar",sugar);
                bundle.putString("drink",drink);
                bundle.putString("ice",ice);
                intent.putExtras(bundle);
                setResult(100,intent);
                finish();
            }
        });
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton8:
                        ice = "微冰";
                        break;
                    case R.id.radioButton9:
                        ice = "少冰";
                        break;
                    case R.id.radioButton10:
                        ice = "正常冰";
                        break;
                }
            }
        });
        rg0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton:
                        sugar = "無糖";
                        break;
                    case R.id.radioButton2:
                        sugar = "少糖";
                        break;
                    case R.id.radioButton3:
                        sugar = "半糖";
                        break;
                    case R.id.radioButton4:
                        sugar = "全糖";
                        break;
                }
            }
        });
    }
}