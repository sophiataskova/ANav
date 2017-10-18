package com.hipmunk.tai.anav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.hipmunk.tai.anav.MainActivity.ID_COUNT;

public class BaseFragment extends Fragment {

    protected int mLayout;
    int mCounter = 0;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
            @Nullable
            final ViewGroup container,
            @Nullable
            final Bundle savedInstanceState) {
        final View v = inflater.inflate(mLayout, container, false);
        ((TextView)v.findViewById(R.id.main_text)).setText(String.valueOf(mCounter));
        return v;
    }

    @Override
    public void setArguments(final Bundle args) {
        super.setArguments(args);
        try {
            mCounter = args.getInt(ID_COUNT, 0);
//            ((TextView)getView().findViewById(R.id.main_text)).setText(String.valueOf(count));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
