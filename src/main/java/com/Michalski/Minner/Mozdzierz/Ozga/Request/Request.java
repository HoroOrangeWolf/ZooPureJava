package com.Michalski.Minner.Mozdzierz.Ozga.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Request {

    private Long id;

    private Status status;

    private String text;
}