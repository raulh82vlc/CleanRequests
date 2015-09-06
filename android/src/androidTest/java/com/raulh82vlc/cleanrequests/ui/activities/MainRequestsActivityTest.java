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

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import com.raulh82vlc.cleanrequests.R;

/**
 * Created by Raul Hernandez Lopez on 06/09/2015.
 */

public class MainRequestsActivityTest extends ActivityInstrumentationTestCase2<MainRequestsActivity> {

    private MainRequestsActivity mMainActivity;
    public MainRequestsActivityTest() {
        super(MainRequestsActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.setActivityIntent(createTargetIntent());
        mMainActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testContainsFragment() {
        Fragment requestsFrament =
                mMainActivity.getFragmentManager().findFragmentById(R.id.fragment_clean_requests);
        assertThat(requestsFrament, is(notNullValue()));
    }

    public void testContainsProperIntro() {
        onView(withId(R.id.count_words)).check(matches(withText("")));
        onView(withId(R.id.char_10)).check(matches(withText("")));
        onView(withId(R.id.each_char_10)).check(matches(withText("")));
    }

    private Intent createTargetIntent() {
        Intent intentLaunchActivity =
                getCallingIntent(getInstrumentation().getTargetContext());
        return intentLaunchActivity;
    }

    public Intent getCallingIntent(Context context) {
        return new Intent(context, MainRequestsActivity.class);
    }
}
