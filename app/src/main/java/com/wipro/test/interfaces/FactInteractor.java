package com.wipro.test.interfaces;

import com.wipro.test.ResponseSchema.FactResponseSchema;

/**
 * Created by Vishwajit on 19/01/18
 */

public interface FactInteractor {

    void getFacts();

    void setFactListener(FactListener factListener);


    interface FactListener {
        void onFactReceived(FactResponseSchema factResponseSchema);

        void errorOccurred();
    }
}
