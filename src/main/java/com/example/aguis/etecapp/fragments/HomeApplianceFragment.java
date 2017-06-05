package com.example.aguis.etecapp.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aguis.etecapp.InformationActivity;
import com.example.aguis.etecapp.R;
import com.example.aguis.etecapp.adapter.CustomAdapter;
import com.example.aguis.etecapp.http.HttpManager;
import com.example.aguis.etecapp.http.RequestPackage;
import com.example.aguis.etecapp.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aguis on 28/5/2017.
 */

public class HomeApplianceFragment extends Fragment implements SearchView.OnQueryTextListener {

    ListView listView;
    CustomAdapter customAdapter;
    List<Product> productList;
    List<Product> filterList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.homeappliance_fragment, container, false);

        listView = (ListView) rootView.findViewById(R.id.hmaListView);
        productList = new ArrayList<>();
        filterList = new ArrayList<>();
        customAdapter = new CustomAdapter(container.getContext());

        requestData("http://192.168.43.70:8080/e_tecserverI/webapi/productlist?category=Electrodomesticos");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<Product> tempList;

                if (filterList.isEmpty()) {
                    tempList = (ArrayList<Product>) productList;
                } else {
                    tempList = (ArrayList<Product>) filterList;
                }

                Intent intent = new Intent(HomeApplianceFragment.this.getActivity(), InformationActivity.class);
                intent.putExtra("product", tempList.get(position));
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        customAdapter.setFilter(productList);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
    }


    private void requestData(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Product> filteredProductList = filter(productList, newText);
        customAdapter.setFilter(filteredProductList);
        return true;
    }

    private List<Product> filter(List<Product> products, String query) {
        query = query.toLowerCase();

        final List<Product> filteredProductList = new ArrayList<>();
        for (Product product : products) {
            final String text = product.getName().toLowerCase();
            if (text.contains(query)) {
                filteredProductList.add(product);
            }
        }
        filterList = filteredProductList;
        return filteredProductList;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
                            jsonObject.getString("description"),
                            jsonObject.getString("category")
                    ));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            customAdapter.setProducts(productList);
            listView.setAdapter(customAdapter);
        }
    }
}
