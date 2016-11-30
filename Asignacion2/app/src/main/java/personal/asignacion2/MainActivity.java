package personal.asignacion2;

import android.content.Intent;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import personal.asignacion2.Factorial.FactorialLayoutFragment;
import personal.asignacion2.Fibonacci.FibonacciLayoutFragment;

/**/
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //https://materialdesignicons.com/
    private Toolbar mToolbar;
    private TextView mTextViewToolbarTitle;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private CoordinatorLayout mMainCoordinatorLayout;
    private int ActiveFragment; //1 factorial, 2 fibonacci
    private Fragment MyActiveFragment;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTextViewToolbarTitle = (TextView) findViewById(R.id.text_view_toolbar_tittle);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initViews() {
        mMainCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator_layout);
    }

    private void setupNavigationView() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void showInitialFragment() {
        showFactorialFragment();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int navigationDrawerSelectedItem = item.getItemId();

        switch (navigationDrawerSelectedItem) {
            case R.id.nav_factorial_layout:
                showFactorialFragment();
                break;
            case R.id.nav_fibonacci_layout:
                showFibonacciFragment();
                break;
        }
        mNavigationView.setCheckedItem(navigationDrawerSelectedItem);
        mDrawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private void showFactorialFragment() {
        updateToolbarTitle(getString(R.string.factorial_fragment_title));
        MyActiveFragment = FactorialLayoutFragment.newInstance();
        changeFragment(MyActiveFragment);
        ActiveFragment = 1; // factorial
    }

    private void showFibonacciFragment() {
        updateToolbarTitle(getString(R.string.fibonacci_fragment_title));
        MyActiveFragment = FibonacciLayoutFragment.newInstance();
        changeFragment(MyActiveFragment);
        ActiveFragment = 2; // fibonacci
    }

    private void updateToolbarTitle(String toolbarTitle) {
        mTextViewToolbarTitle.setText(toolbarTitle);
    }

    private void changeFragment(Fragment newFragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main_activity, newFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                shareInfo();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareInfo() {
        StringBuilder strSubject = new StringBuilder();
        StringBuilder strBody = new StringBuilder();

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);

        strBody.append(getString(R.string.share_body));
        strBody.append(" ");

        if (ActiveFragment == 1)
        {
            strSubject.append(getString(R.string.share_subject_Factorial));

            strBody.append(getString(R.string.factorial_fragment_title));
            strBody.append(" ");
            strBody.append(Long.toString(((FactorialLayoutFragment)MyActiveFragment).numeroacalcular));
            strBody.append(" ");
            strBody.append(getString(R.string.share_body_2));
            strBody.append(" ");
            strBody.append( Long.toString(((FactorialLayoutFragment)MyActiveFragment).miresultado));
        }
        else {
            strSubject.append(getString(R.string.share_subject_Fibonacci));

            strBody.append(getString(R.string.fibonacci_fragment_title));
            strBody.append(" ");
            strBody.append(Long.toString(((FibonacciLayoutFragment)MyActiveFragment).numeroacalcular));
            strBody.append(" ");
            strBody.append(getString(R.string.share_body_2));
            strBody.append(" ");
            strBody.append( Long.toString(((FibonacciLayoutFragment)MyActiveFragment).miresultado));
        }

        shareIntent.putExtra(Intent.EXTRA_SUBJECT,strSubject.toString() );
        shareIntent.putExtra(Intent.EXTRA_TEXT, strBody.toString());
        shareIntent.setType("text/plain");

        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
        }
    }
}
