/*
 * Copyright (C) 2015 Raul Hernandez Lopez
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.raulh82vlc.clearrequests.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class Each10Char {

    private List<Character10> eachCharList;

    public Each10Char() {
        eachCharList = new ArrayList<>();
    }

    public List<Character10> getEachCharList() {
        return eachCharList;
    }

    public void setEachCharList(List<Character10> eachCharList) {
        this.eachCharList.clear();
        this.eachCharList.addAll(eachCharList);
    }
}