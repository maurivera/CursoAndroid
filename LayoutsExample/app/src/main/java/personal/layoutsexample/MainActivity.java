package personal.layoutsexample;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private TextView mTextViewToolbarTitle;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private CoordinatorLayout mMainCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTextViewToolbarTitle = (TextView) findViewById(R.id.text_view_toolbar_title);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initViews(){
        mMainCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator_layout);
    }

    private void setupNavigationView(){
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer,mToolbar,"Open navigation drawer","Close navigation drawer"){
            public void onDrawerClosed(View view){
                // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawer.addDrawerListener(toogle);
        toogle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
    }
}
