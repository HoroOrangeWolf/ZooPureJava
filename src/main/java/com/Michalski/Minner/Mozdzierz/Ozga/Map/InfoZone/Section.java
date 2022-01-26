package com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone;

import java.util.Vector;

public interface Section {
    long getId();
    void setId(long id);
    String generateDescription();
    void setDescription(String description);
    void setIsOnTheMap(boolean isOnTheMap);
    boolean isOnTheMap();
    void setCordsOnMap(float x, float y);
    float getCordX();
    float getCordY();
    void manageSection();
    void planTours();
    void takeSafetyPrecautions();


}
