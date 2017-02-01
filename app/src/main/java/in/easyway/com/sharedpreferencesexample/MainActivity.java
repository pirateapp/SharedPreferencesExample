package in.easyway.com.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String Default="";
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);

    }
    public void save(View v){
        String name=et1.getText().toString();
        String password=et2.getText().toString();

        if(name.equals(Default)||password.equals(Default)){

            Toast.makeText(getApplicationContext(),"Please enter the data to save",Toast.LENGTH_LONG).show();

        }
        else {

            SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", name);
            editor.putString("password", password);
            editor.commit();
            Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_LONG).show();
        }
    }
    public void Next(View v){

        Intent intent=new Intent(this,Two.class);
        startActivity(intent);

    }
}
