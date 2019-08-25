package com.example.demo;

import java.util.Locale;

import org.hibernate.validator.messageinterpolation.HibernateMessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

public class MyResourceBundleMessageInterpolator extends ResourceBundleMessageInterpolator {
    @Override
    public String interpolate (Context context, Locale locale, String term) {
        String result = super.interpolate(context, locale, term);
        if (isMessageParameter(term, context)) {
            result = "'" + result + "'";
        }
        return result;
    }

    private boolean isMessageParameter (String term, Context context) {
        if (!(context instanceof HibernateMessageInterpolatorContext)) {
            return false;
        }

        HibernateMessageInterpolatorContext messageInterpolatorContext = (HibernateMessageInterpolatorContext)context;
        for (String key : messageInterpolatorContext.getMessageParameters().keySet()) {
            if (term.equals("{" + key + "}")) {
                return true;
            }
        }

        return false;
    }
}
