package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class WebNotifierDecorator extends BaseDecorator{
    public WebNotifierDecorator(Subscriber sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String text) {
        super.sendMessage(text);
        sendWebNotification(text);
    }

    public void sendWebNotification(String text)
    {
        System.out.println("Na aplikacje webowa: " + text);
        super.getUser().setWebNotificationReceived(true);
    }
}
