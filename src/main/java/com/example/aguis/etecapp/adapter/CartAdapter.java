package com.example.aguis.etecapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aguis.etecapp.R;
import com.example.aguis.etecapp.model.Product;

import java.util.List;

/**
 * Created by aguis on 9/6/2017.
 */

public class CartAdapter extends BaseAdapter {

    private Context context;
    private List<Product> productList;

    public CartAdapter(Context context) {
        this.context = context;
    }

    public CartAdapter(Context context, List<Product> objects) {
        this.context = context;
        this.productList = objects;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cartmodel, parent, false);

        Product product =  productList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.tvCartItems);

        tv.append("Nombre: " + product.getName() + "\n");
        tv.append("ID: " + product.getId() + "" + "\n");
        tv.append("Precio: " + "$" + product.getPrice() + "\n");

        return view;
    }

    public void setProducts(List<Product> products) {
        this.productList = products;
    }
}
