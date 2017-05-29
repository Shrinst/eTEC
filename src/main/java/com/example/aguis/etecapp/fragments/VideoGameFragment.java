package com.example.aguis.etecapp.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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

public class VideoGameFragment extends Fragment {

    ListView listView;
    List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.videogame_fragment, container, false);

        productList = new ArrayList<>();

        listView = (ListView) rootView.findViewById(R.id.vdgListView);
        //CustomAdapter customAdapter = new CustomAdapter(this.getActivity(), getComicReadPaper());

        //listView.setAdapter(customAdapter);

        requestData("http://192.168.43.70:8080/e_tecserverI/webapi/productlist");

        return rootView;
    }

    @Override
    public String toString() {
        String title = "Video Games";
        return title;
    }

    private void requestData(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private class MyTask extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected void onPreExecute() {
            // updateDisplay("Starting Task");
        }

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

                    if (category.equals("VideoJuegos")) {
                        productList.add(new Product(
                                jsonObject.getString("name"),
                                jsonObject.getString("imageURL"),
                                jsonObject.getInt("id"),
                                jsonObject.getInt("amount"),
                                jsonObject.getString("description"),
                                jsonObject.getString("category")
                        ));
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            CustomAdapter customAdapter = new CustomAdapter(VideoGameFragment.this.getActivity(), productList);
            listView.setAdapter(customAdapter);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //updateDisplay(values[0]);
        }
    }
}
