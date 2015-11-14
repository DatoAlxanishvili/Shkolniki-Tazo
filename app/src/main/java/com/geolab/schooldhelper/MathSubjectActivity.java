package com.geolab.schooldhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dalkh on 14-Nov-15.
 */
public class MathSubjectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_subject_math);
        android.support.v7.app.ActionBar m_myActionBar= getSupportActionBar();

        if (m_myActionBar != null) {
            m_myActionBar.hide();
        }


    }

    public void sendName(String st)
    { Intent intent = new Intent(MathSubjectActivity.this,SubjectList.class);
        intent.putExtra("subSubject", st);
        startActivity(intent);
        this.finish();
    }
    public void onClick(View v) {
        String subjectName = "";
        switch (v.getId()) {
            case R.id.algebra:
                subjectName = "math";
                sendName(subjectName);
                break;

            case R.id.geometry:
                subjectName = "math";
                sendName(subjectName);
                break;




        }
    }
}
