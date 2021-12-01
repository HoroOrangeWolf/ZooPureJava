package com.Michalski.Minner.Mozdzierz.Ozga.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private Long id;

    private String password;

    private boolean isBokManager;

    private Date lastLogin;

    private String email;

}
