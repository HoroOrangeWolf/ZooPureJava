package com.Michalski.Minner.Mozdzierz.Ozga.Observer;

import com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers.Subscriber;

import java.util.LinkedList;
import java.util.List;

public class NewsletterNotifier {
    private static final List<Subscriber> subscriberMap = new LinkedList<>();

    public static void addSubscriber(Subscriber subscriber){
        subscriberMap.add(subscriber);
    }

    public void removeSubscriber(Long id){
        subscriberMap.removeIf(f->f.getUser().getId() == id);
    }

    public void notifySubscribers(String informationText){
        subscriberMap.forEach(f->f.sendMessage(informationText));
    }


}
