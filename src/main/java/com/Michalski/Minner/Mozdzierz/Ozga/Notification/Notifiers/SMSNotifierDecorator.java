package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class SMSNotifierDecorator extends BaseDecorator{
    public SMSNotifierDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        notification.sendNotification();
        System.out.println("Wysłano SMS do: " + super.getEmail());
    }
}
