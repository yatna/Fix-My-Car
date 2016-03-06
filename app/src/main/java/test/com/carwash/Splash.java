package test.com.carwash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;



public class Splash extends ActionBarActivity {
   ProgressBar pg;
    int progress=0;
    Handler h=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pg=(ProgressBar)findViewById(R.id.pb);
        new Thread(new Runnable(){

            @Override
            public void run() {
             for(int i=0;i<2;i++){
                 progress+=50;
                 h.post(new Runnable(){

                     @Override
                     public void run() {
                         pg.setProgress(progress);
                         if(progress==pg.getMax())
                         {
                             //pg.setVisibility(View.INVISIBLE);
                             Intent a= new Intent(getApplicationContext(),First_Screen.class);
                             startActivity(a);
                         }
                     }
                 });
                 try{
                     Thread.sleep(2000);

                 }catch(InterruptedException e){

                 }
             }
            }
        }).start();
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
}
