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

package org.apache.sling.scripting.handlebars;

import javax.script.ScriptEngine;

import org.apache.sling.scripting.api.AbstractScriptEngineFactory;

public class HandlebarsScriptEngineFactory extends AbstractScriptEngineFactory {

    public final static String HANDLEBARS_SCRIPT_EXTENSION = "hbss"; // using hbss to that we dont acidentally process client side scripts.

    public final static String HANDLEBARS_MIME_TYPE = "text/x-handlebars";

    public final static String HANDLEBARS_SHORT_NAME = "handlebars";
    
    private HandlebarsScriptEngine handlebarsScriptEngine;

    public HandlebarsScriptEngineFactory() {
        setExtensions(HANDLEBARS_SCRIPT_EXTENSION);
        setMimeTypes(HANDLEBARS_MIME_TYPE);
        setNames(HANDLEBARS_SHORT_NAME);
        handlebarsScriptEngine = new HandlebarsScriptEngine(this);
    }

    public String getLanguageName() {
        return "handlebars";
    }

    public String getLanguageVersion() {
        return "1.0";
    }

    public ScriptEngine getScriptEngine() {
        return handlebarsScriptEngine;
    }

}
