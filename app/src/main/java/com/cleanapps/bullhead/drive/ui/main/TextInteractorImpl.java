package com.cleanapps.bullhead.drive.ui.main;

import java.util.Random;

/**
 * Created by bullhead on 27/02/2018.
 */

public class TextInteractorImpl implements TextInteractor {
    private static final String[] texts;

    static {
        texts = new String[5];
        texts[0] = "Those at the top of mountains didn't fall there!";
        texts[1] = "No doubt! With difficulty is surely ease!";
        texts[2] = "Man will get nothing unless he works hard!";
        texts[3] = "If a man is called to be a street sweeper," +
                " he should sweep streets even as a Michelangelo painted, " +
                "or Beethoven composed music or Shakespeare wrote poetry." +
                " He should sweep streets so well that all" +
                " the hosts of heaven and earth will pause to say," +
                " ‘Here lived a great street sweeper who did his job well.";
        texts[4] = "By him in whose hand is my soul, if one of you were to carry a bundle of firewood" +
                " on his back and sell it, that would be better for him than begging a man who may" +
                " or may not give him anything.";
    }

    @Override
    public void generateText(OnTextGenerationFinished completion) {
        String text = texts[new Random().nextInt(5)];
        completion.onFinished(text);
    }
}
