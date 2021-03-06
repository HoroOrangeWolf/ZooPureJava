package com.Michalski.Minner.Mozdzierz.Ozga.Observer;

import com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers.Subscriber;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode
public class Notifier {
    private final List<Subscriber> subscriberMap = new LinkedList<>();

    public void addSubscriber(Subscriber subscriber){
        subscriberMap.add(subscriber);
    }

    public void removeSubscriber(Long id){
        subscriberMap.removeIf(f->f.getUser().getId() == id);
    }

    public List<Subscriber> getSubscribers(){
        return subscriberMap;
    }

    public void notifySubscribers(String informationText){
        subscriberMap.forEach(f->f.sendMessage(informationText));
    }
}
