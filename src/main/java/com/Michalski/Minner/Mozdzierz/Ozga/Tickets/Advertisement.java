package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Advertisement {

    private Long id;
    private Float price;

    private List<Section> sections = new ArrayList<>();

}