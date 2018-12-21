package com.cop.zqc.fragmentmywork;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ListViewOnClick {

    private ListView mListSelect;
    private TextFragment mMyTextFragment;
    private ListFragment mMyListFragment;
    private boolean ToWhichScence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyTextFragment = new TextFragment();
        mMyListFragment = new ListFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_listF, mMyListFragment);
        fragmentTransaction.add(R.id.layout_listT, mMyTextFragment);
        fragmentTransaction.commit();

        ToWhichScence=false;

    }

    @Override
    public void OnClickItem(AdapterView<?> parent, View view, int position, long id) {

        MyTransition myTransition = new MyTransition();

        ViewGroup RootViewGroup = findViewById(R.id.layout_listT);

        RootViewGroup.getX();
        RootViewGroup.getWidth();

        Scene scene1 = Scene.getSceneForLayout(RootViewGroup,R.layout.fragment_articlecontent,this);

        Scene scene2 = Scene.getSceneForLayout(RootViewGroup,R.layout.fragment_change,this);

            TransitionManager.go(scene2,myTransition);

//        TransitionManager.go(scene2);

    }

}
