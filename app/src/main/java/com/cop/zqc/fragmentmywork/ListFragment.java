package com.cop.zqc.fragmentmywork;

import android.app.Activity;
import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mList;

    private ListViewOnClick mListViewOnClick;

    private  MyViewModel mMyViewModel;

    public interface ListViewOnClick{

        public void OnClickItem(AdapterView<?> parent, View view, int position, long id);

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMyViewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(MyViewModel.class);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListViewOnClick  = (ListViewOnClick)activity;
        } catch (Exception e) {
            throw new ClassCastException(activity.toString() + " must implement ListViewOnClick");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listview,container,false);

        mList = view.findViewById(R.id.ListSelect);

        String[] DataInitial = new String[]{

                "Select1","Select2","Select3","Select4",
                "Select5","Select6","Select7","Select8",
                "Select9","Select10","Select11","Select12"
        };

        ArrayList<String> Data = new ArrayList<>();

        for (int i = 0; i < DataInitial.length; i++) {

            Data.add(DataInitial[i]);

        }

        MyAdapter myAdapter = new MyAdapter(Data,getActivity());
        mList.setAdapter(myAdapter);
        mList.setOnItemClickListener(this);

        return view;

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View theview, int position, long id) {

        String Text = (String) ((TextView)theview).getText();

        mMyViewModel.SetSelectView(Text);

//        mListViewOnClick.OnClickItem(parent,theview,position,id);

    }

}
