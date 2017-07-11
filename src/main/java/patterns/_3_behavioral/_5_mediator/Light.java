package patterns._3_behavioral._5_mediator;

/**
 * Receiver
 *
 * @author LinnykOleh
 */
public class Light {

    private boolean isOn = false;

    private String location = "";

    public Light(String location) {
        this.location = location;
    }

    public boolean isOn() {
        return isOn;
    }

    public void toggle(){
        if(isOn){
            isOn = false;
            off();
        }else{
            isOn = true;
            on();
        }
    }

    private void off(){
        System.out.println(location + "light turns off");
    }

    private void on(){
        System.out.println(location + "light turns on");
    }
}
