package com.wawa.workloadmanagement.model;

public enum ProductType {
    VEGPIZZA("Veg Pizza"),
    NVPIZZA("NV Pizza"),
    SANDWICH("Sandwich");

    private String type;
    private ProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
