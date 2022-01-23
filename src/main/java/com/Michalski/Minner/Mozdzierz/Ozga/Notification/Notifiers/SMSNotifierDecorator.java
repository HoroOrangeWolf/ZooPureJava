package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class SMSNotifierDecorator extends BaseDecorator{


    public SMSNotifierDecorator(Subscriber sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String text) {
        super.sendMessage(text);
        sendSMS(text);
    }

    public void sendSMS(String text)
    {
        System.out.println("Przez SMS: " + text);
    }
}
