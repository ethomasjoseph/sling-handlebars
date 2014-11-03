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

import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptException;

import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.api.AbstractSlingScriptEngine;
import org.apache.sling.scripting.handlebars.api.HandlebarsCompiler;
import org.apache.sling.scripting.handlebars.impl.SimpleHandlebarsCompilerImpl;

/**
 * Handlebars Scripting Engine tries tries to find a SlingBinding, and a HandlebarsCompiler OSGi service. Defaults to use
 * {@link SimpleHandlebarsCompilerImpl}
 * 
 * @author Ian
 * @author Thomas Joseph
 * 
 */
public class HandlebarsScriptEngine extends AbstractSlingScriptEngine {

    public HandlebarsScriptEngine(
        HandlebarsScriptEngineFactory handlebarsScriptEngineFactory) {
        super(handlebarsScriptEngineFactory);
    }

    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        Bindings bindings = scriptContext.getBindings(ScriptContext.ENGINE_SCOPE);
        SlingScriptHelper sling = (SlingScriptHelper) bindings.get(SlingBindings.SLING);
        if (sling != null) {
            HandlebarsCompiler handlebarsCompiler = sling.getService(HandlebarsCompiler.class);
            if (handlebarsCompiler != null) {
                return handlebarsCompiler.eval(reader, scriptContext);
            }
        } else {
            // provide simple scripting if no sling
            HandlebarsCompiler handlebarsCompiler = new SimpleHandlebarsCompilerImpl();
            return handlebarsCompiler.eval(reader, scriptContext);
        }
        return null;
    }
}
