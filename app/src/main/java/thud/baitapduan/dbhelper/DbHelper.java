package thud.baitapduan.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import thud.baitapduan.R;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "MovieTheater.db";
    protected static final int DB_VERSION = 1;

    public static final String TABLE_CUSTOMER = "customer";
    public static final String C_ID = "id";
    public static final String C_PWD = "password";
    public static final String C_NAME = "name";
    public static final String C_EMAIL = "email";
    public static final String C_PHONE = "phone";
    private static final String CREATE_TABLE_CUSTOMER
            = "CREATE TABLE " + TABLE_CUSTOMER + "("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_NAME + " TEXT, "
            + C_PWD + " TEXT, "
            + C_EMAIL + " TEXT, "
            + C_PHONE + " TEXT);";

    public static final String TABLE_MOVIE = "movie";
    public static final String M_ID = "id";
    public static final String M_TITLE = "title";
    public static final String M_DESCRIPTION = "description";
    public static final String M_IMAGE = "image_url";
    public static final String M_DIRECTOR = "director";
    public static final String M_CAST = "movie_cast";
    public static final String M_DURATION = "duration";
    private static final String CREATE_TABLE_MOVIE
            = "CREATE TABLE " + TABLE_MOVIE + "("
            + M_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + M_TITLE + " TEXT, "
            + M_IMAGE + " TEXT, "
            + M_DIRECTOR + " TEXT, "
            + M_CAST + " TEXT, "
            + M_DESCRIPTION + " TEXT, "
            + M_DURATION + " INTEGER);";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CUSTOMER);
        db.execSQL(CREATE_TABLE_MOVIE);
        db.execSQL("INSERT INTO " + TABLE_CUSTOMER +
                " (" + C_NAME + "," + C_PWD + "," + C_EMAIL + "," + C_PHONE + ")" +
                " VALUES ('admin', 'admin','admin@gmail.com', '0914932098')");
        db.execSQL("INSERT INTO " + TABLE_MOVIE +
                " (" + M_TITLE + ", " + M_IMAGE + ", " + M_DIRECTOR + ", " + M_CAST + ", " +
                M_DESCRIPTION + ", " + M_DURATION + ")" +
                " VALUES ('Godzilla x Kong: The New Empire', " + R.drawable.img001 + ", 'Adam Wingard'," +
                "'Rebecca Hall, Brian Tyree Henry, Dan Stevens', " +
                "'Two ancient titans, Godzilla and Kong, clash in an epic battle as humans unravel their intertwined origins and connection to Skull Island mysteries.'," +
                "115)");
        db.execSQL("INSERT INTO " + TABLE_MOVIE +
                " (" + M_TITLE + ", " + M_IMAGE + ", " + M_DIRECTOR + ", " + M_CAST + ", " +
                M_DESCRIPTION + ", " + M_DURATION + ")" +
                " VALUES ('Avengers: Endgame', " + R.drawable.img002 + ", 'Anthony Russo, Joe Russo'," +
                "'Robert Downey Jr., Chris Evans, Mark Ruffalo', " +
                "'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe.'," +
                "181)");
        db.execSQL("INSERT INTO " + TABLE_MOVIE +
                " (" + M_TITLE + ", " + M_IMAGE + ", " + M_DIRECTOR + ", " + M_CAST + ", " +
                M_DESCRIPTION + ", " + M_DURATION + ")" +
                " VALUES ('Pacific Rim', " + R.drawable.img003 + ", 'Guillermo del Toro'," +
                "'Idris Elba, Charlie Hunnam, Rinko Kikuchi', " +
                "'As a war between humankind and monstrous sea creatures wages on, a former pilot and a trainee are paired up to drive a seemingly obsolete special weapon in a desperate effort to save the world from the apocalypse.'," +
                "131)");
        db.execSQL("INSERT INTO " + TABLE_MOVIE +
                " (" + M_TITLE + ", " + M_IMAGE + ", " + M_DIRECTOR + ", " + M_CAST + ", " +
                M_DESCRIPTION + ", " + M_DURATION + ")" +
                " VALUES ('Your Name', " + R.drawable.img004 + ", 'Makoto Shinkai'," +
                "'Ryunosuke Kamiki, Mone Kamishiraishi, Ryo Narita', " +
                "'Two teenagers share a profound, magical connection upon discovering they are swapping bodies. Things manage to become even more complicated when the boy and girl decide to meet in person.'," +
                "106)");
        db.execSQL("INSERT INTO " + TABLE_MOVIE +
                " (" + M_TITLE + ", " + M_IMAGE + ", " + M_DIRECTOR + ", " + M_CAST + ", " +
                M_DESCRIPTION + ", " + M_DURATION + ")" +
                " VALUES ('Weathering with You', " + R.drawable.img005 + ", 'Makoto Shinkai'," +
                "'Kotaro Daigo, Nana Mori, Tsubasa Honda', " +
                "'Set during a period of exceptionally rainy weather, high-school boy Hodaka Morishima runs away from his troubled rural home to Tokyo and befriends an orphan girl who can manipulate the weather.'," +
                "112)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIE);
        onCreate(db);
    }
}