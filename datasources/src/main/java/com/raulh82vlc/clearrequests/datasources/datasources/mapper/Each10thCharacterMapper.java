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
package com.raulh82vlc.clearrequests.datasources.datasources.mapper;

import com.raulh82vlc.clearrequests.datasources.datasources.DataSourceUtils;
import com.raulh82vlc.clearrequests.domain.model.Character10;
import com.raulh82vlc.clearrequests.domain.model.Each10Char;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class Each10thCharacterMapper implements DataSourceMapper<String, Each10Char> {

    @Inject
    Each10thCharacterMapper() {
    }

    @Override
    public Each10Char mapFromSourceToModel(String dataSourceEntity) {
        /** Vars declaration & initialisation */
        Each10Char char10clazz = new Each10Char();
        List<Character10> character10s = new ArrayList<>();
        int currentCharPos = DataSourceUtils.ITERATION_BTW_CHARS;
        char myChar;
        /** Algorithm iteration */
        while (currentCharPos < dataSourceEntity.length()) {
            myChar = dataSourceEntity.charAt(currentCharPos);
            character10s.add(new Character10("" + myChar));
            currentCharPos += DataSourceUtils.ITERATION_BTW_CHARS;
        }
        /** Final Data Structure initialisation */
        char10clazz.setEachCharList(character10s);
        return char10clazz;
    }
}
