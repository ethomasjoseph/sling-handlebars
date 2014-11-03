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

import java.io.Reader;

import javax.script.ScriptContext;
import javax.script.ScriptException;

/**
 * Handlebars Compiler. Provides a subset of the APIs exposed by {@link javax.script.ScriptEngine}.
 * 
 * @author Thomas Joseph
 *
 */
public interface HandlebarsCompiler {
    /**
     * Evaluates the script provided by the <tt>reader</tt> in the provided <tt>context</tt>.
     * 
     * @param reader
     * @param context
     * @return
     * @throws ScriptException
     */
    public Object eval(Reader reader , ScriptContext context) throws ScriptException;
}
