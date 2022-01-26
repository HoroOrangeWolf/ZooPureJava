package com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone;

public class SavannaSection implements Section {

    private int id;
    private String description;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String generateDescription() {
        return description;
    }

    @Override
    public void manageSection() {

    }

    @Override
    public void planTours() {

    }

    @Override
    public void takeSafetyPrecautions() {

    }
}
