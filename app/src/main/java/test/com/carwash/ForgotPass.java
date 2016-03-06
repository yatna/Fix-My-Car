package test.com.carwash;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ForgotPass extends ActionBarActivity {
    EditText username,phone;
String usr,phn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpass);
        username= (EditText) findViewById(R.id.et3);
        phone= (EditText) findViewById(R.id.et4);
        usr=username.toString();
        phn=phone.toString();

    }
    public void ok(View v){
        Intent loginIntent = new Intent(this, MainActivity.class);
        startActivity(loginIntent);
        Toast.makeText(getApplicationContext(), "Your New Password will be given soon", Toast.LENGTH_LONG).show();
    }


  /*  @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.b4:
                Toast.makeText(getApplicationContext(), "Your New Password will be given soon", Toast.LENGTH_LONG).show();
               // Forgot forgot= new Forgot(usr,phn);
              //  registerUser(forgot);
                break;
        }
    }*/
   /* private void registerUser(Forgot forgot) {
        ServerRequest_forgot serverRequest = new ServerRequest_forgot(this);
        serverRequest.orderInBackground(forgot, new GetForgotCallback() {
            @Override
            public void done(Forgot returnedUser) {
                Toast.makeText(getApplicationContext(), "Your New Password will be given soon", Toast.LENGTH_LONG).show();
            }
        });
    }*/
}
