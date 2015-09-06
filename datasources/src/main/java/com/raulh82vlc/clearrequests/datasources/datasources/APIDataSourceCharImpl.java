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

import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceChar;
import com.raulh82vlc.clearrequests.datasources.api.WebServicesApiCalls;
import com.raulh82vlc.clearrequests.domain.model.Character10;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class APIDataSourceCharImpl implements APIDataSourceChar {
    /**
     * Vars initialisation
     */
    private Character10 mCharacter10;
    private WebServicesApiCalls mWebServicesApiCalls;

    @Inject
    APIDataSourceCharImpl() {
        mWebServicesApiCalls = new WebServicesApiCalls();
        startRequest();
    }

    @Override
    public void startRequest() {
        if (mCharacter10 == null) {
            mWebServicesApiCalls.getInfo(new Callback<Response>() {
                @Override
                public void success(Response result, Response response) {
                    String tempInfo = DataSourceUtils.parseBodyResponse(result);
                    Character10 tempChar10 = null;
                    if (tempInfo != null && !tempInfo.isEmpty()) {
                        if (DataSourceUtils.ITERATION_BTW_CHARS < tempInfo.length()) {
                            /** this gets the character from the output string and returns it */
                            tempChar10 = new Character10(tempInfo.charAt(DataSourceUtils.ITERATION_BTW_CHARS));
                        }
                    }
                    if (tempChar10 != null && tempChar10.getCharacter() != null) {
                        mCharacter10 = tempChar10;
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
    public Character10 getCharacter10() {
        return mCharacter10;
    }
}
