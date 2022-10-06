package Command;
public class copyCommand extends commandCommand {

	public copyCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.Copy();
	}

}
