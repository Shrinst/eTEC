package com.example.aguis.etecapp.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
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
import android.widget.Toast;

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
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

/**
 * Created by aguis on 28/5/2017.
 */

public class ElectronicApplianceFragment extends Fragment implements SearchView.OnQueryTextListener {

    ListView listView;
    CustomAdapter customAdapter;
    List<Product> productList;
    List<Product> filterList;

    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;

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

        View rootView = inflater.inflate(R.layout.electronicappliance_fragment, container, false);

        listView = (ListView) rootView.findViewById(R.id.elaListView);
        productList = new ArrayList<>();
        filterList = new ArrayList<>();
        customAdapter = new CustomAdapter(container.getContext());

        requestData("http://192.168.43.70:8080/e_tecserverI/webapi/productlist");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<Product> tempList;

                if (filterList.isEmpty()) {
                    tempList = (ArrayList<Product>) productList;
                } else {
                    tempList = (ArrayList<Product>) filterList;
                }

                Intent intent = new Intent(ElectronicApplianceFragment.this.getActivity(), InformationActivity.class);
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

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_voice:
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Diganos el producto que busca");
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            ArrayList<String> textMatchList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            final List<Product> filteredProductList = filter(productList, textMatchList.get(0));
            customAdapter.setFilter(filteredProductList);

            if (!textMatchList.isEmpty()) {
                if (textMatchList.get(0).contains("search")) {
                    String searchQuery = textMatchList.get(0).replace("search", " ");
                    Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
                    search.putExtra(SearchManager.QUERY, searchQuery);
                    startActivity(search);
                }
                else {
                    //  mlvTextMatches.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, textMatchList));
                }
            }
        }
        else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {
            showToastMessage("Audio Error");
        }
        else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
            showToastMessage("Client Error");
        }
        else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {
            showToastMessage("Network Error");
        }
        else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
            showToastMessage("No Match");
        }
        else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {
            showToastMessage("Server Error");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void showToastMessage(String message) {
        Toast.makeText(ElectronicApplianceFragment.this.getActivity(), message, Toast.LENGTH_LONG).show();
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

    public void doSearch(String newText) {
        final List<Product> filteredProductList = filter(productList, newText);
        customAdapter.setFilter(filteredProductList);
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

                    String category = jsonObject.getString("category");

                    if (category.equals("AparatosElectrónicos")) {
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
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            customAdapter.setProducts(productList);
            listView.setAdapter(customAdapter);
        }
    }
}
