package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.InfoZone;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.MonkeyInfoZone;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.Zone;

public class MonkeyMapZone extends Map {


    @Override
    public InfoZone createMapZone() {
        return new MonkeyInfoZone();
    }
}
