package com.Michalski.Minner.Mozdzierz.Ozga.User;

import lombok.*;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    private Long id;

    private String password;

    private boolean isBokManager;

    private Date lastLogin;

    private String email;

    private String phoneNumber;

    private Boolean isEmailNotification = false;

    private Boolean isSMSNotification = false;

    private Boolean isAppNotification = false;

    private Boolean isWebNotification = false;


    public User(String password, boolean isBokManager, Date lastLogin, String email) {
        this.password = password;
        this.isBokManager = isBokManager;
        this.lastLogin = lastLogin;
        this.email = email;
    }
}
