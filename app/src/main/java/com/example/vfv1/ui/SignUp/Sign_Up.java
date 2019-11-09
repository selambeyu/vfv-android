package com.example.vfv1.ui.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.vfv1.R;
import com.example.vfv1.Students;

import android.widget.AdapterView.OnItemSelectedListener;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sign_Up extends AppCompatActivity implements OnItemSelectedListener{
    Button signup;
    TextView test_text;

    static final String REQ_TAG = "VACTIVITY";

    EditText username, email, password;
    String role;

//    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Spinner spinner = findViewById(R.id.spinner);


        signup = findViewById(R.id.signup);
        test_text = findViewById(R.id.test_text);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);



        final String post_url = "http://vfv.eu-4.evennode.com/api/users/register";

        List<String> roles = new ArrayList<String>();
        roles.add("student");
        roles.add("trainingcenter");
        roles.add("professional");

//        asdf asdf asdf asdfasdfasdfa asdfa asdf asdf asdf adsf

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, roles);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

                spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                role = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });



//         ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Sign_Up.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.users_array));
//         myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//         spinner.setAdapter(myAdapter);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Sign_Up.this, Students.class);
//                startActivity(intent);

                final String userName = username.getText().toString();
                final String emailAddress = email.getText().toString();
                final String userPassword = password.getText().toString();

                String url = post_url;
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        test_text.setText("Response : "+ response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        test_text.setText("Error : "+ error);
                    }
                }
                ){
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("username", userName);
                        params.put("password", userPassword);
                        params.put("email", emailAddress);
                        params.put("role", role);
                        return params;
                    };
                };
                stringRequest.setTag(REQ_TAG);
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });

    }



    private Response.Listener<String> getPostResponseListener(){
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                test_text.setText("String Response : "+ response);
            }
        };
    }

    private Response.ErrorListener getPostErrorListener(){
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                test_text.setText("Error getting response");
            }
        };
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        test_text.setText("String Response : "+ item);
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
