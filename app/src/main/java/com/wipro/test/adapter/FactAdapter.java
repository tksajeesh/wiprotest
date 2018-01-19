package com.wipro.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wipro.test.R;
import com.wipro.test.Utils;
import com.wipro.test.models.FactsModel;

import java.util.ArrayList;

/**
 * Created by Vishwajit on 19/01/18
 */

public class FactAdapter extends RecyclerView.Adapter<FactAdapter.ViewHolder> {

    ArrayList<FactsModel> facts;

    public FactAdapter(ArrayList<FactsModel> facts) {
        this.facts = facts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fact, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FactsModel fact = facts.get(position);
        holder.tvTitle.setText(fact.getTitle());
        holder.tvTitle.setVisibility(Utils.notEmptyOrNull(fact.getTitle()) ? View.VISIBLE : View.GONE);
        holder.tvDescription.setText(fact.getDescription());
        holder.tvDescription.setVisibility(Utils.notEmptyOrNull(fact.getDescription()) ? View.VISIBLE : View.GONE);

        if (Utils.notEmptyOrNull(fact.getImageUrl())) {
            holder.ivFactPic.setVisibility(View.VISIBLE);
            Picasso.with(holder.ivFactPic.getContext())
                    .load(fact.getImageUrl())
                    .fit()
                    .into(holder.ivFactPic);
        } else {
            holder.ivFactPic.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return facts != null ? facts.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        ImageView ivFactPic;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_fact_title);
            tvDescription = itemView.findViewById(R.id.tv_fact_description);
            ivFactPic = itemView.findViewById(R.id.iv_fact_image);
        }
    }
}
