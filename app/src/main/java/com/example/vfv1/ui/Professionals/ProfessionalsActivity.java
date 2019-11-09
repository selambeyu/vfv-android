package com.example.vfv1.ui.Professionals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.vfv1.R;

import com.example.vfv1.adapters.ArticleAdapter;
import com.example.vfv1.data.model.Article;
import com.example.vfv1.ui.training.CenterFragment;
import com.example.vfv1.ui.training.ProfessionalFragment;
import com.example.vfv1.utils.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Article> articleList;
    private RecyclerView.Adapter adapter;

    final String article_url = "http://vfv.eu-4.evennode.com/api/users/professional/viewArticle";

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionals);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mList = findViewById(R.id.articles_view);

        articleList = new ArrayList<>();
        adapter = new ArticleAdapter(getApplicationContext(), articleList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);


        getData();

//        viewPager = findViewById(R.id.view_pager);
//        setupViewPager(viewPager);

//        tabLayout = findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
    }


    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(article_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Article article = new Article();
                        article.setTitle(jsonObject.getString("title"));
                        article.setContent(jsonObject.getString("content"));
                        article.setAuthor(jsonObject.getString("author"));

                        articleList.add(article);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //TODO: STRINGS HAVE TO BE CHANGED FROM THE RESOURCE VALUE FOLDER - STRING
//        adapter.addFragment(new CareerPaths(), "Articles");
//        adapter.addFragment(new CenterFragment(), "Questions");
//        adapter.addFragment(new ProfessionalFragment(), "Biography");

//        viewPager.setAdapter(adapter);

    }
}
