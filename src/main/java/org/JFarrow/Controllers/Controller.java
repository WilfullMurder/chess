package org.JFarrow.Controllers;

public class Controller {
    private final ControllerType type;

    public Controller(ControllerType type) {
        this.type = type;
    }

    public ControllerType getType() {
        return type;
    }
}
