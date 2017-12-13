package skewrad.postit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by skewrad on 13/12/17.
 */

public class DAO {
    private final static int VERSION = 1;
    private final static String NOM = "postit.db";

    private SQLiteDatabase mDb = null;
    private DatabaseHandler mHandler = null;

    DAO(Context pcontext) {
        this.mHandler = new DatabaseHandler(pcontext, NOM, null, VERSION);
    }

    private void open(){
        mDb = mHandler.getWritableDatabase();
    }

    SQLiteDatabase getDB(){
        if (mDb == null){
            open();
        }
        return mDb;
    }
}
