package com.Michalski.Minner.Mozdzierz.Ozga.Animal;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Animal {

    private Long id;

    //Klucz obcy sekcja
    private Long idSection;

    private String name;

    private String description;


}