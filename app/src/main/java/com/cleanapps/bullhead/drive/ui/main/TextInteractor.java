package com.cleanapps.bullhead.drive.ui.main;

/**
 * Created by bullhead on 27/02/2018.
 */

public interface TextInteractor {
    interface OnTextGenerationFinished {
        void onFinished(String text);
    }

    void generateText(OnTextGenerationFinished completion);
}
