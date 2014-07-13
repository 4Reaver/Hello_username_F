package com.example.reaver.hello_username_f;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
    private Button say_hi;
    private TextView hello_text;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment1 = getFragmentManager().findFragmentById(R.id.fragment1);
        Fragment fragment2 = getFragmentManager().findFragmentById(R.id.fragment2);

        say_hi = (Button) fragment1.getView().findViewById(R.id.button);
        say_hi.setOnClickListener(this);
        editText = (EditText) fragment1.getView().findViewById(R.id.editText);
        hello_text = (TextView) fragment2.getView().findViewById(R.id.greeting);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String username = editText.getText().toString();

        editText.setText("");
        if ( username.equals("") ) {
            Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
        } else {
            hello_text.setText(getString(R.string.prefix) + username + getString(R.string.suffix));
        }
    }
}
