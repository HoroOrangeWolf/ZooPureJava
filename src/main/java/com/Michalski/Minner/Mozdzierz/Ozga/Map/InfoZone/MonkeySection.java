package com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MonkeySection implements Section {
    private Long id;
    private String description;
    private Float x, y;
    private Boolean isOnTheMap;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String generateDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setIsOnTheMap(boolean isOnTheMap) {
        this.isOnTheMap = isOnTheMap;
    }

    @Override
    public boolean isOnTheMap() {
        return isOnTheMap;
    }

    @Override
    public void setCordsOnMap(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float getCordX() {
        return x;
    }

    @Override
    public float getCordY() {
        return y;
    }

    @Override
    public void manageSection() {
        System.out.println("Zarządzam sekcją Monkey...");
    }

    @Override
    public void planTours() {
        System.out.println("Planuje wycieczki po Monkey...");
    }

    @Override
    public void takeSafetyPrecautions() {
        System.out.println("Planuje bezpieczeństwo Monkey...");
    }

    @Override
    public void setUp(Long id, String description, Boolean isOnTheMap, float x, float y) {
        this.id = id;
        this.description = description;
        this.isOnTheMap = isOnTheMap;
        this.x = x;
        this.y = y;
    }
}
