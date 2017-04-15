package org.oursight.neyao.java.advanced.interview.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neyao on 2017/4/14.
 */
public class Elevator {

    private List<Button> buttons = new ArrayList<>();

    public Elevator(int level) {
        for (int i = 0; i < level; i++) {
            buttons.add(new Button(i));
        }
    }

//    public void


    private class Button {

        int targetLevel;
        boolean pressed;

        public Button(int targetLevel) {
            this.targetLevel = targetLevel;
        }
    }
}
