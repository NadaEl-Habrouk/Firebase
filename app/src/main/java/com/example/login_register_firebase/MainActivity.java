package com.example.login_register_firebase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    TextView userEmail;
    Button logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        logout = findViewById(R.id.logout);
        userEmail = findViewById(R.id.userEmail);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Check if a user is already signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String email = currentUser.getEmail();
            userEmail.setText("Hello, " + email);
        }

        // Set up the logout button click listener
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sign the user out and redirect to LoginActivity
                mAuth.signOut();
                finish();
                startActivity(new Intent(MainActivity.this, login.class));
            }
        });
    }
}
