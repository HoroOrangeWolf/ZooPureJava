package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;

public interface Notification {
    void sendNotification(String text);
    User getUser();
}
