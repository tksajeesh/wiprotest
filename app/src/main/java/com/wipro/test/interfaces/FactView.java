package com.wipro.test.interfaces;

import com.wipro.test.models.FactsModel;

import java.util.ArrayList;

/**
 * This is interface will be implemented by the View i.e. the Activity in our case
 * for receiving the callbacks from presenter class.
 *
 * Created by Vishwajit on 19/01/18
 */

public interface FactView {

    void showTitle(String title);

    void loadRecyclerView(ArrayList<FactsModel> factsModel);

    void changeRefreshStatus(boolean showRefresh);

    void showError();
}
