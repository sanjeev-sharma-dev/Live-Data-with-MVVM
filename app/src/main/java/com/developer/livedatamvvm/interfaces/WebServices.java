package com.developer.livedatamvvm.interfaces;


import com.developer.livedatamvvm.pojos.Pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {

    @GET("rest/v2/all")
    Call<List<Pojo>> getAllCountries();

}
