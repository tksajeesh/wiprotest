package com.wipro.test.interfaces;

import com.wipro.test.ResponseSchema.FactResponseSchema;

/**
 * Created by Vishwajit on 19/01/18
 */

public interface FactInteractor {

    void getFacts();


    public interface FactListener{
        void onFactReceived(FactResponseSchema factResponseSchema);
    }
}
