package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView4;
    Button btn_choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView4 = findViewById(R.id.textView4);
        btn_choose = findViewById(R.id.button);

        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,MainActivity2.class),1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) return;
        if(requestCode == 1){
            if(resultCode == 100){
                Bundle bundle=data.getExtras();
                String str1 = bundle.getString("drink");
                String str2 = bundle.getString("Sugar");
                String str3 = bundle.getString("ice");
                textView4.setText(String.format("飲料:%s\n\n甜度:%s\n\n冰塊:%s\n\n",str1,str2,str3));
            }
        }
    }
}