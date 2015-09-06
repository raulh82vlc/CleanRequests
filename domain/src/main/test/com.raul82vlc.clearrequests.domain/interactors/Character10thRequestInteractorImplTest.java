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
package com.raulh82vlc.clearrequests.domain.interactors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import com.raulh82vlc.clearrequests.domain.executors.Interactor;
import com.raulh82vlc.clearrequests.domain.executors.InteractorExecutor;
import com.raulh82vlc.clearrequests.domain.executors.MainThread;
import com.raulh82vlc.clearrequests.domain.model.Character10;
import com.raulh82vlc.clearrequests.domain.repository.CharacterRepository;
import com.raulh82vlc.clearrequests.domain.interactors.Character10thRequestInteractorImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class Character10thRequestInteractorImplTest {

    @Mock private InteractorExecutor mockThreadExecutor;
    @Mock private MainThread mockPostExecutionThread;
    @Mock private CharacterRepository mockUserRepository;
    private Character10thRequestInteractorImpl interactor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        interactor = new Character10thRequestInteractorImpl(executor, mainThread,
                repository);
    }


    @Test
    public void testGetUserDetailsUseCaseObservableHappyCase() {
        Character10 character10th = new Character10("asda");
        interactor.notifyCharacterLoaded(character10th);

        verify(mockUserRepository).get10thCharacter();
        verifyNoMoreInteractions(mockUserRepository);
        verifyZeroInteractions(mockPostExecutionThread);
        verifyZeroInteractions(mockThreadExecutor);
    }
}
