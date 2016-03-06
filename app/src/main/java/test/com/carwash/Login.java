package test.com.carwash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by yatna
 */
public class Login extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void login(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}
