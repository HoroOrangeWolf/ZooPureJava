package com.Michalski.Minner.Mozdzierz.Ozga.Animal;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Section {

    private Long id;

    private String name;

    private String description;

    private Boolean isOnTheMap = false;

    private Float mapx;

    private Float mapy;

    private String sectionUrlImage;
}