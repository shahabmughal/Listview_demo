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
 * Last modified 11/10/17 1:12 PM
 */

package dev.shahab.shahab_bsef14a006.views.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dev.shahab.shahab_bsef14a006.R;
import dev.shahab.shahab_bsef14a006.data.model.UserModel;

public class CreateProfileActivity extends AppCompatActivity {

    UserModel user;
    ImageView imageview;
    Bitmap currentImage;

    static final int OPEN_GALRY = 1;
    static final int OPEN_CAMERA = 3;


    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        user = new UserModel();

        //ImageView image = findViewById(R.id.image);
        final TextView name = findViewById(R.id.name);
        final Spinner gender = findViewById(R.id.gender);
        final TextView phone = findViewById(R.id.phone);
        final TextView DOB = findViewById(R.id.dob);
        final TextView occup = findViewById(R.id.occupation);
        final Spinner status = findViewById(R.id.status);

        Button save = findViewById(R.id.save);
        Button cancel = findViewById(R.id.cancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setName(name.getText().toString());
                if (gender.getSelectedItemPosition() == 0) {
                    user.setGender("Male");
                } else {
                    user.setGender("Female");
                }
                user.setPhone(phone.getText().toString());
                user.setDob(DOB.getText().toString());
                user.setOccupation(occup.getText().toString());

                if (status.getSelectedItemPosition() == 0) {
                    user.setVarified(false);
                } else {
                    user.setVarified(true);
                }
                user.setImgPath(mCurrentPhotoPath);


                UserModel.userModels.add(user);

                Intent i = new Intent(CreateProfileActivity.this, ViewProfilesActivity.class);
                startActivity(i);

                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button getImage = findViewById(R.id.getImage);
        getImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera(view);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == OPEN_GALRY) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                mCurrentPhotoPath = uri.getPath();
            }

        } else if (requestCode == OPEN_CAMERA) {
        }
    }




    public void openCamera(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photoFile = null;
        try {
            photoFile = createImageFile();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
        if (photoFile != null) {
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
            startActivityForResult(takePictureIntent, OPEN_CAMERA);
        }

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }
}
