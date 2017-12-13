package skewrad.postit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by skewrad on 13/12/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String USER_TABLE_NAME = "users";
    public static final String COL_ID_USER = "id_user";
    public static final String COL_USERNAME = "username_user";
    public static final String COL_FIRSTNAME = "firstname_user";
    public static final String COL_LASTNAME = "lastname_user";
    public static final String COL_DATE = "date_user";
    public static final String COL_PASSWORD = "password_user";

    private static final String CREATE_BDD = "CREATE TABLE " + USER_TABLE_NAME + " ("
            + COL_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_USERNAME + " TEXT NOT NULL, "
            + COL_FIRSTNAME + " TEXT NOT NULL, "
            + COL_LASTNAME + " TEXT NOT NULL, "
            + COL_DATE + " TEXT NOT NULL,"
            + COL_PASSWORD + "TEXT NOT NULL);";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + USER_TABLE_NAME + ";");
    }

}
