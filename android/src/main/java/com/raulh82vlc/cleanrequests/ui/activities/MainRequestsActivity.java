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
package com.raulh82vlc.cleanrequests.ui.activities;

import android.os.Bundle;

import com.raulh82vlc.cleanrequests.CleanRequestsApp;
import com.raulh82vlc.cleanrequests.R;
import com.raulh82vlc.cleanrequests.di.components.DaggerRequestsComponent;
import com.raulh82vlc.cleanrequests.di.components.RequestsComponent;
import com.raulh82vlc.cleanrequests.di.modules.ActivityModule;

/**
 * MainRequestActivity gets the main component used
 * for its activity with the corresponding modules
 * (for the main activity just the activity module is required)
 *
 * @author Raul Hernandez Lopez
 */
public class MainRequestsActivity extends BaseActivity {

    private RequestsComponent requestsComponent;

    public RequestsComponent component() {
        if (requestsComponent == null) {
            requestsComponent = DaggerRequestsComponent.builder()
                    .applicationComponent(((CleanRequestsApp) getApplication()).component())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return requestsComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_requests);
    }
}
