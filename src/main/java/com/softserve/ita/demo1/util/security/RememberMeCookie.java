package com.softserve.ita.demo1.util.security;

public class RememberMeCookie {
    private String selector;
    private String validator;

    public RememberMeCookie(String selector, String validator) {
        this.selector = selector;
        this.validator = validator;
    }

    public RememberMeCookie() {
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }
}
