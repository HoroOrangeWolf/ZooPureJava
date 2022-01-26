package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.AquariumSection;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;

public class AquariumSectionCreator extends SectionCreator {


    @Override
    public Section prepareSection() {
        return new AquariumSection();
    }
}
