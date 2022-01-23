package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.InfoZone;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.SavannaInfoZone;

public class SavannaMapZone extends Map {

    @Override
    public InfoZone createMapZone() {
        return new SavannaInfoZone();
    }
}
