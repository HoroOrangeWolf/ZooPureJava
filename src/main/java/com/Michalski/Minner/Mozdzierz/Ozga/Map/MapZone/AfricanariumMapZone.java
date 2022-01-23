package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.AfricanariumInfoZone;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.InfoZone;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone.Map;

public class AfricanariumMapZone extends Map {

    @Override
    public InfoZone createMapZone() {
        return new AfricanariumInfoZone();
    }
}
