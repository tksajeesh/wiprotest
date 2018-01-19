package com.wipro.test.interfaces;

import com.wipro.test.models.FactsModel;

import java.util.ArrayList;

/**
 * Created by Vishwajit on 19/01/18
 */

public interface FactView {

    void showTitle(String title);

    void loadRecyclerView(ArrayList<FactsModel> factsModel);
}
