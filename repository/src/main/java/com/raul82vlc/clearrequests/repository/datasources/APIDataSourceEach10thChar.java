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
package com.raul82vlc.clearrequests.repository.datasources;

import com.raulh82vlc.clearrequests.domain.model.Each10Char;


/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public interface APIDataSourceEach10thChar {

    /**
     * startRequest contract is the main responsible of getting
     * the API info, which means,
     * if the class is not initialised already
     * then a call is demanded and makes right settings,
     * logic is independent to this contract
     */
    void startRequest();

    Each10Char getEach10thChar();
}
