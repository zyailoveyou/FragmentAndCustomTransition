package com.cop.zqc.fragmentmywork;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import org.w3c.dom.Text;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> PresentID = new MutableLiveData<>();


    public void SetSelectView(String text){

        PresentID.setValue(text);
    }

    public LiveData<String> GetSelectID()
    {
        return PresentID;
    }


}
