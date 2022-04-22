package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Command;
import ma.stibits.pos.service.Implementation.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commands")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class CommandController {
    @Autowired
    public CommandService commandService;

    @PostMapping("/add")
    public ResponseEntity<Command> addCommand(@RequestBody Command c){
        Command com=commandService.saveCommand(c);
        return  new ResponseEntity<>(com, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Command> updateCommand(@RequestBody Command c){

        Command com=commandService.updateCommand(c);
        return new ResponseEntity<>(com,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Command>> getAllCommands(){

        List<Command> lst=commandService.listCommands();
        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Command> getOneCommand(@PathVariable("id") Long id){
        Command com=commandService.getCommand(id);
        return new ResponseEntity<>(com,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommand(@PathVariable("id") Long id){
        commandService.deleteCommand(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addCoupon")
    public Command addCouponToCom(@RequestBody FormAddTo fo){
        return  commandService.addCoupon(fo.idM,fo.idO);
    }
    /*******************************************************************/
    @PostMapping("/addAccount")
    public Command addAccountToCom(@RequestBody FormAddTo fo){
        return  commandService.addAccount(fo.idM,fo.idO);
    }
    @PostMapping("/addComLine")
    public Command addComLineToCom(@RequestBody FormAddTo fo){
        return  commandService.addCommandLine(fo.idM,fo.idO);
    }

    @PostMapping("/addPayment")
    public Command addPayment(@RequestBody FormAddTo fo){
        return  commandService.addPay(fo.idM,fo.idO);
    }

}
