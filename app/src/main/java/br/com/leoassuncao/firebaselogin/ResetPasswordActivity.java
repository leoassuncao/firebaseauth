package br.com.leoassuncao.firebaselogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by leonardo.filho on 03/01/2018.
 */

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText inputEmail;
    private Button btnReset, btnBack;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

    inputEmail = findViewById(R.id.email);
    btnReset = findViewById(R.id.btn_reset_password);
    btnBack = findViewById(R.id.btn_back);
    progressBar = findViewById(R.id.progressBar);

    auth = FirebaseAuth.getInstance();

    btnBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });

    btnReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String email = inputEmail.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), R.string.enter_register_email, Toast.LENGTH_SHORT).show();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(ResetPasswordActivity.this, R.string.sent_email_password_reset, Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(ResetPasswordActivity.this, R.string.failed_send_email, Toast.LENGTH_LONG).show();
                    }

                    progressBar.setVisibility(View.GONE);
                }
            });
        }
    });
    }


}
