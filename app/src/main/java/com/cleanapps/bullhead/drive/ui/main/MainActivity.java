package com.cleanapps.bullhead.drive.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cleanapps.bullhead.drive.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter presenter;

    @BindView(R.id.tvMvp)
    TextView tvMvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenterImpl(this, new TextInteractorImpl());
    }

    @Override
    public void onClick(View view) {
        presenter.onClick(view.getId());
    }

    @Override
    public void showText() {
        tvMvp.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideText() {
        tvMvp.setVisibility(View.GONE);
    }

    @Override
    public void setText(String text) {
        tvMvp.setText(text);
    }
}
