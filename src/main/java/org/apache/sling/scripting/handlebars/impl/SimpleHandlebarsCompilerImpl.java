package org.apache.sling.scripting.handlebars.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptException;

import org.apache.commons.io.IOUtils;
import org.apache.sling.scripting.handlebars.api.HandlebarsCompiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

/**
 * A Simple Handlebars Compiler.
 * 
 * @author Thomas Joseph
 *
 */
public class SimpleHandlebarsCompilerImpl implements HandlebarsCompiler {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleHandlebarsCompilerImpl.class);
    
    private Handlebars handlebars = new Handlebars();

    @Override
    public Object eval(Reader reader, ScriptContext context) throws ScriptException {
        Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
        
        Map<String, Object> model = new HashMap<String, Object>();
        for (Object entryObj : bindings.entrySet()) {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) entryObj;
            model.put((String) entry.getKey(), entry.getValue());
        }
        Context hbContext = Context.newContext(model);
        try {
            Template template = handlebars.compileInline(IOUtils.toString(reader));
            template.apply(hbContext, context.getWriter());
        } catch (IOException e) {
            LOG.error("Error in compiling handlebars template.", e);
        }
        return null;
    }

}
