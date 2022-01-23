package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.AfricanariumInfoZone;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.AquariumInfoZone;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.InfoZone;

public class AquariumMapZone extends Map {


    @Override
    public InfoZone createMapZone() {
        return new AquariumInfoZone();
    }
}
