package com.quekhithe.problem7intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtKq;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtKq = findViewById(R.id.txtKq);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        final float a = intent.getFloatExtra("a", 1);
        final float b = intent.getFloatExtra("b", 1);

        if (a==0) {
            if (b==0) {
                txtKq.setText("Phương trình vô số nghiệm");
            } else {
                txtKq.setText("Phương trình vô nghiệm");
            }
        } else {
            txtKq.setText(String.valueOf(-b/a));
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(ResultActivity.this, MainActivity.class);
                backIntent.putExtra("a1", a);
                backIntent.putExtra("b1", b);
                backIntent.putExtra("welcome", 1);
                startActivity(backIntent);
            }
        });
    }
}
