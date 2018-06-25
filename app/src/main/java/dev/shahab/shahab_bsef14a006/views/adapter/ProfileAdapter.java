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
 * Last modified 11/10/17 1:07 PM
 */

package dev.shahab.shahab_bsef14a006.views.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import dev.shahab.shahab_bsef14a006.R;
import dev.shahab.shahab_bsef14a006.data.model.UserModel;

/**
 * Created by shahab on 11/10/2017.
 */

public class ProfileAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<UserModel> userData;

    public ProfileAdapter(Context context, ArrayList<UserModel> userData){
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.userData = userData;
    }

    @Override
    public int getCount() {
        return userData.size();
    }

    @Override
    public Object getItem(int i) {
        return userData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view  = inflater.inflate(R.layout.adapter_profile_row,viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        UserModel user = userData.get(i);

        holder.name.setText(user.getName());
        holder.gender.setText(user.getGender());
        holder.occupation.setText(user.getOccupation());
        holder.image.setImageURI(Uri.parse(user.getImgPath()));

        return view;
    }

    public class ViewHolder{
        ImageView image;
        TextView name;
        TextView gender;
        TextView occupation;
        public ViewHolder(View view){
            image = (ImageView) view.findViewById(R.id.profile_image);
            name = (TextView) view.findViewById(R.id.profile_name);
            gender = (TextView) view.findViewById(R.id.profile_gender);
            occupation = (TextView) view.findViewById(R.id.profile_occu);

        }
    }

}
