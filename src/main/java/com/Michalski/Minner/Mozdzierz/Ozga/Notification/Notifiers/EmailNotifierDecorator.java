package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class EmailNotifierDecorator extends BaseDecorator{

    public EmailNotifierDecorator(Subscriber sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String text) {
        super.sendMessage(text);
        sendEmail(text);
    }

    public void sendEmail(String text)
    {
        System.out.println("Na Email: " + text);
    }

}
