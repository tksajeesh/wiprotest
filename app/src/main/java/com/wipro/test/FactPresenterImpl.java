package com.wipro.test;

import com.wipro.test.ResponseSchema.FactResponseSchema;
import com.wipro.test.ResponseSchema.Row;
import com.wipro.test.interfaces.FactInteractor;
import com.wipro.test.interfaces.FactPresenter;
import com.wipro.test.interfaces.FactView;
import com.wipro.test.models.FactsModel;

import java.util.ArrayList;

/**
 * Created by Vishwajit on 19/01/18
 */

public class FactPresenterImpl implements FactPresenter, FactInteractor.FactListener {

    private FactView factView;
    private FactInteractor factInteractor;

    public FactPresenterImpl(FactView factView, FactInteractor factInteractor) {
        this.factView = factView;
        this.factInteractor = factInteractor;
        factInteractor.setFactListener(this);
    }

    @Override
    public void getFact() {
        factView.changeRefreshStatus(true);
        factInteractor.getFacts();
    }

    @Override
    public void onFactReceived(FactResponseSchema factResponseSchema) {
        factView.changeRefreshStatus(false);
        factView.showTitle(factResponseSchema.getTitle());

        if (Utils.notEmptyOrNull(factResponseSchema.getRows())) {
            ArrayList<FactsModel> factsModels = new ArrayList<>();
            for (Row row : factResponseSchema.getRows()) {
                FactsModel factsModel = new FactsModel();
                factsModel.setTitle(row.getTitle());
                factsModel.setDescription(row.getDescription());
                factsModel.setImageUrl(row.getImageHref());
                if (!factsModel.isEmpty())
                    factsModels.add(factsModel);
            }
            factView.loadRecyclerView(factsModels);
        }
    }

    @Override
    public void errorOccurred() {
        factView.changeRefreshStatus(false);
        factView.showError();
    }
}
