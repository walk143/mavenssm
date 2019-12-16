package com.sloera.mng.core.error;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import java.io.Writer;

import org.slf4j.LoggerFactory;

public class FreemarkerException implements TemplateExceptionHandler {
    private static final Logger log4j = LoggerFactory.getLogger(FreemarkerException.class);
    public FreemarkerException(){};

    @Override
    public void handleTemplateException(TemplateException e, Environment environment, Writer writer) throws TemplateException {
        if(log4j.isWarnEnabled()){
            
        }
        if (log4j.isWarnEnabled()) {
            log4j.warn("[Freemarker Error: " + e.getMessage() + "]");
        }

        if (log4j.isInfoEnabled()) {
            log4j.info("[Freemarker Error: " + e.getMessage() + "]");
        }

        if (log4j.isDebugEnabled()) {
            log4j.debug("[Freemarker Error: " + e.getMessage() + "]");
        }
    }
}
