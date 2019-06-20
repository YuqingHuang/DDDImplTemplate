package com.hellobank.common;

public enum ExecuteResult {
    success( "success"),
    fail("fail");

    private final String result;

    ExecuteResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return this.result;
    }
}
