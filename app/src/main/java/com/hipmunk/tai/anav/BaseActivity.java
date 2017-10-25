package com.hipmunk.tai.anav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BaseActivity extends AppCompatActivity {

    private int mFragmentCounter = 0;
    public final static String ID_COUNT = "id_count";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, getFragment()).commit();
        findViewById(R.id.fragment_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // increment the fragment count
                mFragmentCounter++;
                final Fragment frag = getFragment();
                final String tag = getTagName();
                final Bundle bundle = new Bundle();
                bundle.putInt(ID_COUNT, mFragmentCounter);
                frag.setArguments(bundle);
                // adds the fragment to the stack. this would be used instead of startActivity to maintain a separate stack for each tab
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, frag).addToBackStack(tag).commit();
            }
        });

        initBottomTabBar();
    }

    /**
     * Setup for the bottom nav bar. Sets an click listeners and renders the active tab.
     */
    protected void initBottomTabBar() {
        final View tab0 = findViewById(R.id.tab_0);
        final View tab1 = findViewById(R.id.tab_1);
        final View tab2 = findViewById(R.id.tab_2);

        tab0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // start BlueActivity if not active tab
                // this would be checking against an enum in the real application
                if (getActiveTab() != 0) {
                    final Intent intent = new Intent(BaseActivity.this, BlueActivity.class);
                    startActivity(intent);
                }
                // otherwise, replace with the default fragment
                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, getFragment()).commit();
                }
            }
        });
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // start RedActivity if not active tab
                if (getActiveTab() != 1) {
                    final Intent intent = new Intent(BaseActivity.this, RedActivity.class);
                    startActivity(intent);
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, getFragment()).commit();
                }
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // start EmeraldActivity if not active tab
                if (getActiveTab() != 2) {
                    final Intent intent = new Intent(BaseActivity.this, EmeraldActivity.class);
                    startActivity(intent);
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, getFragment()).commit();
                }
            }
        });

        final View tabView;
        switch (getActiveTab()) {
            case 0:
                tabView = tab0;
                break;
            case 1:
                tabView = tab1;
                break;
            default:
                tabView = tab2;
                break;
        }
        // setting active tab
        tabView.setBackgroundColor(getResources().getColor(R.color.selected_tab));
    }

    protected Fragment getFragment() {
        return new BlueFragment();
    }

    protected String getTagName() {
        return "blue";
    }

    protected int getActiveTab() {
        return 0;
    }
}
