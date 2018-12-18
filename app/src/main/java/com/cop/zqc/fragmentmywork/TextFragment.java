package com.cop.zqc.fragmentmywork;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {

    private View mView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_articlecontent,container,false);

        return mView;

    }

    public void SetText(String text){

        TextView introduction = mView.findViewById(R.id.Introduction);

        introduction.setText(text);

    }

}
