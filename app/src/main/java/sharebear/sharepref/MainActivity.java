package sharebear.sharepref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    TextView tekst;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        tekst = (TextView) findViewById(R.id.tekst);

    }

    public void saveInfo(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("usetInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username" , user.getText().toString());
        editor.putString("password", pass.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

    public void displayInfo(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("usetInfo", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username", "");
        String pw = sharedPreferences.getString("password", "");
        tekst.setText(name + " " + pw);

    }

}
