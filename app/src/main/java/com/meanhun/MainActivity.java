package com.meanhun;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText in_A, in_B;
    TextView txtresults;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process_Send();
            }
        });
    }

    private void process_Send() {
        Intent intent = new Intent(MainActivity.this,Activity_handle_numbers.class);
        intent.putExtra("a",Integer.valueOf(in_A.getText().toString()));
        intent.putExtra("b",Integer.valueOf(in_B.getText().toString()));
        startActivityForResult(intent,48);
    }

    private void addControls() {
        in_A = findViewById(R.id.inputA);
        in_B = findViewById(R.id.inputB);
        btn_send = findViewById(R.id.btn_calculate_send);
        txtresults = findViewById(R.id.txt_results);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 48 && resultCode == 17){
            txtresults.setText("KQ UCLN = "+data.getIntExtra("ucln",-1));
        }
    }
}