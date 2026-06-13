package class4;

import org.jetbrains.annotations.NotNull;

public class Button2 implements View {
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(State state) {
    }

    public class ButtonState implements State {

    }
}
