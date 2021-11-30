package com.Michalski.Minner.Mozdzierz.Ozga.Animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Animal {

    private Long id;

    //Klucz obcy sekcja
    private Long idSection;

    private String name;

    private String description;


}