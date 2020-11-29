package com.nayyab.Sajid.Chapters.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.nayyab.Sajid.Chapters.R;
import com.nayyab.Sajid.Chapters.Utilities.Constants;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "Description";
    ProgressDialog mProgressDialog;
    private Context mContext;
    private Bundle extras;
    private Toolbar mToolbar;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mContext = DetailActivity.this;

        // TODO: 10/22/2020 ToolBar Calling ...
        initToolBar();

        // TODO: 10/22/2020 WebView Calling....
        initPDFViewer();
    }
    private void initToolBar() {
        mToolbar = findViewById(R.id.mtoolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(data);
        // back action  "<-"....
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void initPDFViewer(){
        extras = getIntent().getExtras();
        if (extras!=null){

            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.show();

            data = extras.getString("titles");
            Log.d(TAG, "onCreate: the coming data is "+ data);
            String url = data+".pdf";
            PDFView pdfView = findViewById(R.id.pdfView);
            try {
                pdfView.fromAsset(url).load();
                Objects.requireNonNull(getSupportActionBar()).setTitle(data.replace("_"," "));
            } catch (Exception e){
                e.printStackTrace();
            }
            mProgressDialog.dismiss();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
                onBackPressed();
                return true;
            case android.R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}