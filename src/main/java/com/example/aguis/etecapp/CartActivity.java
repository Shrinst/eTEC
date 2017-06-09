package com.example.aguis.etecapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aguis.etecapp.adapter.CartAdapter;
import com.example.aguis.etecapp.http.HttpManager;
import com.example.aguis.etecapp.http.RequestPackage;
import com.example.aguis.etecapp.model.Product;
import com.facebook.Profile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    List<Product> productList;
    private CartAdapter cartAdapter;
    private ListView listView;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        profile = Profile.getCurrentProfile();

        listView = (ListView) findViewById(R.id.lvCart);
        cartAdapter = new CartAdapter(this.getApplicationContext());
        productList = new ArrayList<>();

        requestData("http://192.168.43.70:8080/e_tecserverI/webapi/cartlist/" + profile.getFirstName());

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                openDialog(view, position);
                return false;
            }
        });
    }

    private void openDialog(View view, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.deleteCartItemTitle);
        builder.setMessage(R.string.deleteCartItemMessage);
        builder.setPositiveButton(R.string.deleteCartItemPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                requestDataPost("http://192.168.43.70:8080/e_tecserverI/webapi/productlist", position);
                requestDataDelete("http://192.168.43.70:8080/e_tecserverI/webapi/cartlist/" + profile.getFirstName(), position);
                Intent intent = new Intent(CartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);

        Dialog dialog = builder.create();
        dialog.show();
    }

    public void showPayMessage(View view) {
    }

    private void requestData(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private void requestDataPost(String uri, int position) {

        Product product = productList.get(position);

        String[] attributes = { "amount", "category", "description", "id", "imageURL", "name", "price" };
        String[] values = { String.valueOf(product.getAmount()), product.getCategory(), product.getDescription(),
                String.valueOf(product.getId()), product.getImageURL(), product.getName(), String.valueOf(product.getPrice()) };

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("POST");
        requestPackage.setUri(uri);
        requestPackage.setMessageAttributes(attributes);
        requestPackage.setMessageValues(values);

        MyTaskPost task = new MyTaskPost();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private void requestDataDelete(String uri, int position) {

        Product product = productList.get(position);
        //productList.remove(position);

        String[] attributes = { "amount", "category", "description", "id", "imageURL", "name", "price" };
        String[] values = { String.valueOf(product.getAmount()), product.getCategory(), product.getDescription(),
                String.valueOf(product.getId()), product.getImageURL(), product.getName(), String.valueOf(product.getPrice()) };

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("DELETE");
        requestPackage.setUri(uri);
        requestPackage.setMessageAttributes(attributes);
        requestPackage.setMessageValues(values);

        MyTaskDelete task = new MyTaskDelete();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private class MyTask extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected String doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);

            return content;
        }

        @Override
        protected void onPostExecute(String content) {

            try {
                JSONArray jsonArray = new JSONArray(content);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    productList.add(new Product(
                            jsonObject.getString("name"),
                            jsonObject.getString("imageURL"),
                            jsonObject.getInt("id"),
                            jsonObject.getInt("amount"),
                            jsonObject.getInt("price"),
                            jsonObject.getString("description"),
                            jsonObject.getString("category")
                    ));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            cartAdapter.setProducts(productList);
            listView.setAdapter(cartAdapter);
        }
    }

    private class MyTaskPost extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected String doInBackground(RequestPackage... params) {

            String content = null;

            switch (params[0].getMethod()) {
                case "POST":
                    content = HttpManager.postData(params[0]);
                    break;
            }
            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(CartActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

    private class MyTaskDelete extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected String doInBackground(RequestPackage... params) {

            String content = null;

            switch (params[0].getMethod()) {
                case "DELETE":
                    content = HttpManager.deleteDataJSON(params[0]);
                    break;
            }
            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(CartActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }
        }
    }
}
