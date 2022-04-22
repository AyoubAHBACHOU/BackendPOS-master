package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.Account;
import ma.stibits.pos.model.bo.Command;
import ma.stibits.pos.model.bo.CommandLine;
import ma.stibits.pos.model.bo.Product;
import ma.stibits.pos.model.dao.CommandLineRepository;
import ma.stibits.pos.model.dao.CommandRepository;
import ma.stibits.pos.model.dao.ProductRepository;
import ma.stibits.pos.service.ICommandLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommandLineService implements ICommandLineService {
    @Autowired
    private CommandLineRepository commandLineRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CommandRepository commandRepository;
    @Override
    public CommandLine saveCommandLine(CommandLine c) {
        return commandLineRepository.save(c);
    }

    @Override
    public List<CommandLine> listCommandsLines() {
        return commandLineRepository.findAll();
    }

    @Override
    public void deleteCommandLine(Long id) {
        commandLineRepository.deleteById(id);

    }


    @Override
    public CommandLine addCommand(Long idC, Long idA) {
        CommandLine c=commandLineRepository.findById(idC).get();
        Command a=commandRepository.findById(idA).get();
        c.setCommand(a);
        return c;
    }

    @Override
    public CommandLine addProduct(Long idC, Long idA) {
        CommandLine c=commandLineRepository.findById(idC).get();
        Product a=productRepository.findById(idA).get();
        c.setProduct(a);
        return c;
    }

    @Override
    public CommandLine updateCommandLine(CommandLine c) {
        return commandLineRepository.save(c);
    }

    @Override
    public CommandLine getCommandLine(Long id) {

        return commandLineRepository.findById(id).get();
    }
}
