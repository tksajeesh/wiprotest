package com.wipro.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wipro.test.interfaces.FactView;
import com.wipro.test.models.FactsModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FactView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showTitle(String title) {

    }

    @Override
    public void loadRecyclerView(ArrayList<FactsModel> factsModel) {

    }
}
