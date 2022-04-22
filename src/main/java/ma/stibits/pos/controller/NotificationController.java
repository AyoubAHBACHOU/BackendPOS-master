package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Customer;
import ma.stibits.pos.model.bo.Notification;
import ma.stibits.pos.service.Implementation.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("notifications")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/add")
    public ResponseEntity<Notification> addNotification(@RequestBody Notification c){
        Notification n=notificationService.saveNotification(c);
        return new ResponseEntity<>(n, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Notification> updateNotification(@RequestBody Notification c){
        Notification n=notificationService.updateNotification(c);
        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Notification>> getAllNotifications(){
        List<Notification> lst=notificationService.listNotifications();
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Notification> getOneNotification(@PathVariable("id") Long id){
        Notification n=notificationService.getNotification(id);
        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotification(@PathVariable("id") Long id){
        notificationService.deleteNotification(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
