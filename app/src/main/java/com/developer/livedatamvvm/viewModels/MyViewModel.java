package com.developer.livedatamvvm.viewModels;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.developer.livedatamvvm.datamodels.DataModel;
import com.developer.livedatamvvm.pojos.Pojo;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

   LiveData<List<Pojo>> liveDatalist;

    public MyViewModel(@NonNull Application application) {
        super(application);

        liveDatalist= DataModel.getInstance().list();

    }

    public LiveData<List<Pojo>> getList(){

        return liveDatalist;

    }
}
