package thud.baitapduan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import thud.baitapduan.R;
import thud.baitapduan.model.Customer;
import thud.baitapduan.adapter.CustomerAdapter;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText edtUsername, edtPassword, edtConfirmPassword, edtEmail;
    TextInputLayout layoutUsername, layoutPassword, layoutConfirmPassword, layoutEmail;
    Button btnSignUp;
    CustomerAdapter customerAdapter;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.sign_up);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_pwd);
        edtConfirmPassword = findViewById(R.id.edt_confirmPwd);
        edtEmail = findViewById(R.id.edt_email);
        layoutUsername = findViewById(R.id.layout_username);
        layoutPassword = findViewById(R.id.layout_password);
        layoutConfirmPassword = findViewById(R.id.layout_confirmPassword);
        layoutEmail = findViewById(R.id.layout_email);
        btnSignUp = findViewById(R.id.btn_signUp);

        customerAdapter = new CustomerAdapter(this);
    }

    public void SignUp(View view) {
        String strUsrname, strPassword, strConfirmPassword, strEmail, strPhoneNumber;
        strUsrname = edtUsername.getText().toString().trim();
        strPassword = edtPassword.getText().toString().trim();
        strConfirmPassword = edtConfirmPassword.getText().toString().trim();
        strEmail = edtEmail.getText().toString().trim();

        if (strUsrname.length() == 0) {
            layoutUsername.setError("The username cannot be blank!");
            edtUsername.requestFocus();
            return;
        } else layoutUsername.setError(null);
        if (strEmail.length() == 0) {
            layoutEmail.setError("The email cannot be blank!");
            layoutEmail.requestFocus();
            return;
        } else layoutEmail.setError(null);
        if (strPassword.length() == 0) {
            layoutPassword.setError("The password cannot be blank!");
            edtPassword.requestFocus();
            return;
        } else layoutPassword.setError(null);
        if (!strPassword.equals(strConfirmPassword)) {
            layoutConfirmPassword.setError("The password does not match!");
            edtConfirmPassword.setText(null);
            return;
        } else {
            edtUsername.setText(null);
            edtEmail.setText(null);
            edtPassword.setText(null);
            edtConfirmPassword.setText(null);

            customer = new Customer(strUsrname, strPassword, strEmail, null);
            customerAdapter.insertCustomer(customer);
            Toast.makeText(this, "Sign up succesfully!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }
    }

    public void GoToSignIn(View view) {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        customerAdapter.Close();
    }
}