package test.com.carwash;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FinalPayment extends Activity {
    TextView tv22;
    String order_type,amount,timestamp,address;
    int user_id;
    Button b,b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payment);
        Intent sender=getIntent();
        String c=sender.getExtras().getString("Total Sum");

        b= (Button) findViewById(R.id.button2);
        b1=(Button) findViewById(R.id.y);
        b2=(Button) findViewById(R.id.n);
        b.setVisibility(View.GONE);
        tv22= (TextView) findViewById(R.id.tv22);
        tv22.setText("Rs "+c);
        order_type="advance";
        amount="2111";
        user_id=4;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timestamp = sdf.format(new Date());

        address="Pivet Drive";
    }

    public void home(View v){
        Intent i=new Intent(this,MainActivity.class);

        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        return;
    }
    public void yes(View v){
        Intent i=new Intent(this,InstantBooking.class);

        startActivity(i);

    }
    public void no(View v){
        switch(v.getId())
        {
            case R.id.n:
                Order order= new Order(order_type,amount,user_id,timestamp,address);
                registerUser(order);

                break;
        }
    }
    private void registerUser(Order order) {
        ServerRequest_order serverRequest = new ServerRequest_order(this);
        serverRequest.orderInBackground(order, new GetOrderCallback() {
            @Override
            public void done(Order returnedUser) {
                Toast.makeText(getApplicationContext(), "Your Order has been Placed", Toast.LENGTH_LONG).show();
            }
        });
        b.setVisibility(View.VISIBLE);
        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
    }

}