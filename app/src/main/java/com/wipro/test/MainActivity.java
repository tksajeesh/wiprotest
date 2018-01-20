package com.wipro.test;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
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
    private TextView tvNoData;
    private final String FACTS_LIST = "FACTS_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews(savedInstanceState);
    }

    /**
     * This will initialize the views
     * Checks if the factsModels is in savedInstanceState to handle the rotation properly.
     * initializes the adapter and adds it to the recycler view
     * initializes the presenter and interactor
     *
     * @param savedInstanceState
     */
    private void initViews(Bundle savedInstanceState) {


        if (savedInstanceState != null) {
            factsModels = savedInstanceState.getParcelableArrayList(FACTS_LIST);
        }
        if (factsModels == null) {
            factsModels = new ArrayList<>();
        }

        adapter = new FactAdapter(factsModels);
        rvFacts = findViewById(R.id.rv_facts);
        rvFacts.setLayoutManager(new LinearLayoutManager(this));
        rvFacts.setAdapter(adapter);

        srlRefresh = findViewById(R.id.srl_refresh);

        factPresenter = new FactPresenterImpl(this, new FactInteractorImpl());
        if (factsModels.isEmpty())
            checkConnectionAndGetFacts();

        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                checkConnectionAndGetFacts();
            }
        });

        tvNoData = findViewById(R.id.tv_no_data_found);

        showTitle("");
    }

    /**
     * This method will check if the internet is connected and only then will it call the api
     */
    private void checkConnectionAndGetFacts() {
        if (Utils.isNetworkAvailable(this))
            factPresenter.getFact();
        else
            Toast.makeText(this, "Please Check Your internet connection.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showTitle(String title) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(title);
    }

    @Override
    public void loadRecyclerView(ArrayList<FactsModel> factsModel) {
        if (Utils.notEmptyOrNull(factsModel)) {
            tvNoData.setVisibility(View.GONE);
            factsModels.clear();
            factsModels.addAll(factsModel);
            adapter.notifyDataSetChanged();
        } else {
            tvNoData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void changeRefreshStatus(boolean showRefresh) {
        srlRefresh.setRefreshing(showRefresh);
    }

    @Override
    public void showError() {
        tvNoData.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Error while fetching facts", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(FACTS_LIST, factsModels);
        super.onSaveInstanceState(outState);
    }
}
