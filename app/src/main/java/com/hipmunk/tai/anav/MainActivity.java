package com.hipmunk.tai.anav;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int mFragmentCounter = 0;
    public final static String ID_COUNT = "id_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BlueFragment()).commit();
        findViewById(R.id.fragment_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                mFragmentCounter++;
                final Fragment frag;
                final String tag;
                final Bundle bundle = new Bundle();
                switch (mFragmentCounter % 3) {
                    case 1:
                        frag = new RedFragment();
                        tag = "red";
                        break;
                    case 2:
                        frag = new EmeraldFragment();
                        tag = "emerald";
                        break;
                    default:
                        frag = new BlueFragment();
                        tag = "blue";
                        break;
                }
                bundle.putInt(ID_COUNT, mFragmentCounter);
                frag.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, frag).addToBackStack(tag).commit();
            }
        });
    }
}
