package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class SMSNotifierDecorator extends BaseDecorator{
    public SMSNotifierDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification(String text) {
        notification.sendNotification(text);
        System.out.println("Wyslano sms na: " + notification.getUser().getPhoneNumber() + " ");
    }
}
