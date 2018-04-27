package com.quekhithe.problem7intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB;
    Button btnKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        btnKq = findViewById(R.id.btnKq);



        btnKq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    float a = Float.parseFloat(txtA.getText().toString());
                    float b = Float.parseFloat(txtB.getText().toString());
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    startActivity(intent);


                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Bạn vui lòng nhập số", Toast.LENGTH_SHORT).show();
                }



            }
        });

        Intent intent2 = getIntent();
        float a1 = intent2.getFloatExtra("a1", 1);
        float b1= intent2.getFloatExtra("b1", 1);
        int wc = intent2.getIntExtra("welcome", 0);
        if (wc ==1) {
            Toast.makeText(MainActivity.this, "Wellcome back to MainActivity ! \n Your last edit text: a= "+a1 + " b= "+b1 , Toast.LENGTH_LONG).show();
        }


    }
}
