package com.nayyab.Sajid.Chapters;

import androidx.appcompat.app.ActionBarDrawerToggle;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.nayyab.Sajid.Chapters.Activities.PolicyActivity;
import com.nayyab.Sajid.Chapters.Adapters.MathFormulasAdapter;
import com.nayyab.Sajid.Chapters.Models.ChildDataItem;
import com.nayyab.Sajid.Chapters.Models.ParentDataItem;
import com.nayyab.Sajid.Chapters.Utilities.Constants;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.Objects;

import static com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_PUSH_DURATION;
import static com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_RELEASE_DURATION;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerView;
    private Context mContext;
    MathFormulasAdapter mathFormulasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 11/2/2020 toolbar and Navigation Drawer ...
        initToolbar();
        initRecyclerView();

    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void layoutAnimation(RecyclerView mRecyclerView){
        mContext = mRecyclerView.getContext();
        LayoutAnimationController animationController =
                AnimationUtils.loadLayoutAnimation(mContext, R.anim.layout_down_up);
        mRecyclerView.setLayoutAnimation(animationController);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        mRecyclerView.scheduleLayoutAnimation();
    }
    private void initRecyclerView() {
        mContext = MainActivity.this;
        mRecyclerView = findViewById(R.id.recyclerView);
        mathFormulasAdapter = new MathFormulasAdapter(getDataToPass());

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        try {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mRecyclerView.setAdapter(mathFormulasAdapter);
            mRecyclerView.setHasFixedSize(true);
        } catch (Exception e){
            e.printStackTrace();
        }
        mProgressDialog.dismiss();
    }
    private ArrayList<ParentDataItem> getDataToPass() {
        ArrayList<ParentDataItem> arrDummyData = new ArrayList<>();
        ArrayList<ChildDataItem> childDataItems;
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP1_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP1_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP1_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP1_SUB_ITEM_4));
        //arrDummyData.add(new DummyParentDataItem("ChHAPTER 1 - NUMBER SETS", childDataItems));
        arrDummyData.add(new ParentDataItem(R.drawable.sets_1,"Chapter 1 - NUMBER SETS", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP2_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP2_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP2_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP2_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP2_SUB_ITEM_5));
        childDataItems.add(new ChildDataItem(Constants.CHAP2_SUB_ITEM_6));
        childDataItems.add(new ChildDataItem(Constants.CHAP2_SUB_ITEM_7));
        childDataItems.add(new ChildDataItem(Constants.CHAP2_SUB_ITEM_8));
        arrDummyData.add(new ParentDataItem(R.drawable.algebra_2,"Chapter 2 - ALGEBRA", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_5));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_6));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_7));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_8));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_9));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_10));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_11));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_12));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_13));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_14));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_15));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_16));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_17));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_18));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_19));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_20));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_21));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_22));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_23));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_24));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_25));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_26));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_27));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_28));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_29));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_30));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_31));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_32));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_33));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_34));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_35));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_36));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_37));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_38));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_39));
        childDataItems.add(new ChildDataItem(Constants.CHAP3_SUB_ITEM_40));
        arrDummyData.add(new ParentDataItem(R.drawable.geometry_3,"Chapter 3 - GEOMETRY", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_5));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_6));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_7));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_8));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_9));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_10));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_11));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_12));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_13));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_14));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_15));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_16));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_17));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_18));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_19));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_20));
        childDataItems.add(new ChildDataItem(Constants.CHAP4_SUB_ITEM_21));
        arrDummyData.add(new ParentDataItem(R.drawable.trignometry_4,"Chapter 4 - TRIGONOMETRY", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP5_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP5_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP5_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP5_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP5_SUB_ITEM_5));
        arrDummyData.add(new ParentDataItem(R.drawable.hyperbolic_5,"Chapter 5 - MATRICES AND DETERMINANTS", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP6_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP6_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP6_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP6_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP6_SUB_ITEM_5));
        childDataItems.add(new ChildDataItem(Constants.CHAP6_SUB_ITEM_6));
        childDataItems.add(new ChildDataItem(Constants.CHAP6_SUB_ITEM_7));
        arrDummyData.add(new ParentDataItem(R.drawable.vector_6,"Chapter 6 - Vectors", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_5));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_6));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_7));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_8));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_9));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_10));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_11));
        childDataItems.add(new ChildDataItem(Constants.CHAP7_SUB_ITEM_12));
        arrDummyData.add(new ParentDataItem(R.drawable.ana_geo_7,"Chapter 7 - Analytic Geometry", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_5));
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_6));
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_7));
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_8));
        childDataItems.add(new ChildDataItem(Constants.CHAP8_SUB_ITEM_9));
        arrDummyData.add(new ParentDataItem(R.drawable.diff_8,"Chapter 8 - Differential Calculus", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_5));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_6));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_7));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_8));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_9));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_10));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_11));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_12));
        childDataItems.add(new ChildDataItem(Constants.CHAP9_SUB_ITEM_13));
        arrDummyData.add(new ParentDataItem(R.drawable.int_9,"Chapter 9 - Integral Calculus", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP10_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP10_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP10_SUB_ITEM_3));
        arrDummyData.add(new ParentDataItem(R.drawable.diff_eq_10,"Chapter 10 - Differential Equations", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_2));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_3));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_4));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_5));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_6));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_7));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_8));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_9));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_10));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_11));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_12));
        childDataItems.add(new ChildDataItem(Constants.CHAP11_SUB_ITEM_13));
        arrDummyData.add(new ParentDataItem(R.drawable.series_11,"Chapter 11 - Series", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem(Constants.CHAP12_SUB_ITEM_1));
        childDataItems.add(new ChildDataItem(Constants.CHAP12_SUB_ITEM_2));
        arrDummyData.add(new ParentDataItem(R.drawable.prob_12,"Chapter 12 - Probability", childDataItems));
        /////////

        return arrDummyData;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finishAffinity();
            finish();
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            //Toast.makeText(MainActivity.this,"nav bookmark",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_rate_us) {
            Constants.showRatingDialog(mContext);
        } else if (id == R.id.nav_share) {
            Constants.share(mContext);
        } else if (id == R.id.nav_moreapps) {
            Constants.showMoreApps(mContext);
        } else if (id == R.id.nav_feedback) {
            showFeedbackDialog(this);
        } else if (id == R.id.nav_privacy_policy) {
            showPolicy();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.ic_search);

        SearchView searchView =(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mathFormulasAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ic_share:
                Constants.share(mContext);
                return true;
            case R.id.ic_rate_us:
                Constants.showRatingDialog(mContext);
                return true;
            case R.id.ic_moreapps:
                Constants.showMoreApps(mContext);
                return true;
            case R.id.ic_exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public static void showFeedbackDialog(Activity activity){
        final androidx.appcompat.app.AlertDialog alertDialog;
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(activity);
        View view = LayoutInflater.from(activity).inflate(R.layout.dailog_feedback, null);
        builder.setView(view);
        final EditText edt_feedback = view.findViewById(R.id.edt_feedback);
        TextView btn_submit = view.findViewById(R.id.btn_submit);
        TextView btn_cancel = view.findViewById(R.id.btn_cancel);
        alertDialog = builder.create();
        Objects.requireNonNull(alertDialog.getWindow()).getAttributes().windowAnimations = R.style.DialogAnimationTheme;
        PushDownAnim.setPushDownAnimTo(btn_submit).setScale(MODE_SCALE, 0.89f).setDurationPush(DEFAULT_PUSH_DURATION).setDurationRelease(DEFAULT_RELEASE_DURATION);
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();

        btn_cancel.setOnClickListener(v -> alertDialog.dismiss());
        btn_submit.setOnClickListener(v -> {

            if (!TextUtils.isEmpty(edt_feedback.getText().toString())) {
                alertDialog.dismiss();
                sendFeedbackFromUser(activity, edt_feedback.getText().toString());
            } else {
                Toast.makeText(activity, "" + activity.getString(R.string.empty_feedback), Toast.LENGTH_SHORT).show();
            }

        });
    }
    private static void sendFeedbackFromUser(Activity activity, String txt){
        String mailto = "mailto:" + activity.getString(R.string.feedback_mail) +
                "?cc=" + "" +
                "&subject=" + Uri.encode(activity.getString(R.string.app_name)) +
                "&body=" + Uri.encode(txt);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));
        try {
            activity.startActivity(emailIntent);
        } catch (ActivityNotFoundException ignored) {
        }
    }
    private void showPolicy(){
        Intent intent = new Intent(getApplicationContext(), PolicyActivity.class);
        startActivity(intent);
    }
}