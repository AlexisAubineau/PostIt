package skewrad.postit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by skewrad on 29/11/17.
 */

public class Inscription extends Activity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_layout);

        openHelper = new DatabaseHandler(this, "postit.db", null, 1);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText firstname = (EditText) findViewById(R.id.name);
        final EditText lastname = (EditText) findViewById(R.id.lastname);
        final EditText mail = (EditText) findViewById(R.id.mail);
        final EditText password = (EditText) findViewById(R.id.password);
        Button register = (Button) findViewById(R.id.endsign);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = openHelper.getWritableDatabase();

                String user = username.getText().toString();
                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                String email = mail.getText().toString();
                String pass = password.getText().toString();

                InsertData(user, fname, lname, email, pass);

                final AlertDialog.Builder builder = new AlertDialog.Builder(Inscription.this);
                builder.setTitle("Information");
                builder.setMessage("Votre compte à été créer avec succé.");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                        finish();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    public void InsertData(String username, String firstname, String lastname, String email, String password ) {

        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.COL_USERNAME,username);
        values.put(DatabaseHandler.COL_FIRSTNAME,firstname);
        values.put(DatabaseHandler.COL_LASTNAME,lastname);
        values.put(DatabaseHandler.COL_MAIL,email);
        values.put(DatabaseHandler.COL_PASSWORD,password);
        long id = db.insert(DatabaseHandler.USER_TABLE_NAME,null,values);

    }
}
