package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.*;
import ma.stibits.pos.model.dao.*;
import ma.stibits.pos.service.ICommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommandService implements ICommandService {
    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CommandLineRepository commandLineRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Command saveCommand(Command c) {
        return commandRepository.save(c);
    }

    @Override
    public List<Command> listCommands() {
        return commandRepository.findAll();
    }

    @Override
    public void deleteCommand(Long id) {
        commandRepository.deleteById(id);
    }

    @Override
    public Command updateCommand(Command c) {
        return commandRepository.save(c);
    }

    @Override
    public Command getCommand(Long id) {
        return commandRepository.findById(id).get();
    }

    @Override
    public Command addCommandLine(Long idC, Long idCl) {
        Command c=commandRepository.findById(idC).get();
        CommandLine cl=commandLineRepository.findById(idCl).get();
        c.getCommandLines().add(cl);
        return c;
    }

    @Override
    public Command addPay(Long idC, Long idCl) {
        Command c=commandRepository.findById(idC).get();
        Payment cl=paymentRepository.findById(idCl).get();
        c.getPayments().add( cl);
        return c;
    }

    @Override
    public Command addAccount(Long idC,Long idA) {
        Command c=commandRepository.findById(idC).get();
        Account a=accountRepository.findById(idA).get();
        c.setAccount(a);
        return c;
    }
    @Override
    public Command addCoupon(Long idC,Long idCp) {
        Command c=commandRepository.findById(idC).get();
        Coupon cp=couponRepository.findById(idCp).get();
        c.setCoupon(cp);
        return c;
    }
}

