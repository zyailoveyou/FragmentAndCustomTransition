package com.cop.zqc.fragmentmywork;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ListViewOnClick {

    private ListView mListSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void OnClickItem(AdapterView<?> parent, View view, int position, long id) {


        TextFragment fragment = new TextFragment();

        FragmentManager fragmentManager = getFragmentManager();

        fragment = (TextFragment) (fragmentManager.findFragmentById(R.id.ListT));

        TextView StringWord = view.findViewById(R.id.TextString);

        fragment.SetText((String) (StringWord.getText()));

    }

}
