package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class AppNotifierDecorator extends BaseDecorator{

    public AppNotifierDecorator(Subscriber sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String text) {
        super.sendMessage(text);
        sendNotificationToApplication(text);
    }

    public void sendNotificationToApplication(String text)
    {
        System.out.println("Na telefon: " + text);
    }
}
