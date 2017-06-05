package com.example.aguis.etecapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aguis.etecapp.model.Product;
import com.squareup.picasso.Picasso;

public class InformationActivity extends AppCompatActivity {

    Button btnBuy;
    ImageView productImage;
    TextView tvName, tvPrice, tvDescription, tvCategory, tvAmount, tvId;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Bundle extras = getIntent().getExtras();

        product = extras.getParcelable("product");

        btnBuy = (Button) findViewById(R.id.btnBuy);
        productImage = (ImageView) findViewById(R.id.productImage);
        Picasso.with(this.getApplicationContext()).load(product.getImageURL()).into(productImage);
        setTextView();
        addText();
    }

    private void setTextView() {
        tvName = (TextView) findViewById(R.id.tvProductName);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvCategory = (TextView) findViewById(R.id.tvCategory);
        tvAmount = (TextView) findViewById(R.id.tvAmount);
        tvId = (TextView) findViewById(R.id.tvId);
    }

    private void addText() {
        tvName.append(" " + (product.getName().trim()));
        tvDescription.append( "" + product.getCategory());
        tvCategory.append(" " + product.getDescription());
        tvId.append(" " + product.getId() + "");
    }
}
