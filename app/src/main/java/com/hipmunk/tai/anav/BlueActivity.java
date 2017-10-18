package com.hipmunk.tai.anav;

import android.support.v4.app.Fragment;

public class BlueActivity extends BaseActivity {

    @Override
    protected Fragment getFragment() {
        return new BlueFragment();
    }

    @Override
    protected String getTagName() {
        return "blue";
    }
}
