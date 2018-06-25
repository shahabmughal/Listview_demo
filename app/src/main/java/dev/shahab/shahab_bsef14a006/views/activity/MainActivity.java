/*
 * Created by shahab (BSEF14A006) on 11/10/17 2:39 PM. All rights reserved.
 *
 * Copyright (c) 2017 shahab
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 11/10/17 11:38 AM
 */

package dev.shahab.shahab_bsef14a006.views.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import dev.shahab.shahab_bsef14a006.R;

public class MainActivity extends AppCompatActivity {

    private static final int CREATE_PROFILE = 0;
    private static final int PROFILES = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Dashboard");

        ListView list = (ListView) findViewById(R.id.dashboard_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == CREATE_PROFILE){
                    Intent i = new Intent(MainActivity.this, CreateProfileActivity.class);
                    startActivity(i);
                }else if(position == PROFILES){
                    Intent i = new Intent(MainActivity.this, ViewProfilesActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Please select one option!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


    }
}
