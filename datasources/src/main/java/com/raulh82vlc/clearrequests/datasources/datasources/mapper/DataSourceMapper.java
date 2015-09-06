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

/**
 * Uncle Bob declared through his personal blog about Clean,
 * when we pass data across a boundary, it is
 * "always in the form that is most convenient for the inner circle."
 * why?
 * This must be done by that way to don't violate
 * the dependency rule.
 *
 * @author Raul Hernandez Lopez
 */
public interface DataSourceMapper<DataSourceType, DomainModelType> {

    DomainModelType mapFromSourceToModel(DataSourceType dataSourceEntity);
}
