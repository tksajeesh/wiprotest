package com.wipro.test.interfaces;

import com.wipro.test.responseschema.FactResponseSchema;

/**
 * This is an interactor interface the class which will implement this interface
 * will be doing all the network operations
 *
 * Created by Vishwajit on 19/01/18
 */

public interface FactInteractor {

    void getFacts();

    void setFactListener(FactListener factListener);


    /**
     * This Listener will be implemented by the Presenter to receive the updates from interactor.
     */
    interface FactListener {
        void onFactReceived(FactResponseSchema factResponseSchema);

        void errorOccurred();
    }
}
