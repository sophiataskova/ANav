package com.hipmunk.tai.anav;

import android.support.v4.app.Fragment;

public class EmeraldActivity extends BaseActivity {

    @Override
    protected Fragment getFragment() {
        return new EmeraldFragment();
    }

    @Override
    protected String getTagName() {
        return "emerald";
    }

    protected int getActiveTab() {
        return 2;
    }
}
