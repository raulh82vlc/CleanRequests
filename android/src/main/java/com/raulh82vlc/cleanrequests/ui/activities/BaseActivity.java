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

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

// import butterknife.ButterKnife;

/**
 * This is extended by every activity, does the common
 * settings like common injections if required
 * <p/>
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public abstract class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        /** here could be view injections if required */
        // ButterKnife.inject(this);
    }
}
