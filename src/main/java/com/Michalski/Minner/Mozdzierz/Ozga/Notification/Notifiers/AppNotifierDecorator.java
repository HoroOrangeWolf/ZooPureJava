package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class AppNotifierDecorator extends BaseDecorator{
    public AppNotifierDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        notification.sendNotification();
        System.out.println("Wysłano App do: " + super.getEmail());
    }
}
