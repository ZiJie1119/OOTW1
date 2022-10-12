package Memento;

public class originator {
	private String state;
	public originator() {
		
	}
	public void storeState(String state) {
		this.state = state;
	}
	public String getNow() {
		return state;
	}
	public memento setMemento() {
		return new memento(state);
	}
	public void restoreFromMemento(memento memento) {
		this.state = memento.getState();
	}
}
