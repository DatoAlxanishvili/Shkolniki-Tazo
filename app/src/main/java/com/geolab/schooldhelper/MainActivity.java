package com.geolab.schooldhelper;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.geolab.schooldhelper.Data.SubjectData;

import lt.lemonlabs.android.expandablebuttonmenu.ExpandableButtonMenu;
import lt.lemonlabs.android.expandablebuttonmenu.ExpandableMenuOverlay;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar m_myActionBar= getSupportActionBar();

        if (m_myActionBar != null) {
            m_myActionBar.hide();
        }

        ExpandableMenuOverlay menuOverlay = (ExpandableMenuOverlay) findViewById(R.id.button_menu);
        menuOverlay.setOnMenuButtonClickListener(new ExpandableButtonMenu.OnMenuButtonClick() {
            Intent intent= null;
            public void onClick(ExpandableButtonMenu.MenuButton action) {
                switch (action) {
                    case MID:
                        intent= new Intent(MainActivity.this,MathSubjectActivity.class);
                        startActivity(intent);

                        break;
                    case LEFT:
                        intent= new Intent(MainActivity.this,SubjectList.class);
                        intent.putExtra("subSubject", "physics");
                        startActivity(intent);

                        break;
                    case RIGHT:
                        intent= new Intent(MainActivity.this,ChemSubjectActivity.class);
                        startActivity(intent);

                        break;
                }
            }
        });

    }

}
