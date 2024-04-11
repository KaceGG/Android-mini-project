package thud.baitapduan.ui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import thud.baitapduan.R;
import thud.baitapduan.adapter.CustomerAdapter;
import thud.baitapduan.adapter.MovieAdapter;
import thud.baitapduan.adapter.MovieArrayAdapter;
import thud.baitapduan.dbhelper.DbHelper;
import thud.baitapduan.model.Customer;
import thud.baitapduan.model.Movie;

public class ListMovie extends AppCompatActivity {
    MovieAdapter movieAdapter;
    MovieArrayAdapter movieArrayAdapter;
    List<Movie> listMovie;
    ListView lvMovie;
    DbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_movie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lst_movie), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        movieAdapter = new MovieAdapter(this);
        lvMovie = findViewById(R.id.lst_movie);
        listMovie = movieAdapter.ListAllMovie();
        movieArrayAdapter = new MovieArrayAdapter(
                this,
                R.layout.list_movie_item,
                (ArrayList<Movie>) listMovie
        );
        lvMovie.setAdapter(movieArrayAdapter);
        myDbHelper = new DbHelper(this);

        lvMovie.setOnItemLongClickListener(new ChooseMovie());
    }

    private class ChooseMovie implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Movie selectedMovie = listMovie.get(i);
            Intent intent = new Intent(ListMovie.this, MovieBookingActivity.class);
            intent.putExtra("selectedMovie", selectedMovie);
            startActivity(intent);
            return true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        movieAdapter.Close();
    }
}