package com.example.aguis.etecapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aguis.etecapp.http.HttpManager;
import com.example.aguis.etecapp.http.RequestPackage;
import com.example.aguis.etecapp.model.Product;
import com.facebook.Profile;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBuy;
    ImageView productImage;
    TextView tvName, tvPrice, tvDescription, tvCategory, tvAmount, tvId;
    Product product;

    Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        profile = Profile.getCurrentProfile();

        Bundle extras = getIntent().getExtras();

        product = extras.getParcelable("product");

        btnBuy = (Button) findViewById(R.id.btnBuy);
        btnBuy.setOnClickListener(this);
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
        tvId.append(" " + product.getId());
        tvAmount.append(" " + product.getAmount());
        tvPrice.append(" " + product.getPrice());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBuy:
                requestDataPost("http://192.168.43.70:8080/e_tecserverI/webapi/cartlist/" + profile.getFirstName());
                requestDataDelete("http://192.168.43.70:8080/e_tecserverI/webapi/productlist/" + product.getId());
                Intent intentMain = new Intent(InformationActivity.this, MainActivity.class);
                startActivity(intentMain);
                break;
        }
    }

    private void requestDataPost(String uri) {

        String[] attributes = { "amount", "category", "description", "id", "imageURL", "name", "price" };
        String[] values = { String.valueOf(product.getAmount()), product.getCategory(), product.getDescription(),
                String.valueOf(product.getId()), product.getImageURL(), product.getName(), String.valueOf(product.getPrice()) };

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("POST");
        requestPackage.setUri(uri);
        requestPackage.setMessageAttributes(attributes);
        requestPackage.setMessageValues(values);

        MyTask task = new MyTask();
        //task.execute(requestPackage);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private void requestDataDelete(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("DELETE");
        requestPackage.setUri(uri);

        MyTaskD task = new MyTaskD();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private class MyTask extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected String doInBackground(RequestPackage... params) {

            String content = null;

            switch (params[0].getMethod()) {
                case "DELETE":
                    content = HttpManager.deleteData(params[0]);
                    break;

                case "POST":
                    content = HttpManager.postData(params[0]);
                    break;
            }

            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(InformationActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

    private class MyTaskD extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected String doInBackground(RequestPackage... params) {

            String content = null;

            switch (params[0].getMethod()) {
                case "DELETE":
                    content = HttpManager.deleteData(params[0]);
                    break;
            }

            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(InformationActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }
        }
    }
}
