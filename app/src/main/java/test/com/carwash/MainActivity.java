package test.com.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;


//import android.widget.Toolbar;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private Toolbar toolbar;

    private FloatingActionButton ViewButton;
    private FloatingActionButton AdvancedBook;
    private FloatingActionButton InstantBook;
    private FloatingActionButton VButton;
    private List<FloatingActionMenu> menus = new ArrayList<>();
    private Handler mUiHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

     setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setup(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        setupFAB();
    }



    private void setupFAB() {
        int delay = 400;
        for (final FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }
        ViewButton= (FloatingActionButton) findViewById(R.id.fab1);
        AdvancedBook= (FloatingActionButton) findViewById(R.id.fab2);
        InstantBook = (FloatingActionButton) findViewById(R.id.fab3);
        VButton=(FloatingActionButton) findViewById(R.id.fab4);

        InstantBook.setOnClickListener(this);
        AdvancedBook.setOnClickListener(this);
        ViewButton.setOnClickListener(this);



    }
    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();




        if(id==R.id.nearbystations){
            startActivity(new Intent(this,MainActivityone.class));
        }
        if(id==R.id.share)
        {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }

        return super.onOptionsItemSelected(item);
    }
    private void toggleTranslateFAB(float slideOffset) {


    }

    public void onDrawerSlide(float slideOffset) {
        toggleTranslateFAB(slideOffset);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fab1:
                startActivity(new Intent(this,MapsActivity.class));
                break;
            case R.id.fab2:
                startActivity(new Intent(this,AdvancedBooking.class));
                break;
            case R.id.fab3:
                startActivity(new Intent(this,InstantBooking.class));
                break;

        }

    }
}
