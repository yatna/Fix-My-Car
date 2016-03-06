package test.com.carwash;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Register extends ActionBarActivity implements View.OnClickListener{


    EditText et1,et2,et3,et4,et5;
    Button b1;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       initialize();
        b1.setOnClickListener(this);



    }

    private void initialize()
    {

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5= (EditText) findViewById(R.id.et5);
        b1=(Button)findViewById(R.id.b2);
        userLocalStore = new UserLocalStore(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        return;
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.b2:
                String name = et1.getText().toString();
                String username = et3.getText().toString();
                String password = et4.getText().toString();
                String address=et5.getText().toString();
                String age = et2.getText().toString();
                int id=0;
                User user = new User(id,name, age, username, password,address);
               registerUser(user);
                Intent i=new Intent(this,MainActivity.class);



               // Bundle bundle = new Bundle();
               // bundle.putString("Name",name );
// set Fragmentclass Arguments
               // NavigationDrawerFragment fragobj = new NavigationDrawerFragment();
               // fragobj.setArguments(bundle);
               // Intent intent =new Intent(this,VivzAdapter.class);

              // intent.putExtra("Name", name);
               // i.putExtra("Phone",age);
                startActivity(i);
                break;

        }

    }

   private void registerUser(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                String username = et3.getText().toString();
                String password = et4.getText().toString();

                User user = new User(username, password);

                authenticate(user);

            }
        });
    }

    private void authenticate(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.fetchUserDataAsyncTask(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if (returnedUser == null) {
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);
                }
            }
        });
    }

    private void showErrorMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Register.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();
    }

    private void logUserIn(User returnedUser) {
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);
        startActivity(new Intent(this, MainActivity.class));
    }
}
