package Command;
public abstract class commandCommand {

	receiverCommand receiverCommand;
	public abstract void execute();
	public commandCommand(receiverCommand receiverCommand){
		this.receiverCommand = receiverCommand;
	}
}
