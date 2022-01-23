package com.Michalski.Minner.Mozdzierz.Ozga.User;

import com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers.Subscriber;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User implements Subscriber {

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



    @Override
    public void sendMessage(String text) {

    }

    @Override
    public User getUser() {
        return this;
    }
}
