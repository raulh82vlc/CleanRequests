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


import java.util.Map;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public interface CleanRequestPresenter extends Presenter {

    void setView(View view);

    void initialiseFirst10th();

    void initialiseEach10thChar();

    void initialiseWordCount();

    interface View {
        void loadCharacter10th(String my10thChar);

        void errorGettingCharacter10th();

        void loadEach10thChar(String my10thChar);

        void errorGettingEach10thChar();

        void loadCountOfWords(Map<String, Integer> numberWords);

        void errorCountingWords();
    }
}
