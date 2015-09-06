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

package com.raulh82vlc.clearrequests.datasources.api;


import retrofit.Callback;
import retrofit.client.Response;

/**
 * Declared calls with params
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */

public class WebServicesApiCalls {

    private ApiInterface mApiInterface;

    public WebServicesApiCalls() {
        mApiInterface = new WebServicesController().getInterface();
    }

    /**
     * This was defined in the Interface
     * getInfo
     * @param callback callback with the response of the web service
     */
    public void getInfo(Callback<Response> callback) {
        mApiInterface.getContent(callback);
    }
}
