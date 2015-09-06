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
package com.raulh82vlc.clearrequests.presentation;

import com.raulh82vlc.clearrequests.domain.model.Character10;

import java.util.List;

/**
 * PresenterUtils
 * Utils helper for the presenter
 * <p/>
 * Created by Raul Hernandez Lopez on 06/09/2015.
 */
public class PresenterUtils {
    /**
     * transformIntoReadable
     * is the algorithm to introduce each 10th char
     * into a string separated by ", " (comas and space)
     * This also takes care about do not introduce a ","
     * after the last char introduced.
     *
     * @param character10th is a list of Characrter10
     * @return thisIsFormatted final output string
     * @author Raul Hernandez Lopez
     **/
    protected static String transformIntoReadable(final List<Character10> character10th) {
        String thisIsFormatted = "";
        int size = character10th.size();
        for (int i = 0; i < size; i++) {
            thisIsFormatted += character10th.get(i).getCharacter();
            if (i != size - 1) {
                thisIsFormatted += ", ";
            }
        }
        return thisIsFormatted;
    }
}
