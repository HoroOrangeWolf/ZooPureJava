package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class EmailNotifierDecorator extends BaseDecorator{
    public EmailNotifierDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        notification.sendNotification();
        System.out.println("Wysłano Email do: " + super.getEmail());
    }
}
