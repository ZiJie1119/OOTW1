package Command;
import java.util.ArrayList;
import java.util.List;

public class invokerCommand {
	List<commandCommand>commandList = new ArrayList<commandCommand>();
	
	public void addCommend(commandCommand commandCommand) {
		commandList.add(commandCommand);
	}
	public void execute() {
		for(commandCommand command : commandList) {
			command.execute();
		}
	}

}
