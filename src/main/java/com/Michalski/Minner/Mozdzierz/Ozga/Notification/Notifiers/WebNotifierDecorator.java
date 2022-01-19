package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class WebNotifierDecorator extends BaseDecorator{
    public WebNotifierDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification(String text) {
        notification.sendNotification(text);
        System.out.println("Wyslano notification na przeglądarke dla użytwkonika: " + notification.getUser().getEmail());
    }
}
