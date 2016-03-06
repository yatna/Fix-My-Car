package test.com.carwash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


public class InstantBooking extends Activity {
    private CheckBox box1,box2,box3,box4;
    TextView tv22;
    String c;
    Double Sum=0.0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instantbook1);
        tv22= (TextView) findViewById(R.id.tv22);

        addListenerbox1();
        addListenerbox2();
        addListenerbox3();
        addListenerbox4();









    }

public void proceed(View v){
    Intent i=new Intent(this,FinalPayment.class);
    i.putExtra("Total Sum",c);
    startActivity(i);

}



    public void addListenerbox1() {
        box1 = (CheckBox) findViewById(R.id.checkBox1);
        box1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    Sum += 1000.0;
                    c = Sum.toString();
                    tv22.setText(c);
//checked
                } else if ((buttonView.isChecked())!=true) {
                    box1.setChecked(false);
//not checked
                    Sum-=1000.0;
                    c = Sum.toString();
                    tv22.setText(c);
                }

            }
        });
    }



    public void addListenerbox2() {
        box2 = (CheckBox) findViewById(R.id.checkBox2);
        box2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    Sum += 1500.0;
                    c = Sum.toString();
                    tv22.setText(c);
//checked
                } else if ((buttonView.isChecked())!=true) {
                    box2.setChecked(false);
//not checked
                    Sum-=1500.0;
                    c = Sum.toString();
                    tv22.setText(c);
                }

            }
        });
    }
    public void addListenerbox3() {
        box3 = (CheckBox) findViewById(R.id.checkBox3);
        box3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    Sum += 2500.0;
                    c = Sum.toString();
                    tv22.setText(c);
//checked
                } else if ((buttonView.isChecked())!=true) {
                    box1.setChecked(false);
//not checked
                    Sum-=2500.0;
                    c = Sum.toString();
                    tv22.setText(c);
                }

            }
        });
    }
    public void addListenerbox4() {
        box4 = (CheckBox) findViewById(R.id.checkBox4);
        box4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    Sum += 10000.0;
                    c = Sum.toString();
                    tv22.setText(c);
//checked
                } else if ((buttonView.isChecked())!=true) {
                    box1.setChecked(false);
//not checked
                    Sum-=10000.0;
                    c = Sum.toString();
                    tv22.setText(c);
                }

            }
        });
    }
}
