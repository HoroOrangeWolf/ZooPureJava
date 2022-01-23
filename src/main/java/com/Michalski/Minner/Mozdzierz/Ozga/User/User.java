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

    private Boolean isEmailNotificationReceived = false;

    private Boolean isSMSNotificationReceived = false;

    private Boolean isAppNotificationReceived = false;

    private Boolean isWebNotificationReceived = false;


    public User(String password, boolean isBokManager, Date lastLogin, String email) {
        this.password = password;
        this.isBokManager = isBokManager;
        this.lastLogin = lastLogin;
        this.email = email;
    }

    public Boolean getEmailNotificationReceived() {
        return isEmailNotificationReceived;
    }

    public void setEmailNotificationReceived(Boolean emailNotificationReceived) {
        isEmailNotificationReceived = emailNotificationReceived;
    }

    public Boolean getSMSNotificationReceived() {
        return isSMSNotificationReceived;
    }

    public void setSMSNotificationReceived(Boolean SMSNotificationReceived) {
        isSMSNotificationReceived = SMSNotificationReceived;
    }

    public Boolean getAppNotificationReceived() {
        return isAppNotificationReceived;
    }

    public void setAppNotificationReceived(Boolean appNotificationReceived) {
        isAppNotificationReceived = appNotificationReceived;
    }

    public Boolean getWebNotificationReceived() {
        return isWebNotificationReceived;
    }

    public void setWebNotificationReceived(Boolean webNotificationReceived) {
        isWebNotificationReceived = webNotificationReceived;
    }

    @Override
    public void sendMessage(String text) {

    }

    @Override
    public User getUser() {
        return this;
    }
}
