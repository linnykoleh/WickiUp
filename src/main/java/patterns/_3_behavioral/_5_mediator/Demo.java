package patterns._3_behavioral._5_mediator;

/**
 * @author LinnykOleh
 */
public class Demo {

    public static void main(String[] args) {
        final Mediator mediator = new Mediator();

        final Light bedroomLight = new Light("Bedroom");
        final Light kitchenLight = new Light("Kitchen");

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        final Command turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
        turnOnAllLightsCommand.execute();

        final Command turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);
        turnOffAllLightsCommand.execute();


    }
}
