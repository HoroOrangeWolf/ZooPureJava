package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Promotion {

    private Long id;
    private BigDecimal price;

    private List<Section> sections = new ArrayList<>();

}