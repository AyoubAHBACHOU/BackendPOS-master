package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.Notification;
import ma.stibits.pos.model.dao.NotificationRepository;
import ma.stibits.pos.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public Notification saveNotification(Notification n) {
        return notificationRepository.save(n);
    }

    @Override
    public List<Notification> listNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public Notification updateNotification(Notification n) {
        return notificationRepository.save(n);
    }

    @Override
    public Notification getNotification(Long id) {
        return notificationRepository.findById(id).get();
    }
}
