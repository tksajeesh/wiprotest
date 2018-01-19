package com.wipro.test;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wipro.test.adapter.FactAdapter;
import com.wipro.test.interfaces.FactPresenter;
import com.wipro.test.interfaces.FactView;
import com.wipro.test.models.FactsModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FactView {

    private RecyclerView rvFacts;
    private SwipeRefreshLayout srlRefresh;
    private FactAdapter adapter;
    private ArrayList<FactsModel> factsModels;
    private FactPresenter factPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    /**
     * This will initialize the views
     */
    private void initViews() {

        rvFacts = findViewById(R.id.rv_facts);
        factsModels = new ArrayList<>();
        adapter = new FactAdapter(factsModels);
        rvFacts.setLayoutManager(new LinearLayoutManager(this));
        rvFacts.setAdapter(adapter);

        srlRefresh = findViewById(R.id.srl_refresh);

        factPresenter = new FactPresenterImpl(this, new FactInteractorImpl());
        factPresenter.getFact();

        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                factPresenter.getFact();
            }
        });
    }

    @Override
    public void showTitle(String title) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(title);
    }

    @Override
    public void loadRecyclerView(ArrayList<FactsModel> factsModel) {
        factsModels.clear();
        factsModels.addAll(factsModel);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void changeRefreshStatus(boolean showRefresh) {
        srlRefresh.setRefreshing(showRefresh);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error while fetching facts", Toast.LENGTH_LONG).show();
    }
}
