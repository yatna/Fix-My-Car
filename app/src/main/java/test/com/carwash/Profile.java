package test.com.carwash;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Profile extends ActionBarActivity  {
    UserLocalStore userLocalStore;
    TextView etName, etPhone, etUsername,etAddress;
int a;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        etUsername = (TextView) findViewById(R.id.etUsername);
        etName = (TextView) findViewById(R.id.etName);
       etPhone = (TextView) findViewById(R.id.etPhone);

        etAddress=(TextView)findViewById(R.id.etAddress);



        userLocalStore = new UserLocalStore(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,EditProfile.class);
            intent.putExtra("ID",a);
            startActivity(intent);

           // Toast.makeText(getApplicationContext(), user.id+"", Toast.LENGTH_LONG).show();
        }
        if(id==R.id.action_logout){
            userLocalStore.clearUserData();
            userLocalStore.setUserLoggedIn(false);
            Intent loginIntent = new Intent(this, First_Screen.class);
            startActivity(loginIntent);
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {
            displayUserDetails();
        }else {
            startActivity(new Intent(Profile.this,First_Screen.class));
        }
    }

    private boolean authenticate() {
        if (userLocalStore.getLoggedInUser() == null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return false;
        }
        return true;
    }

    private void displayUserDetails() {
        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username+user.id);
 a=user.id;



        etName.setText(user.name);
        etPhone.setText(user.phone);
        etAddress.setText(user.address);
    }
}
