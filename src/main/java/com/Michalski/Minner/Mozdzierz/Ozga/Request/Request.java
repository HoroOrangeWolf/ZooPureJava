package com.Michalski.Minner.Mozdzierz.Ozga.Request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Request {

    private Long id;

    private Status status;

    private String text;
}