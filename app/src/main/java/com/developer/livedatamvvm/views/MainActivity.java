package com.developer.livedatamvvm.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.developer.livedatamvvm.views.adapters.DataAdapter;
import com.developer.livedatamvvm.pojos.Pojo;
import com.developer.livedatamvvm.R;
import com.developer.livedatamvvm.databinding.ActivityMainBinding;
import com.developer.livedatamvvm.utilities.Utils;
import com.developer.livedatamvvm.viewModels.MyViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //data binding
    ActivityMainBinding activityMainBinding;
    MyViewModel mHomeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //data binding
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        mHomeViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        Utils.getInstance().showDialog(this);

        mHomeViewModel.getList().observe(this, new Observer<List<Pojo>>() {
            @Override
            public void onChanged(@Nullable List<Pojo> pojos) {
                  //api response here

                Utils.getInstance().hideProgress();

                setupAdapter(pojos);
            }
        });
        activityMainBinding.setMyViewModel(mHomeViewModel);


    }

    public void setupAdapter(List<Pojo> dataList){

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        activityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);
        DataAdapter dataAdapter=new DataAdapter(dataList,this);
        activityMainBinding.recyclerView.setAdapter(dataAdapter);

    }



}
