package com.example.aguis.etecapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aguis.etecapp.R;
import com.example.aguis.etecapp.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aguis on 28/5/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Product> products;
    int resource;
    LayoutInflater inflater;

    public CustomAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listmodel, parent, false);
        }

        Product product = (Product) getItem(position);

        TextView nameTxt = (TextView) convertView.findViewById(R.id.txtName);
        TextView priceTxt = (TextView) convertView.findViewById(R.id.txtPrice);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.coverPageImage);

        nameTxt.setText(product.getName());
        priceTxt.setText(product.getDescription());
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        //Picasso.with(context).load(product.getImageURL()).into(imageView);

        /*convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, name, Toast.LENGTH_LONG).show();
            }
        });*/

        return convertView;
    }
}
