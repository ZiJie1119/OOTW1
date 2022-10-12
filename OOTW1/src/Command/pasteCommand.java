package Command;

public class pasteCommand extends commandCommand {

	public pasteCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.Paste();
	}
}
