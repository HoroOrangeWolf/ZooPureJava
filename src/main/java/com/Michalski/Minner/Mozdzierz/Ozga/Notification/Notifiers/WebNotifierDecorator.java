package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class WebNotifierDecorator extends BaseDecorator{
    public WebNotifierDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        notification.sendNotification();
        System.out.println("Wysłano WEB do: " + super.getEmail());
    }
}
