package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;

public abstract class SectionCreator {

    public abstract Section prepareSection();

    public Section createSection(){
        return prepareSection();
    }

}
