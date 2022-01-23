package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;

public interface Subscriber {

    void sendMessage(String text);
    User getUser();

}
