package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.CommandLine;
import ma.stibits.pos.service.Implementation.CommandLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commandlines")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class CommandLineController {
    @Autowired
    public CommandLineService commandLineService;

    @PostMapping("/add")
    public ResponseEntity<CommandLine> addCommandLine(@RequestBody CommandLine c){
        CommandLine cl=commandLineService.saveCommandLine(c);
        return  new ResponseEntity<>(cl, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CommandLine> updateAccount(@RequestBody CommandLine c){
        CommandLine cl=commandLineService.updateCommandLine(c);
        return new ResponseEntity<>(cl,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CommandLine>> getAllCommandsLines(){
        List<CommandLine> lst=commandLineService.listCommandsLines();
        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<CommandLine> getOneCommandLine(@PathVariable("id") Long id){
        CommandLine cl=commandLineService.getCommandLine(id);
        return new ResponseEntity<>(cl,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommandLine(@PathVariable("id") Long id){
        commandLineService.deleteCommandLine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /*******************************************************************/
    @PostMapping("/addAccount")
    public CommandLine addAccountToCom(@RequestBody FormAddTo form){
        return  commandLineService.addCommand(form.idM,form.idO);
    }

    @PostMapping("/addProduct")
    public CommandLine addProductToCom(@RequestBody FormAddTo form){
        return  commandLineService.addProduct(form.idM,form.idO);
    }
}
