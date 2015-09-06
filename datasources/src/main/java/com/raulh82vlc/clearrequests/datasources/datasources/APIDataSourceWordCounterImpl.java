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

import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceWordCounter;
import com.raulh82vlc.clearrequests.datasources.api.WebServicesApiCalls;

import java.util.Map;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class APIDataSourceWordCounterImpl implements APIDataSourceWordCounter {
    private Map<String, Integer> mDictionaryCounter;
    private WebServicesApiCalls mWebServicesApiCalls;

    @Inject
    APIDataSourceWordCounterImpl() {
        mWebServicesApiCalls = new WebServicesApiCalls();
        startRequest();
    }

    @Override
    public void startRequest() {
        if (mDictionaryCounter == null) {
            mWebServicesApiCalls.getInfo(new Callback<Response>() {
                @Override
                public void success(Response result, Response response) {
                    String tempInfo = DataSourceUtils.parseBodyResponse(result);
                    // parsing functionality
                    if (tempInfo != null && !tempInfo.isEmpty()) {
                        mDictionaryCounter = DataSourceUtils.splitDistributeByWordCountHowManyTimes(tempInfo);
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    error.getStackTrace();
                }
            });
        }
    }

    @Override
    public Map<String, Integer> getWordsCount() {
        return mDictionaryCounter;
    }
}
