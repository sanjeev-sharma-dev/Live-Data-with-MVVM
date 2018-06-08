package com.developer.livedatamvvm.datamodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.developer.livedatamvvm.utilities.ApiUrls;
import com.developer.livedatamvvm.pojos.Pojo;
import com.developer.livedatamvvm.RetrofitClient.RetrofitClient;
import com.developer.livedatamvvm.interfaces.WebServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataModel {
    List<Pojo> list;
    private static DataModel instance;

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
            return instance;
        } else {
            return instance;
        }
    }

    public LiveData<List<Pojo>> list() {

        final MutableLiveData<List<Pojo>> data = new MutableLiveData<>();
        list = new ArrayList<>();
        WebServices countriesService = RetrofitClient.getClient(ApiUrls.BASE_URL).create(WebServices.class);
        final Call<List<Pojo>> countriesCall = countriesService.getAllCountries();
        countriesCall.enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, final Response<List<Pojo>> response) {

                list = response.body();
                data.setValue(list);

            }

            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {

                Log.d("sssss", "==" + t.getMessage());

            }
        });

        return data;

    }
}
