package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Account;
import ma.stibits.pos.model.bo.Command;
import ma.stibits.pos.model.bo.CommandLine;

import java.util.List;
import java.util.Optional;

public interface ICommandService {
    public Command saveCommand(Command c);
    public List<Command> listCommands();
    public void deleteCommand(Long id);
    public Command updateCommand(Command c);
    public Command getCommand(Long id);
    public Command addAccount(Long idC, Long id);
    public Command addCommandLine(Long idC, Long cl);
    public Command addPay(Long idC, Long cl);
    public Command addCoupon(Long idC,Long idCp);



}
