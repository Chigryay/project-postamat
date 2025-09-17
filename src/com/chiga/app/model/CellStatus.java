package com.chiga.app.model;

public enum CellStatus {
    WORK(1),
    AT_MAINTENANCE(0);

    private final int statusCode;

    CellStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
