package com.cleanapps.bullhead.drive.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.cleanapps.bullhead.drive.R;

/**
 * Created by bullhead on 3/1/18.
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Toolbar toolbar;
    private FrameLayout contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        progressBar = findViewById(R.id.mainLoadingBar);
        toolbar = findViewById(R.id.toolbar);
        contentView = findViewById(R.id.childContent);
        setSupportActionBar(toolbar);
    }

    @Override
    public void setContentView(@LayoutRes int viewId) {
        contentView.addView(getLayoutInflater().inflate(viewId, null));
    }
}
