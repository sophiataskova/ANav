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
                mFragmentCounter++;
                final Fragment frag = getFragment();
                final String tag = getTagName();
                final Bundle bundle = new Bundle();
                bundle.putInt(ID_COUNT, mFragmentCounter);
                frag.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, frag).addToBackStack(tag).commit();
            }
        });

        final View tab0 = findViewById(R.id.tab_0);
        final View tab1 = findViewById(R.id.tab_1);
        final View tab2 = findViewById(R.id.tab_2);
        final Class thisClass = getClass();

        tab0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (thisClass != BlueActivity.class) {
                    final Intent intent = new Intent(BaseActivity.this, BlueActivity.class);
                    startActivity(intent);
                }
            }
        });
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (thisClass != RedActivity.class) {
                    final Intent intent = new Intent(BaseActivity.this, RedActivity.class);
                    startActivity(intent);
                }
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (thisClass != EmeraldActivity.class) {
                    final Intent intent = new Intent(BaseActivity.this, EmeraldActivity.class);
                    startActivity(intent);
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
