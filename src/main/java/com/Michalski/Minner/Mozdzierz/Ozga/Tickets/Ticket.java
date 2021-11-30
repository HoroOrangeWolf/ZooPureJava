package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ticket {

    private Long id;

    private String name;

    private String description;

    private Float price;
}