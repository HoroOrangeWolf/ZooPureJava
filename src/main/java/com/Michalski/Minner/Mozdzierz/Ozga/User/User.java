package com.Michalski.Minner.Mozdzierz.Ozga.User;

import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private Long id;

    private String password;

    private boolean isBokManager;

    private Date lastLogin;

    private String email;

}
