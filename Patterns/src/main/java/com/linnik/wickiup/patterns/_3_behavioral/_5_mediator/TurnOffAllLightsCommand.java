package com.linnik.wickiup.patterns._3_behavioral._5_mediator;

/**
 * Concrete command
 *
 * @author LinnykOleh
 */
public class TurnOffAllLightsCommand implements Command {

    private Mediator mediator;

    public TurnOffAllLightsCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        mediator.turnOffAllLights();
    }
}
