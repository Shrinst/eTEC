package com.example.aguis.etecapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aguis.etecapp.R;
import com.example.aguis.etecapp.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aguis on 4/6/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<Product> mProductModel;
    private List<Product> mOriginalProductModel;
    private Context context;
    private ItemViewHolder viewHolder;

    public RVAdapter(List<Product> mProductModel, Context context) {

        this.mProductModel = mProductModel;
        this.mOriginalProductModel = mProductModel;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listmodel, parent, false);
        this.context = parent.getContext();
        viewHolder = new ItemViewHolder(view, context, (ArrayList<Product>) mProductModel);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final Product model = mProductModel.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return mProductModel.size();
    }

    public void setFilter(List<Product> productModels){
        mProductModel = new ArrayList<>();
        mProductModel.addAll(productModels);
        notifyDataSetChanged();
    }
}
