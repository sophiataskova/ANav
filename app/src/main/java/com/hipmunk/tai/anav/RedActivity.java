package com.hipmunk.tai.anav;

import android.support.v4.app.Fragment;

public class RedActivity extends BaseActivity {

    @Override
    protected Fragment getFragment() {
        return new RedFragment();
    }

    @Override
    protected String getTagName() {
        return "red";
    }

    protected int getActiveTab() {
        return 1;
    }
}
