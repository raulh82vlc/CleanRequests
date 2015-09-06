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
package com.raulh82vlc.clearrequests.domain.repository;

import com.raulh82vlc.clearrequests.domain.model.Character10;
import com.raulh82vlc.clearrequests.domain.model.Each10Char;

import java.util.Map;

/**
 * Repository contract
 * <p/>
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public interface CharacterRepository {

    /**
     * to get the {@link Character10}
     **/
    Character10 get10thCharacter();

    /**
     * to get each 10th from an object
     * which contains a list of {@link Character10}
     **/
    Each10Char getEach10thCharacter();

    /**
     * to get the dictionary of words
     * with its counted number
     **/
    Map<String, Integer> getWordCount();
}
