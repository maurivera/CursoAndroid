package personal.layoutsexample;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
    RelativeLayoutFragment.OnRelativeLayoutInteraction{


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
        initViews();
        setupNavigationView();
        showInitialFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
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
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void showInitialFragment(){showLinearLayoutFragment();}

    public boolean onNavigationItemSelected(MenuItem item)
    {
        int navigationDrawerSelectedItem = item.getItemId();

        switch (navigationDrawerSelectedItem){
            case R.id.nav_linear_layout:
                showLinearLayoutFragment();
                break;
                case R.id.nav_relative_layout:
                    showRelativeLayoutFragment();
                    break;
            case R.id.nav_flexible_layout:
                showFlexibleLayoutFragment();
                break;
        }

    }
}
