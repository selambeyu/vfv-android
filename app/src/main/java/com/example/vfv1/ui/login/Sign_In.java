package com.example.vfv1.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.vfv1.ui.Professionals.ProfessionalsActivity;
import com.example.vfv1.ui.SignUp.Sign_Up;
import com.example.vfv1.ui.training.TrainingActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.HashMap;
import java.util.Map;

public class Sign_In extends AppCompatActivity {
    TextView test_text;
    EditText username, password;
    static final String REQ_TAG = "VACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);

        final ProgressDialog progressDialog = new ProgressDialog(this);

        Button btnsignin = findViewById(R.id.usignin);
        TextView register_txt = findViewById(R.id.sign_up);
        test_text = findViewById(R.id.test_text);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Students.class));
            }
        });

        final String post_url = "http://vfv.eu-4.evennode.com/api/users/login";

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Sign_Up.this, Students.class);
//                startActivity(intent);

                final String userName = username.getText().toString();
                final String userPassword = password.getText().toString();
                progressDialog.setMessage("signing in...");
                progressDialog.show();

                String url = post_url;
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String role = "";
                        try {
                            JSONObject obj = new JSONObject(response);
                            role = obj.getString("role");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if(role.equals("student") ){
                            Intent intent = new Intent(getApplicationContext(), Students.class);
                            startActivity(intent);
                        }else if(role.equals("professional")){
                            Intent intent = new Intent(getApplicationContext(), ProfessionalsActivity.class);
                            startActivity(intent);
                        }else if(role.equals("trainingcenter")){
                            Intent intent = new Intent(getApplicationContext(), TrainingActivity.class);
                            startActivity(intent);
                        }else {
                            test_text.setText(role);
                        }
                        progressDialog.dismiss();
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
                        return params;
                    };
                };
                stringRequest.setTag(REQ_TAG);

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });


//        handle register text click event.
        register_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Sign_Up.class));
            }
        });
    }
}
