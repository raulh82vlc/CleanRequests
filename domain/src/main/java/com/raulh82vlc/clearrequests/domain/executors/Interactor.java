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
package com.raulh82vlc.clearrequests.domain.executors;

/**
 * Use case or Interactor, each thread or action
 * is taken in a use case, what means an interactor
 * <p/>
 * This is a contract of the interactor, but
 * concrete logic will be done through its
 * use case (specific interactor implementation)
 * <p/>
 * Created by Raul Hernandez Lopez on 05/09/2015.
 */
public interface Interactor {
    void run();
}
