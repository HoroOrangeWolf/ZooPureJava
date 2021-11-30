package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    private Long id;

    private String name;

    private String description;

    private Float price;
}