package thud.baitapduan.ui;

import static thud.baitapduan.dbhelper.DbHelper.C_NAME;
import static thud.baitapduan.dbhelper.DbHelper.TABLE_CUSTOMER;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import thud.baitapduan.MainActivity;
import thud.baitapduan.R;
import thud.baitapduan.adapter.CustomerAdapter;
import thud.baitapduan.dbhelper.DbHelper;
import thud.baitapduan.model.Customer;

public class SignInActivity extends AppCompatActivity {

    private TextInputLayout layoutUsername, layoutPassword;
    private TextInputEditText edtUsername, edtPassword;
    private Button btnSignIn;
    CustomerAdapter customerAdapter;
    DbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        layoutUsername = findViewById(R.id.layout_username);
        layoutPassword = findViewById(R.id.layout_password);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_pwd);
        btnSignIn = findViewById(R.id.btn_signIn);

        myDbHelper = new DbHelper(this);
        customerAdapter = new CustomerAdapter(this);
    }

    private boolean CheckIfExistedCustomer(String strUsername, String strPassword) {
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String[] columns = {DbHelper.C_NAME, DbHelper.C_PWD};
        String selection = DbHelper.C_NAME + "=? AND " + DbHelper.C_PWD + "=?";
        String[] selectionArgs = {strUsername, strPassword};
        Cursor cursor = db.query(DbHelper.TABLE_CUSTOMER, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }


    public void SignIn(View view) {
        String strUsername, strPassword;
        strUsername = edtUsername.getText().toString().trim();
        strPassword = edtPassword.getText().toString().trim();
        if (strUsername.length() == 0) {
            layoutUsername.setError("The username cannot be blank!");
            edtUsername.requestFocus();
            return;
        } else layoutUsername.setError(null);
        if (strPassword.length() == 0) {
            layoutPassword.setError("The password cannot be blank!");
            edtPassword.requestFocus();
        } else {
            layoutPassword.setError(null);
            if (CheckIfExistedCustomer(strUsername, strPassword)) {
                Toast.makeText(this, "Sign in succesfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Username or password doesn't correct!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void GoToSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}