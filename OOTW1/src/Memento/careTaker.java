package Memento;
import java.util.*;
public class careTaker {
	private memento memento;
	private Stack<memento> st = new Stack<memento>();
	
	
	public memento getMemento() {
		
		st.pop();
		return st.peek();//��pop����n�A���O�n�w������̫�S�F��|��exception
		
	}
	public void setMemento(memento memento) {
//		this.memento = memento;
		st.push(memento);
	}
}
