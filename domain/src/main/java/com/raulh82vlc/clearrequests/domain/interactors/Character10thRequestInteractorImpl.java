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

import com.raulh82vlc.clearrequests.domain.executors.Interactor;
import com.raulh82vlc.clearrequests.domain.executors.InteractorExecutor;
import com.raulh82vlc.clearrequests.domain.executors.MainThread;
import com.raulh82vlc.clearrequests.domain.model.Character10;
import com.raulh82vlc.clearrequests.domain.repository.CharacterRepository;

import javax.inject.Inject;

/**
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public class Character10thRequestInteractorImpl implements Character10thRequestInteractor, Interactor {

    private InteractorExecutor executor;
    private MainThread mainThread;
    private CharacterRepository repository;
    private GetCharacter10thCallback callback;

    @Inject
    Character10thRequestInteractorImpl(InteractorExecutor executor,
                                       MainThread mainThread,
                                       CharacterRepository repository) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.repository = repository;
    }

    @Override
    public void execute(GetCharacter10thCallback callback) {
        this.callback = callback;
        this.executor.run(this);
    }

    @Override
    public void run() {
        Character10 character10 = repository.get10thCharacter();
        if (character10 != null) {
            notifyCharacterLoaded(character10);
        } else {
            notifyError();
        }
    }

    /**
     * notifyCharacterLoaded
     * is the helper which notifies to the UI (main) thread
     * to pass the corresponding callback with the data structure
     * filled
     */
    private void notifyCharacterLoaded(final Character10 character10th) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onGetCharacter10thOK(character10th);
            }
        });
    }

    /**
     * notifyError
     * is the helper which notifies to the UI (main) thread
     * that an error has happened
     */
    private void notifyError() {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onGetCharacter10thKO();
            }
        });
    }
}
