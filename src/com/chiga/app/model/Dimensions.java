package com.chiga.app.model;

public record Dimensions(double length, double width, double height) {
    public boolean compareTo(Dimensions dimensions) {
        return this.length >= 0
                && this.width >= 0
                && this.height >= 0;
    }
}
