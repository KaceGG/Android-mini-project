package thud.baitapduan.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import thud.baitapduan.R;
import thud.baitapduan.model.Movie;

public class MovieBookingActivity extends AppCompatActivity {
    TextInputLayout layoutName, layoutPhoneNumber;
    TextInputEditText edtName, edtPhoneNumber;
    Button btnOK, btnCancel;
    TextView txtTitle, txtDescription, txtDirector, txtCast, txtDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.movie_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        layoutName = findViewById(R.id.layout_customerName);
        layoutPhoneNumber = findViewById(R.id.layout_phoneNumber);
        edtName = findViewById(R.id.edt_customerName);
        edtPhoneNumber = findViewById(R.id.edt_phoneNumber);
        btnOK = findViewById(R.id.btn_OK);
        btnCancel = findViewById(R.id.btn_Cancel);
        txtTitle = findViewById(R.id.txt_title);
        txtDescription = findViewById(R.id.txt_description);
        txtDirector = findViewById(R.id.txt_director);
        txtCast = findViewById(R.id.txt_cast);
        txtDuration = findViewById(R.id.txt_duration);

        Intent intent = getIntent();
        Movie selectedMovie = (Movie) intent.getSerializableExtra("selectedMovie");

        String strTitle, strDescription, strDirector, strCast, strDetails;
        int duration;

        strTitle = selectedMovie.getTitle();
        strDescription = selectedMovie.getDescription();
        strCast = selectedMovie.getCast();
        strDirector = selectedMovie.getDirector();
        duration = selectedMovie.getDuration();

        txtTitle.setText(selectedMovie.getTitle());
        txtDirector.setText("Director: " + selectedMovie.getDirector());
        txtCast.setText("Cast: " + selectedMovie.getCast());
        txtDescription.setText("Description:" + selectedMovie.getDescription());
        txtDuration.setText("Movie duration: " + String.valueOf(selectedMovie.getDuration()) + " minutes");
    }

    public void OK(View view) {
        String strName = edtName.getText().toString().trim();
        if (strName.length() == 0) {
            layoutName.setError("Please enter your name!");
            edtName.requestFocus();
            return;
        } else layoutName.setError(null);
        String strPhoneNumber = edtPhoneNumber.getText().toString().trim();
        if (strPhoneNumber.length() == 0) {
            layoutPhoneNumber.setError("Please enter your phone number!");
            edtPhoneNumber.requestFocus();
            return;
        }
        AlertDialog.Builder bdrNoti = new AlertDialog.Builder(this);
        bdrNoti.setTitle("Book movie ticket succesfully!");
        bdrNoti.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MovieBookingActivity.this,
                                "Thank you, have a wonderful day!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        bdrNoti.show();
    }

    public void Cancel(View view) {
        finish();
    }
}