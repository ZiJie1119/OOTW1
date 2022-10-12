package Command;
public class undoCommand extends commandCommand {

	public undoCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.Undo();
	}

}
