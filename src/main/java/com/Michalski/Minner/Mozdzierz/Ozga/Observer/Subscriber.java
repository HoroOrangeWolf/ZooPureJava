package com.Michalski.Minner.Mozdzierz.Ozga.Observer;

import com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers.Notification;

public interface Subscriber {
    void notifySubscriber(String informationText);
    long getSubscriberId();
}
