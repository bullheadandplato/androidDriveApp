package com.cleanapps.bullhead.drive.ui.main;

import android.os.Handler;

import com.cleanapps.bullhead.drive.R;

/**
 * Created by bullhead on 27/02/2018.
 *
 */

public class MainPresenterImpl implements MainPresenter {
    private final MainView mainView;
    private TextInteractor textInteractor;
    private boolean progressStatus;

    public MainPresenterImpl(MainView mainView, TextInteractor textInteractor) {
        this.mainView = mainView;
        this.textInteractor = textInteractor;
    }

    @Override
    public void onClick(final int viewId) {
        switch (viewId) {
            case R.id.btnClickMe:
                textInteractor.generateText(new TextInteractor.OnTextGenerationFinished() {
                    @Override
                    public void onFinished(String text) {
                        mainView.setText(text);
                    }
                });
                break;
            case R.id.btnProgress:
                if (progressStatus) {
                    mainView.hideProgress();
                } else {
                    mainView.showProgress();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            onClick(viewId);
                        }
                    }, 3000);
                }
                progressStatus = !progressStatus;
                break;
        }
    }
}
