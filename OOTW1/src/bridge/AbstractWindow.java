package bridge;

public abstract class AbstractWindow {
    protected WindowImpl windowImpl;

    protected AbstractWindow(WindowImpl windowImpl){
        this.windowImpl=windowImpl;
    }
    abstract void DrawText();
    abstract void DrawRect();
}
