package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Command;
import ma.stibits.pos.model.bo.CommandLine;

import java.util.List;
import java.util.Optional;

public interface ICommandLineService {
    public CommandLine saveCommandLine(CommandLine c);
    public List<CommandLine> listCommandsLines();
    public void deleteCommandLine(Long id);
    public CommandLine updateCommandLine(CommandLine c);
    public CommandLine getCommandLine(Long id);
    public CommandLine addCommand(Long idC, Long id);
    public CommandLine addProduct(Long idC, Long id);
}
