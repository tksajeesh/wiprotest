package com.wipro.test.api;

import com.wipro.test.ResponseSchema.FactResponseSchema;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vishwajit on 20/01/18
 */

interface ApiInterface {
    @GET("s/2iodh4vg0eortkl/facts.json")
    Call<FactResponseSchema> getFact();
}
