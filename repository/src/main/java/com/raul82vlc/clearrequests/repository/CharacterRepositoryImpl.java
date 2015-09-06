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
package com.raul82vlc.clearrequests.repository;

import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceChar;
import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceEach10thChar;
import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceWordCounter;
import com.raulh82vlc.clearrequests.domain.model.Character10;
import com.raulh82vlc.clearrequests.domain.model.Each10Char;
import com.raulh82vlc.clearrequests.domain.repository.CharacterRepository;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class CharacterRepositoryImpl implements CharacterRepository {

    private APIDataSourceChar dataSource;

    private APIDataSourceEach10thChar dataSourceEach;

    private APIDataSourceWordCounter dataSourceWordCounter;

    @Inject
    CharacterRepositoryImpl(APIDataSourceChar dataSource,
                            APIDataSourceEach10thChar dataSourceEach,
                            APIDataSourceWordCounter dataSourceWordCounter) {
        this.dataSource = dataSource;
        this.dataSourceEach = dataSourceEach;
        this.dataSourceWordCounter = dataSourceWordCounter;

    }

    @Override
    public Character10 get10thCharacter() {
        return dataSource.getCharacter10();
    }

    @Override
    public Each10Char getEach10thCharacter() {
        return dataSourceEach.getEach10thChar();
    }

    @Override
    public Map<String, Integer> getWordCount() {
        return dataSourceWordCounter.getWordsCount();
    }
}
