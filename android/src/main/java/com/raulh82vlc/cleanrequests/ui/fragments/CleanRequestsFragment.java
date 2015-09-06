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
package com.raulh82vlc.cleanrequests.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.raulh82vlc.cleanrequests.R;
import com.raulh82vlc.cleanrequests.ui.activities.MainRequestsActivity;
import com.raulh82vlc.clearrequests.presentation.CleanRequestPresenter;

import java.util.Map;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * CleanRequestsFragment injects all required stuff
 * first of all when the activity is created the component,
 * as well as presenter and view injections for each UI element
 *
 * @author Raul Hernandez Lopez
 */
public class CleanRequestsFragment extends BaseFragment implements CleanRequestPresenter.View {

    @Inject
    CleanRequestPresenter presenter;
    @InjectView(R.id.char_10)
    TextView tvFirst10;
    @InjectView(R.id.count_words)
    TextView tvCounter;
    @InjectView(R.id.line1)
    View line1;
    @InjectView(R.id.line2)
    View line2;
    @InjectView(R.id.selectable_word)
    EditText etSelectableWord;
    @InjectView(R.id.click_filter_other)
    Button btnFilter;
    @InjectView(R.id.each_char_10)
    TextView tvEachFirst;
    private String SEARCH_WORD = "truecaller";
    private Map<String, Integer> myCountedWord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clean_requests, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainRequestsActivity) getActivity()).component().inject(this);
        presenter.setView(this);
    }

    @OnClick(R.id.click_requests)
    public void OnClickSendRequests() {
        if (isThereInternetConnection(getActivity())) {
            setInitialFirst10thChar();
            setEach10thChar();
            setWordCount();
        } else {
            Toast.makeText(getActivity(), getString(R.string.error_internet), Toast.LENGTH_SHORT).show();
            tvFirst10.setText(getString(R.string.undefined_answer));
            tvCounter.setText(getString(R.string.undefined_answer));
            tvEachFirst.setText(getString(R.string.undefined_answer));
        }
        line1.setVisibility(View.VISIBLE);
        line2.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.click_filter_other)
    public void OnClickFilter() {
        filterResults();
    }

    /**
     * setWordCount method sets the initial field text
     * for the word count
     * and initialises the presenter to retrieve the info
     **/
    private void setWordCount() {
        tvCounter.setText(getString(R.string.loading_word_count));
        presenter.initialiseEach10thChar();
    }

    /**
     * setEach10thChar method sets the initial field text
     * for each 10th character
     * and initialises the presenter to retrieve the info
     **/
    private void setEach10thChar() {
        tvEachFirst.setText(getText(R.string.loading_each10thchar));
        presenter.initialiseWordCount();
    }

    /**
     * setInitialFirst10thChar method sets the initial field text
     * for tge first 10th character
     * and initialises the presenter to retrieve the info
     **/
    private void setInitialFirst10thChar() {
        tvFirst10.setText(getText(R.string.loading_first10th));
        presenter.initialiseFirst10th();
    }

    @Override
    public void loadCharacter10th(String my10thChar) {
        tvFirst10.setText(getText(R.string.intro_first_char) + " " + my10thChar);
    }

    @Override
    public void errorGettingCharacter10th() {
        tvFirst10.setText(getText(R.string.error_first10th));
    }

    @Override
    public void loadEach10thChar(String each10thChar) {
        tvEachFirst.setText(getText(R.string.load_each_10th_char) + " " + each10thChar);
    }

    @Override
    public void errorGettingEach10thChar() {
        tvEachFirst.setText(getText(R.string.error_each10thchar));
    }

    @Override
    public void loadCountOfWords(Map<String, Integer> numberCounted) {
        myCountedWord = numberCounted;
        setWordCounted();
    }

    /**
     * filterResults method sets search word
     * for the one that the user decided
     * and makes visible the result from the
     * actual cached results
     **/
    private void filterResults() {
        SEARCH_WORD = etSelectableWord.getText().toString();
        setWordCounted();
    }

    /**
     * setWordCounted
     * uses the stored search_word
     * and then makes visible whatever
     * is needed
     **/
    private void setWordCounted() {
        String toShow = "";
        if (myCountedWord != null) {
            Integer numberApparences = myCountedWord.get(SEARCH_WORD);
            if (numberApparences != null) {
                toShow = getText(R.string.count_word_loaded)
                        + SEARCH_WORD
                        + " (" + numberApparences + ")";
                etSelectableWord.setText(SEARCH_WORD);
                etSelectableWord.setSelection(SEARCH_WORD.length());
            } else {
                toShow = setErrorIfNoWordFound();
            }
        } else {
            toShow = setErrorIfNoWordFound();
        }
        etSelectableWord.setVisibility(View.VISIBLE);
        btnFilter.setVisibility(View.VISIBLE);
        tvCounter.setText(toShow);
    }

    /**
     * setErrorIfNoWordFound
     * shows to the user that there are no occurrences
     **/
    @NonNull
    private String setErrorIfNoWordFound() {
        return getText(R.string.no_occurrences) + " " + SEARCH_WORD;
    }

    @Override
    public void errorCountingWords() {
        tvCounter.setText(getText(R.string.error_word_count));
        etSelectableWord.setVisibility(View.GONE);
        btnFilter.setVisibility(View.GONE);
    }
}
