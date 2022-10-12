package Command;
public class cutCommand extends commandCommand {

	public cutCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.Cut();
	}
}
