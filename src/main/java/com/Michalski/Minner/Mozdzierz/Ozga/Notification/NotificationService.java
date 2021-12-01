package com.Michalski.Minner.Mozdzierz.Ozga.Notification;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class NotificationService {
    private final NotificationRepository repository = new NotificationRepository();

    public void addNotification(Notification notification){
        repository.save(notification);
    }

    public void setReadNotification(Notification notification){
        notification.setRead(true);
        repository.update(notification);
    }

    public void removeNotification(Notification notification){
        repository.remove(notification);
    }



    public List<Notification> getUnreadNotifications(User user){
        return repository.getByPredictor(f -> Objects.equals(user.getId(), f.getIdUser()) && !f.isRead());
    }





}
