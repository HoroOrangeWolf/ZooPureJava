package com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.MonkeySection;

public class MonkeyCreator extends SectionCreator {

    @Override
    public Section prepareSection() {
        return new MonkeySection();
    }
}
