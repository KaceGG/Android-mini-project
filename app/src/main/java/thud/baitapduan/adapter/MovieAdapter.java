package thud.baitapduan.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import thud.baitapduan.dbhelper.DbHelper;
import thud.baitapduan.model.Movie;

public class MovieAdapter {
    private DbHelper myDbHelper;
    private SQLiteDatabase db;

    private String[] allColumns = {
            DbHelper.M_ID,
            DbHelper.M_TITLE,
            DbHelper.M_IMAGE,
            DbHelper.M_DIRECTOR,
            DbHelper.M_CAST,
            DbHelper.M_DESCRIPTION,
            DbHelper.M_DURATION
    };

    public MovieAdapter(Context context) {
        myDbHelper = new DbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }

//    public long insertMovie(Movie movie) {
//        db = myDbHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(DbHelper.M_TITLE, movie.getTitle());
//        values.put(DbHelper.M_DIRECTOR, movie.getDirector());
//        values.put(DbHelper.M_CAST, movie.getCast());
//        values.put(DbHelper.M_DESCRIPTION, movie.getDescription());
//        values.put(DbHelper.M_DURATION, movie.getDuration());
//        return db.insert(DbHelper.TABLE_MOVIE, null, values);
//    }

//    public int updateMovie(int id, String title, String director, String cast, String des,
//                           int duration) {
//        ContentValues values = new ContentValues();
//        values.put(DbHelper.M_TITLE, title);
//        values.put(DbHelper.M_DIRECTOR, director);
//        values.put(DbHelper.M_CAST, cast);
//        values.put(DbHelper.M_DESCRIPTION, des);
//        values.put(DbHelper.M_DURATION, duration);
//        return db.update(DbHelper.TABLE_MOVIE, values,
//                DbHelper.M_ID + "=" + id, null);
//    }

//    public int deleteMovie(int id) {
//        return db.delete(DbHelper.TABLE_MOVIE,
//                DbHelper.M_ID + "=" + id, null);
//    }

    private Movie cursorToMovie(Cursor cursor) {
        Movie value = new Movie();
        value.setId(cursor.getInt(0));
        value.setTitle(cursor.getString(1));
        value.setImage(cursor.getInt(2));
        value.setDirector(cursor.getString(3));
        value.setCast(cursor.getString(4));
        value.setDescription(cursor.getString(5));
        value.setDuration(cursor.getInt(6));
        return value;
    }

    public List<Movie> ListAllMovie() {
        List<Movie> listMovie = new ArrayList<Movie>();
        Cursor cursor = db.query(DbHelper.TABLE_MOVIE, allColumns,
                null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Movie value = cursorToMovie(cursor);
                listMovie.add(value);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return listMovie;
    }

//    public Boolean checkIfExisted(int id) {
//        Boolean existed = false;
//        List<Movie> listMovie = ListAllMovie();
//        int i = 0;
//        while ((!existed) && (i < listMovie.size()))
//            if (listMovie.get(i).getId() == id)
//                existed = true;
//            else
//                i++;
//        return existed;
//    }

    public void Close() {
        db.close();
        myDbHelper.close();
    }
}
