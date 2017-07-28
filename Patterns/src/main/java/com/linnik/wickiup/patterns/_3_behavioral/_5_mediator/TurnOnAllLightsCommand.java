package com.linnik.wickiup.patterns._3_behavioral._5_mediator;

/**
 * Concrete command
 *
 * @author LinnykOleh
 */
public class TurnOnAllLightsCommand implements Command{

    private Mediator mediator;

    public TurnOnAllLightsCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        mediator.turnOnAllLights();
    }
}
