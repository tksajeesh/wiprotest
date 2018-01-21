package com.wipro.test;

import com.wipro.test.ResponseSchema.FactResponseSchema;
import com.wipro.test.api.ApiRequest;
import com.wipro.test.interfaces.FactInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vishwajit on 19/01/18
 */

public class FactInteractorImpl implements FactInteractor {

    private FactInteractor.FactListener factListener;

    @Override
    public void setFactListener(FactListener factListener) {
        this.factListener = factListener;
    }

    /**
     * Makes the api call to get facts
     */
    @Override
    public void getFacts() {
        ApiRequest.getInstance().getFacts(new Callback<FactResponseSchema>() {
            @Override
            public void onResponse(Call<FactResponseSchema> call, Response<FactResponseSchema> response) {
                call.request();
                factListener.onFactReceived(response.body());
            }

            @Override
            public void onFailure(Call<FactResponseSchema> call, Throwable t) {
                factListener.errorOccurred();
            }
        });
    }
}
