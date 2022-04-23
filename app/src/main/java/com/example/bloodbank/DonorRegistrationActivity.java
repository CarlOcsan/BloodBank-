package com.example.bloodbank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import de.hdodenhof.circleimageview.CircleImageView;

public class DonorRegistrationActivity extends AppCompatActivity {

    private TextView backBtn;

    private CircleImageView profile_img;

    private TextInputEditText registerName, registerPhoneNumber, registerIdNumber,
            registerEmail, registerPassword;

    private Spinner groupSpinner;

    private Button registerBtn;

    private Uri resultUri;

    private ProgressDialog loader;

    private FirebaseAuth mAuth;
    private DatabaseReference userDatabaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_registration);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonorRegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        profile_img = findViewById(R.id.profile_img);
        registerName = findViewById(R.id.registerName);
        registerPhoneNumber = findViewById(R.id.registerPhoneNumber);
        registerIdNumber = findViewById(R.id.registerIdNumber);
        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        groupSpinner = findViewById(R.id.groupSpinner);
        registerBtn = findViewById(R.id.registerBtn);
        loader = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = registerEmail.getText().toString().trim();
                final String password = registerPassword.getText().toString().trim();
                final String fullName = registerName.getText().toString().trim();
                final String idNumber = registerIdNumber.getText().toString().trim();
                final String phoneNumber = registerPhoneNumber.getText().toString().trim();
                final String bloodGroup = groupSpinner.getSelectedItem().toString().trim();

                if(TextUtils.isEmpty(email)){
                    registerEmail.setError(("Email is required"));
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    registerPassword.setError(("Password is required"));
                    return;
                }
                if(TextUtils.isEmpty(fullName)){
                    registerName.setError(("Name is required"));
                    return;
                }
                if(TextUtils.isEmpty(idNumber)){
                    registerIdNumber.setError(("ID is required"));
                    return;
                }
                if(TextUtils.isEmpty(phoneNumber)){
                    registerPhoneNumber.setError(("Contact Number is required"));
                    return;
                }
                if(bloodGroup.equals("Select your blood type")){
                    Toast.makeText(DonorRegistrationActivity.this, "Select Blood Group", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    loader.setMessage("Registering....");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();


                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==1 && resultCode == RESULT_OK && data !=null) {
            resultUri = data.getData();
            profile_img.setImageURI(resultUri);
        }
    }
}