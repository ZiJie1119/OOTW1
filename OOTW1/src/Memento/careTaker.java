package Memento;
import java.util.*;
public class careTaker {
	private memento memento;
	private Stack<memento> st = new Stack<memento>();
	
	
	public memento getMemento() {
		
		st.pop();
		return st.peek();//用pop比較好，但是要預防取到最後沒東西會跳exception
		
	}
	public void setMemento(memento memento) {
//		this.memento = memento;
		st.push(memento);
	}
}
