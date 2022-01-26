package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;


import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.AfricanariumSection;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;

public class AfricanariumSectionCreator extends SectionCreator {

    @Override
    public Section prepareSection() {
        return new AfricanariumSection();
    }
}
