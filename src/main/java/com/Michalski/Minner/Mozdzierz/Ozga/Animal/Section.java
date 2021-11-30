package com.Michalski.Minner.Mozdzierz.Ozga.Animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Section {

    private Long id;

    private String name;

    private String description;

    private Boolean isOnTheMap = false;

    private Float mapx;

    private Float mapy;

    private String sectionUrlImage;
}