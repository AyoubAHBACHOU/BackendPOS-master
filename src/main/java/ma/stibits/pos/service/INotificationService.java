package ma.stibits.pos.service;


import ma.stibits.pos.model.bo.Notification;

import java.util.List;
import java.util.Optional;

public interface INotificationService {
    public Notification saveNotification(Notification n);
    public List<Notification> listNotifications();
    public void deleteNotification(Long id);
    public Notification updateNotification(Notification n);
    public Notification getNotification(Long id);
}
