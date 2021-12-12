package com.Michalski.Minner.Mozdzierz.Ozga.Map;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PathElement {
    private Section section;
    private Boolean isVisited = false;

    public PathElement(Section section) {
        this.section = section;
    }
}
