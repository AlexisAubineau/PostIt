package skewrad.postit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by skewrad on 13/12/17.
 */

public class UserDAO extends DAO{
    public UserDAO(Context pcontext){
        super(pcontext);
    }

    public void insertOccurence(User user) {

        ContentValues value = new ContentValues();

        value.put(DatabaseHandler.COL_USERNAME, user.getUsername());
        value.put(DatabaseHandler.COL_FIRSTNAME, user.getFirstname());
        value.put(DatabaseHandler.COL_LASTNAME, user.getLastname());
        value.put(DatabaseHandler.COL_MAIL, user.getMail());
        value.put(DatabaseHandler.COL_PASSWORD, user.getPassword());

        getDB().insert(DatabaseHandler.USER_TABLE_NAME, null, value);
    }

    public User getUser() {

        Cursor c = super.getDB().query(DatabaseHandler.USER_TABLE_NAME, new String[]{DatabaseHandler.COL_ID_USER, DatabaseHandler.COL_USERNAME, DatabaseHandler.COL_FIRSTNAME, DatabaseHandler.COL_LASTNAME, DatabaseHandler.COL_MAIL, DatabaseHandler.COL_PASSWORD}, null, null, null, null, null);
        return cursorToUser(c);
    }

    private User cursorToUser(Cursor c){
        if (c.getCount() == 0)
            return null;
        c.moveToFirst();

        User user = new User();

        int id_user = c.getInt(c.getColumnIndex(DatabaseHandler.COL_ID_USER));
        String username = c.getString(c.getColumnIndex(DatabaseHandler.COL_USERNAME));
        String firstname = c.getString(c.getColumnIndex(DatabaseHandler.COL_FIRSTNAME));
        String lastname = c.getString(c.getColumnIndex(DatabaseHandler.COL_LASTNAME));
        String mail = c.getString(c.getColumnIndex(DatabaseHandler.COL_MAIL));
        String password = c.getString(c.getColumnIndex(DatabaseHandler.COL_PASSWORD));

        user.setId(id_user);
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setMail(mail);
        user.setPassword(password);

        c.close();
        return user;
    }
}
