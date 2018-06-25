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
 * Last modified 11/10/17 2:38 PM
 */

package dev.shahab.shahab_bsef14a006.views.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import dev.shahab.shahab_bsef14a006.R;
import dev.shahab.shahab_bsef14a006.data.model.UserModel;

public class ProfileDetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);

        int id = getIntent().getExtras().getInt("id");

        UserModel user = UserModel.userModels.get(id);

        ImageView image = findViewById(R.id.image);
        TextView name = findViewById(R.id.name);
        TextView gender = findViewById(R.id.gender);
        TextView dob = findViewById(R.id.dob);
        TextView phone = findViewById(R.id.phone);
        TextView occup = findViewById(R.id.occupation);
        TextView status = findViewById(R.id.status);

        image.setImageURI(Uri.parse(user.getImgPath()));
        name.setText(user.getName());
        gender.setText(user.getGender());
        phone.setText(user.getPhone());
        occup.setText(user.getOccupation());
        dob.setText(user.getDob());
        if(user.isVarified()){
            status.setText("YES");
        }else{
            status.setText("NO");
        }

    }
}
