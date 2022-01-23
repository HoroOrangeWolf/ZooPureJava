package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.InfoZone;

public abstract class Map {

    public abstract InfoZone createMapZone();

    public InfoZone render(){
        return createMapZone();
    }
}
