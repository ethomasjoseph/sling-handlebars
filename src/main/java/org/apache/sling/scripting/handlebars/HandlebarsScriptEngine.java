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

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptException;

import org.apache.commons.io.IOUtils;
import org.apache.sling.scripting.api.AbstractSlingScriptEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

public class HandlebarsScriptEngine extends AbstractSlingScriptEngine {

    private static final Logger LOGGER = LoggerFactory.getLogger(HandlebarsScriptEngine.class);

    public HandlebarsScriptEngine(
            HandlebarsScriptEngineFactory handlebarsScriptEngineFactory) {
        super(handlebarsScriptEngineFactory);
    }

    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        Handlebars handlebars = new Handlebars();
        try {
            Template template = handlebars.compileInline(IOUtils.toString(reader));
            Map<String, Object> model = new HashMap<String, Object>();
            Bindings bindings = scriptContext.getBindings(ScriptContext.ENGINE_SCOPE);
            for (Object entryObj : bindings.entrySet()) {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) entryObj;
                model.put((String) entry.getKey(), entry.getValue());
            }
            Context hbContext = Context.newContext(model);
            template.apply(hbContext, scriptContext.getWriter());
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

}
