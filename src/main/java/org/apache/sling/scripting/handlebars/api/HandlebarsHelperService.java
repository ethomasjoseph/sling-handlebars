/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The SF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.apache.sling.scripting.handlebars.api;

import com.github.jknack.handlebars.Helper;

/**
 * Handlebar Helpers can be published as an OSGi service in this interface.
 * @author Thomas Joseph
 *
 * @param <T>
 */
public interface HandlebarsHelperService<T> {
    /**
     * @return The name of the helper.
     */
    String getName();
    
    /**
     * 
     * @return The helper instance.
     */
    Helper<T> getHelper();
}
