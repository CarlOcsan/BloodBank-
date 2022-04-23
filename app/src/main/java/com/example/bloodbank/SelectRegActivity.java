package com.example.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectRegActivity extends AppCompatActivity {

    private Button donorBtn, recipientBtn;
    private TextView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_reg);

        donorBtn = findViewById(R.id.donorBtn);
        recipientBtn = findViewById(R.id.recipientBtn);
        backBtn = findViewById(R.id.backBtn);

        donorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectRegActivity.this, DonorRegistrationActivity.class);
                startActivity(intent);
            }
        });

        recipientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectRegActivity.this, RecipientRegistrationActivity.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectRegActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}