package com.cleanapps.bullhead.drive.ui.main;

/**
 * Created by bullhead on 27/02/2018.
 */

public class MainPresenterImpl implements MainPresenter {
    private final MainView mainView;
    private TextInteractor textInteractor;

    public MainPresenterImpl(MainView mainView, TextInteractor textInteractor) {
        this.mainView = mainView;
        this.textInteractor = textInteractor;
    }

    @Override
    public void onClick(int viewId) {
        textInteractor.generateText(new TextInteractor.OnTextGenerationFinished() {
            @Override
            public void onFinished(String text) {
                mainView.setText(text);
            }
        });
    }
}
