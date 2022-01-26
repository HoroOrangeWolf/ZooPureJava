package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.SavannaSection;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;

public class SavannaCreator extends SectionCreator {

    @Override
    public Section prepareSection() {
        return new SavannaSection();
    }
}
