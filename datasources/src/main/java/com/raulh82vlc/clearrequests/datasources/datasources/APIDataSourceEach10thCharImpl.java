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

import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceEach10thChar;
import com.raulh82vlc.clearrequests.datasources.api.WebServicesApiCalls;
import com.raulh82vlc.clearrequests.datasources.datasources.mapper.DataSourceMapper;
import com.raulh82vlc.clearrequests.domain.model.Each10Char;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class APIDataSourceEach10thCharImpl implements APIDataSourceEach10thChar {
    private DataSourceMapper dataSourceMapper;
    private Each10Char mCharacter10;
    private WebServicesApiCalls mWebServicesApiCalls;

    @Inject
    APIDataSourceEach10thCharImpl(DataSourceMapper dataSourceMapper) {
        mWebServicesApiCalls = new WebServicesApiCalls();
        startRequest();
        this.dataSourceMapper = dataSourceMapper;
    }

    @Override
    public void startRequest() {
        if (mCharacter10 == null) {
            mWebServicesApiCalls.getInfo(new Callback<Response>() {
                @Override
                public void success(Response result, Response response) {
                    String tempInfo = DataSourceUtils.parseBodyResponse(result);
                    Each10Char tempChar10 = null;
                    // parsing functionality
                    if (tempInfo != null && !tempInfo.isEmpty()) {
                        tempChar10 = (Each10Char) dataSourceMapper.mapFromSourceToModel(tempInfo);
                    }
                    if (tempChar10 != null && tempChar10.getEachCharList() != null) {
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
    public Each10Char getEach10thChar() {
        return mCharacter10;
    }
}
