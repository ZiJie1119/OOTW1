package Command;

public class saveCommand extends commandCommand {

	public saveCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.Cut();
	}
}
