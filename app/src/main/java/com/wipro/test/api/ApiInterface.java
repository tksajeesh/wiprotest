package com.wipro.test.api;

import com.wipro.test.responseschema.FactResponseSchema;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * The Api is declared in this interfaced
 *
 * Created by Vishwajit on 20/01/18
 */

interface ApiInterface {
    @GET("s/2iodh4vg0eortkl/facts.json")
    Call<FactResponseSchema> getFact();
}
