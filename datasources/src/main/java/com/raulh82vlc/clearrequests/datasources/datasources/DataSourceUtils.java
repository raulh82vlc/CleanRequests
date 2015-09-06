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
package com.raulh82vlc.clearrequests.datasources.datasources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import retrofit.client.Response;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class DataSourceUtils {
    /**
     * Constant
     */
    public final static int ITERATION_BTW_CHARS = 10;

    /**
     * parseBodyResponse
     * Helper to parse the raw datasource responses
     * from the Web plain content to String
     *
     * @param response Retrofit client response
     * @return string which gives the plain response in a simple way
     **/
    protected static String parseBodyResponse(Response response) {
        /** Vars declaration and initialisation */
        BufferedReader bufferedReader;
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(response.getBody().in()));
            try {
                /** Try to get response body */
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * splitDistributeByWordCountHowManyTimes
     * This algorithm does the search for each
     * space /feedline and so on and splits
     * each token, then the algorithm is looping
     * for each token and introducing this in a dictionary
     * of terms, and counting if repeated, otherwise introducing 1
     * when there is first time for a word
     * no null values for the keys
     * are allowed into the dictionary
     *
     * @param webContent String from the content of the website
     * @return dictionaryCounter Map data structure
     * @author Raul Hernandez Lopez
     **/
    protected static Map<String, Integer> splitDistributeByWordCountHowManyTimes(String webContent) {
        String[] words = webContent.split("\\W+");
        Map<String, Integer> dictionaryCounter = new HashMap<>();
        for (String word : words) {
            Integer frequency = dictionaryCounter.get(word);
            dictionaryCounter.put(word.toLowerCase(), (frequency != null) ? frequency + 1 : 1);
        }
        return dictionaryCounter;
    }
}
