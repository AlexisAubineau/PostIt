package skewrad.postit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.amitshekhar.DebugDB;

/**
 * Created by skewrad on 29/11/17.
 */

public class MainActivity extends Activity {

    Button send;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.Inscription);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Inscription.class);
                startActivityForResult(myIntent, 0);
            }

        });
        DebugDB.getAddressLog();
    }
}
