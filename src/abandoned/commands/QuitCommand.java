package abandoned.commands;

/**
 * Class to model a quit command.
 * @author hils124
 */
public class QuitCommand implements Command {
  private CommandProcessor cmdProcess;

  /**
   * Public constructor.
   * @param cmdProcess - specifies cmdProcessor
   */
  public QuitCommand(CommandProcessor cmdProcess) {
    this.cmdProcess = cmdProcess;
  }

  @Override
  public void execute() {
    cmdProcess.quit();
  }
}