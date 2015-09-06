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
package com.raulh82vlc.cleanrequests.di.modules;

import com.raul82vlc.clearrequests.repository.CharacterRepositoryImpl;
import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceChar;
import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceEach10thChar;
import com.raul82vlc.clearrequests.repository.datasources.APIDataSourceWordCounter;
import com.raulh82vlc.cleanrequests.di.scopes.ActivityScope;
import com.raulh82vlc.clearrequests.datasources.datasources.APIDataSourceCharImpl;
import com.raulh82vlc.clearrequests.datasources.datasources.APIDataSourceEach10thCharImpl;
import com.raulh82vlc.clearrequests.datasources.datasources.APIDataSourceWordCounterImpl;
import com.raulh82vlc.clearrequests.datasources.datasources.mapper.DataSourceMapper;
import com.raulh82vlc.clearrequests.datasources.datasources.mapper.Each10thCharacterMapper;
import com.raulh82vlc.clearrequests.domain.interactors.Character10thRequestInteractor;
import com.raulh82vlc.clearrequests.domain.interactors.Character10thRequestInteractorImpl;
import com.raulh82vlc.clearrequests.domain.interactors.Each10thCharacterRequestInteractor;
import com.raulh82vlc.clearrequests.domain.interactors.Each10thCharacterRequestInteractorImpl;
import com.raulh82vlc.clearrequests.domain.interactors.WordCounterRequestInteractor;
import com.raulh82vlc.clearrequests.domain.interactors.WordCounterRequestInteractorImpl;
import com.raulh82vlc.clearrequests.domain.repository.CharacterRepository;
import com.raulh82vlc.clearrequests.presentation.CleanRequestPresenter;
import com.raulh82vlc.clearrequests.presentation.CleanRequestPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Module which provides all user required artifacts
 * (presenter, interactors, repository, datasources or mappers)
 * in order to use them in a decoupled way
 *
 * @author Raul Hernandez Lopez
 */
@Module
public class RequestsModule {


    @Provides
    @ActivityScope
    CleanRequestPresenter provideCharacter10thPresenter(CleanRequestPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    Character10thRequestInteractor provideCharacter10thInteractor(Character10thRequestInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    Each10thCharacterRequestInteractor provideEach10thInteractor(Each10thCharacterRequestInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    WordCounterRequestInteractor provideWordCounterInteractor(WordCounterRequestInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    CharacterRepository provideCharacterRepository(CharacterRepositoryImpl repository) {
        return repository;
    }

    @Provides
    @ActivityScope
    APIDataSourceChar provideDataSourceChar(APIDataSourceCharImpl dataSource) {
        return dataSource;
    }

    @Provides
    @ActivityScope
    APIDataSourceEach10thChar provideDataSourceEachChar(APIDataSourceEach10thCharImpl dataSource) {
        return dataSource;
    }

    @Provides
    @ActivityScope
    APIDataSourceWordCounter provideDataSourceWordsCounter(APIDataSourceWordCounterImpl dataSource) {
        return dataSource;
    }

    @Provides
    @ActivityScope
    DataSourceMapper provideEachCharDataSourceMapper(Each10thCharacterMapper mapper) {
        return mapper;
    }
}
