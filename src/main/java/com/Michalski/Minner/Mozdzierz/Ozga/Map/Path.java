package com.Michalski.Minner.Mozdzierz.Ozga.Map;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Path {
    private List<PathElement> pathElements;
    private int pathIndex = 0;

    public Path(List<Section> sections) {
        List<PathElement> elements = new ArrayList<>();
        for(Section section : sections)
            elements.add(new PathElement(section));

        pathElements = elements;
    }


}
