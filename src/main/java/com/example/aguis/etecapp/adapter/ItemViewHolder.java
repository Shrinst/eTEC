package com.example.aguis.etecapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aguis.etecapp.InformationActivity;
import com.example.aguis.etecapp.R;
import com.example.aguis.etecapp.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by aguis on 4/6/2017.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private  ArrayList<Product> products;
    public final TextView name_TextView;
    public final TextView price_TextView;
    public final ImageView imageView;
    public final Context context;

    public ItemViewHolder(View itemView, Context context, ArrayList<Product> products) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setClickable(true);
        name_TextView = (TextView) itemView.findViewById(R.id.txtName);
        price_TextView = (TextView) itemView.findViewById(R.id.txtPrice);
        imageView = (ImageView) itemView.findViewById(R.id.coverPageImage);
        this.context = context;
        this.products = products;
    }

    public void bind(Product product) {
        name_TextView.setText(product.getName());
        price_TextView.setText(product.getDescription());
        Picasso.with(context).load(product.getImageURL()).into(imageView);
    }

    @Override
    public void onClick(View v) {
        int position = getLayoutPosition();

        Product product = this.products.get(position);
        Intent intent = new Intent(context, InformationActivity.class);
        intent.putExtra("product", product);
        context.startActivity(intent);
        Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
