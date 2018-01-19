package com.wipro.test;

import com.wipro.test.ResponseSchema.FactResponseSchema;
import com.wipro.test.interfaces.FactInteractor;
import com.wipro.test.interfaces.FactPresenter;

/**
 * Created by Vishwajit on 19/01/18
 */

public class FactPresenterImpl implements FactPresenter,FactInteractor.FactListener {
    @Override
    public void getFact() {

    }

    @Override
    public void onFactReceived(FactResponseSchema factResponseSchema) {

    }
}
