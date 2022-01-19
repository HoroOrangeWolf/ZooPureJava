package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class EmailNotifierDecorator extends BaseDecorator{
    public EmailNotifierDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification(String text) {

        System.out.println("Wyslano notification na Email: " + notification.getUser().getEmail());
        notification.sendNotification(text);
    }
}
