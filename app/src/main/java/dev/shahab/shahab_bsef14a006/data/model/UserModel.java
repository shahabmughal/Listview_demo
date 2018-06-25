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
 * Last modified 11/10/17 1:11 PM
 */

package dev.shahab.shahab_bsef14a006.data.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by shahab on 11/10/2017.
 */

public class UserModel {


    private String name;
    private String gender;
    private String dob;
    private String phone;
    private String occupation;
    private boolean isVarified;
    private String imgPath;

    public static ArrayList<UserModel> userModels = new ArrayList<>();
    static {
        userModels.add( new UserModel("Shahab", "Male", "10-10-1996", "923048637748", "Student", false, ""));
        userModels.add(new UserModel("Hamza", "Male", "09-09-1996", "925798345345", "Student", false, ""));

    }

    public UserModel(){

    }

    public UserModel(String name, String gender, String dob, String phone, String occupation, boolean isVarified, String imgPath) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.occupation = occupation;
        this.isVarified = isVarified;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean isVarified() {
        return isVarified;
    }

    public void setVarified(boolean varified) {
        isVarified = varified;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
