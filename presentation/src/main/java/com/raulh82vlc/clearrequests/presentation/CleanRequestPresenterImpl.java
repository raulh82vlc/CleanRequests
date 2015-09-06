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

import com.raulh82vlc.clearrequests.domain.interactors.Character10thRequestInteractor;
import com.raulh82vlc.clearrequests.domain.interactors.Each10thCharacterRequestInteractor;
import com.raulh82vlc.clearrequests.domain.interactors.WordCounterRequestInteractor;
import com.raulh82vlc.clearrequests.domain.model.Character10;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class CleanRequestPresenterImpl implements CleanRequestPresenter {

    /**
     * Variables declaration
     */
    private View view;

    private Character10thRequestInteractor interactor10thChar;

    private Each10thCharacterRequestInteractor interactorEach10thChar;

    private WordCounterRequestInteractor interactorWordCounter;

    @Inject
    CleanRequestPresenterImpl(Character10thRequestInteractor interactor10thChar,
                              Each10thCharacterRequestInteractor interactorEach10thChar,
                              WordCounterRequestInteractor interactorWordCounter) {
        this.interactor10thChar = interactor10thChar;
        this.interactorEach10thChar = interactorEach10thChar;
        this.interactorWordCounter = interactorWordCounter;
    }

    @Override
    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("The view should be instantiated");
        }
        this.view = view;
    }

    @Override
    public void onCreate() {
        /**  HERE could be the method "launchAllCalls()"
         * if we want to have all in one step,
         * this has been indicated in different unit calls,
         * in order to be more readable */
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    /**
     * initialiseFirst10th
     * launcher of the private method launchChar10thInteractor
     **/
    public void initialiseFirst10th() {
        launchChar10thInteractor();
    }

    /**
     * initialiseEach10thChar
     * launcher of the private method launchEachChar10thInteractor
     **/
    public void initialiseEach10thChar() {
        launchEachChar10thInteractor();
    }

    /**
     * initialiseWordCount
     * launcher of the private method launchCounterOfWords
     **/
    public void initialiseWordCount() {
        launchCounterOfWords();
    }

    /**
     * launchAllCalls
     * launch every call
     **/
    public void launchAllCalls() {
        launchChar10thInteractor();
        launchEachChar10thInteractor();
        launchCounterOfWords();
    }

    /**
     * launchCounterOfWords
     * dispatches the interactorWordCounter
     **/
    private void launchCounterOfWords() {
        interactorWordCounter.execute(new WordCounterRequestInteractor.GetWordCountCallback() {
            @Override
            public void onGetWordCountCallbackOK(Map<String, Integer> character10th) {
                view.loadCountOfWords(character10th);
            }

            @Override
            public void onGetWordCountCallbackKO() {
                view.errorCountingWords();
            }
        });
    }

    /**
     * launchEachChar10thInteractor
     * dispatches the interactorEach10thChar
     **/
    private void launchEachChar10thInteractor() {
        interactorEach10thChar.execute(new Each10thCharacterRequestInteractor.GetEach10thCharacterCallback() {
            @Override
            public void onGetEach10thCharacterthOK(List<Character10> character10th) {
                String finalString = PresenterUtils.transformIntoReadable(character10th);
                view.loadEach10thChar(finalString);
            }

            @Override
            public void onGetEach10thCharacterKO() {
                view.errorGettingEach10thChar();
            }
        });
    }

    /**
     * launchChar10thInteractor
     * dispatches the interactor10thChar
     **/
    private void launchChar10thInteractor() {
        interactor10thChar.execute(new Character10thRequestInteractor.GetCharacter10thCallback() {
            @Override
            public void onGetCharacter10thOK(Character10 character10th) {
                view.loadCharacter10th(character10th.getCharacter());
            }

            @Override
            public void onGetCharacter10thKO() {
                view.errorGettingCharacter10th();
            }
        });
    }
}
