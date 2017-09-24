package com.jtanuki.go.jtanuki;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {


    private static final String TAG = "TAG";
    private TextInputLayout displayName;
    private TextInputLayout email;
    private TextInputLayout password;
    private Button register;

    //FIREBASE =========================
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

    displayName = (TextInputLayout)findViewById(R.id.regDisplayName);
        email = (TextInputLayout)findViewById(R.id.regEmail);
        password = (TextInputLayout)findViewById(R.id.regPassword);

        register = (Button) findViewById(R.id.regButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display_name = displayName.getEditText().getText().toString();
                String email_name = email.getEditText().getText().toString();
                String password_name = password.getEditText().getText().toString();


                registerUser(display_name,email_name,password_name);

            }
        });

    }

    private void registerUser(String display_name, String email_name, String password_name) {

        mAuth.createUserWithEmailAndPassword(email_name, password_name)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();

                        }else{

                            Toast.makeText(RegisterActivity.this, "DADMN",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }


}
