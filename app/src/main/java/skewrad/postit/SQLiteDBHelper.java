package skewrad.postit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by skewrad on 29/11/17.
 */

public class SQLiteDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME="users";
    public static final String COLUMN_ID="userid";
    public static final String COLUMN_FULLNAME="fullname";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASSWORD="password";
    public static final String COLUMN_MOBILE="mobile";

    public static final String CREATE_TABLE_QUERY=
            "CREATE TABLE" + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FULLNAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_MOBILE + " TEXT " + ")";

    public SQLiteDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ContentValues values = new ContentValues();
        values.put(SQLiteDBHelper.COLUMN_FULLNAME," fullName");
        values.put(SQLiteDBHelper.COLUMN_EMAIL, "email");
        values.put(SQLiteDBHelper.COLUMN_PASSWORD, "password");
        values.put(SQLiteDBHelper.COLUMN_MOBILE, "mobile");
        long id = db.insert(SQLiteDBHelper.TABLE_NAME,null,values);

        String[] columns = {

                SQLiteDBHelper.COLUMN_ID,
                SQLiteDBHelper.COLUMN_FULLNAME,
                SQLiteDBHelper.COLUMN_EMAIL,
                SQLiteDBHelper.COLUMN_PASSWORD,
                SQLiteDBHelper.COLUMN_MOBILE
        };

        Cursor cursor = db.query(SQLiteDBHelper.TABLE_NAME,columns,null,null,null,null,null,null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                int _id = cursor.getInt(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_ID));
                String _fname = cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_FULLNAME));
                String _email = cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_EMAIL));
                String _pass = cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_PASSWORD));
                String _mobile = cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_MOBILE));
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


}
