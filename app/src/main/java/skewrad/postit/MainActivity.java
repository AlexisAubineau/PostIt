package skewrad.postit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by skewrad on 29/11/17.
 */

public class MainActivity extends Activity {

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase db;
    Cursor cursor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.Connexion);
        TextView register = (TextView) findViewById(R.id.Inscription);

        dbhandler = new DatabaseHandler(this, null, null, 1);
        db = dbhandler.getReadableDatabase();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                cursor = db.rawQuery("SELECT *FROM " + DatabaseHandler.USER_TABLE_NAME + " WHERE " + DatabaseHandler.COL_USERNAME + "=? AND " + DatabaseHandler.COL_PASSWORD + "=?", new String[]{user, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {

                        cursor.moveToFirst();
                        //Retrieving User FullName and Email after successfull login and passing to LoginSucessActivity
                        String firstname = cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_FIRSTNAME));
                        String lastname = cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_LASTNAME));
                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Home.class);
                        intent.putExtra("Firstname", firstname);
                        intent.putExtra("lastname", lastname);
                        startActivity(intent);

                        //Removing MainActivity[Login Screen] from the stack for preventing back button press.
                        finish();
                    }
                }

            }
        });

        // Intent For Opening RegisterAccountActivity
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Inscription.class);
                startActivity(intent);
            }
        });
    }
}
