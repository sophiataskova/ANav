package com.hipmunk.tai.anav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RedFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        mLayout = R.layout.fragment_red;
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
