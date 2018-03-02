package com.cleanapps.bullhead.drive.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.cleanapps.bullhead.drive.R;
import com.cleanapps.bullhead.drive.utils.CommonUtils;

/**
 * Created by bullhead on 3/1/18.
 *
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Toolbar toolbar;
    private FrameLayout contentView;
    private ImageView blurView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        progressBar = findViewById(R.id.mainLoadingBar);
        toolbar = findViewById(R.id.toolbar);
        contentView = findViewById(R.id.childContent);
        blurView = findViewById(R.id.blurView);
        setSupportActionBar(toolbar);
    }

    @Override
    public void setContentView(@LayoutRes int viewId) {
        contentView.addView(getLayoutInflater().inflate(viewId, null));
    }

    public void showProgress(boolean disableTouch) {
        progressBar.setVisibility(View.VISIBLE);
        if (disableTouch) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
        blurView.setImageBitmap(CommonUtils.blur(this, contentView, 5, 0.5f));
        blurView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        contentView.setVisibility(View.VISIBLE);
        blurView.setImageResource(android.R.color.transparent);
        blurView.setVisibility(View.GONE);
    }
}
