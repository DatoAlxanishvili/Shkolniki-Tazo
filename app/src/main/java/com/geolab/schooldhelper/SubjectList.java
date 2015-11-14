package com.geolab.schooldhelper;



import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.widget.ListView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.geolab.schooldhelper.Data.FormulaObj;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class SubjectList extends AppCompatActivity {
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
        Bundle bundle= getIntent().getExtras();
        String subSubjectName = getIntent().getStringExtra("subSubject");

        final Context ctx = this;
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        final ArrayList<FormulaObj> formulaObjs = new ArrayList<>();

        String lastUrl = "http://imerimpex.ge/school/index.php?table="+subSubjectName;

        JsonArrayRequest request;
        request = new JsonArrayRequest(lastUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                //assign parsed data the likesArrayList
                String descriptionL;
                String imageL;
                for (int i = 0; i < jsonArray.length(); ++i) {
                    JSONObject obj = null;
                    try {
                        obj = jsonArray.getJSONObject(i);
                        descriptionL = obj.getString("name");
                        imageL = obj.getString("pic");

                        FormulaObj productObjs1 = new FormulaObj(descriptionL,imageL);
                        formulaObjs.add(productObjs1);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                progress.dismiss();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        volleyError.getCause();
                    }
                });
        requestQueue.add(request);
        progress = ProgressDialog.show(ctx, "áƒ“áƒáƒ˜áƒªáƒáƒ“áƒ”áƒ—", "áƒ’áƒ—áƒ®áƒáƒ•áƒ— áƒ“áƒáƒ˜áƒªáƒáƒ“áƒáƒ—");
        ListAdapter listAdapter = null;
        ListView listview = (ListView) findViewById(R.id.formulaList);
        listAdapter = new ListAdapter(SubjectList.this,formulaObjs);
        listview.setAdapter(listAdapter);
    }





    }

