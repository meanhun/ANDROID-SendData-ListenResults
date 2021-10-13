package com.meanhun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_handle_numbers extends AppCompatActivity {

    TextView txt_get;
    Button btn_calculate;
    Intent intent;
    int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_numbers);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process_handle();
            }
        });
    }

    private void process_handle() {
        int min = Math.min(a,b);
        int ucln = 1;
        for (int i = min;i>=1;i--){
            if ((a % i == 0)&&(b % i ==0)){
                ucln = i;
            }
            break;
        }
        intent.putExtra("ucln",ucln);
        setResult(17,intent);
        finish();
    }

    private void addControls() {
        txt_get = findViewById(R.id.txt_get);
        btn_calculate = findViewById(R.id.btn_calculate);

        intent = getIntent();
        a = intent.getIntExtra("a",-1);
        b = intent.getIntExtra("b",-1);
        txt_get.setText("Số A = "+a+"; "+ "Số B = "+b);
    }
}