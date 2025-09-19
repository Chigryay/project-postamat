package com.chiga.app.model;

public record Dimensions(double length, double width, double height) {
    public boolean compareTo(Dimensions dimensions) {
        return this.length >= dimensions.length
                && this.width >= dimensions.width
                && this.height >= dimensions.height;
    }
}
