package in.easyway.com.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Two extends AppCompatActivity {

    EditText et1,et2;
    public static final String Default="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
    }

    public void load(View v){

        SharedPreferences sharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("username",Default);
        String password=sharedPreferences.getString("password",Default);

        if(name.equals(Default)||password.equals(Default)){

            Toast.makeText(getApplicationContext(),"No data found ",Toast.LENGTH_LONG).show();
        }
        else{

            et1.setText(name);
            et2.setText(password);
        }
    }

    public void previous(View v){

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
