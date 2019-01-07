package com.cop.zqc.fragmentmywork;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {

    private View mView;

    private  MyViewModel mShareViewModel;
    private TextView mMyTextView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mShareViewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(MyViewModel.class);

        mShareViewModel.GetSelectID().observe((LifecycleOwner) this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                mMyTextView.setText(mShareViewModel.GetSelectID().getValue());

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_articlecontent,container,false);

        mMyTextView = mView.findViewById(R.id.Introduction);

        return mView;

    }

    public void SetText(String text){

        TextView introduction = mView.findViewById(R.id.Introduction);

        introduction.setText(text);

    }

}
