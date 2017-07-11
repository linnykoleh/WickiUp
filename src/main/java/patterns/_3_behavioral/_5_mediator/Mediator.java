package patterns._3_behavioral._5_mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class Mediator {

    private List<Light> lights = new ArrayList<>();

    public void registerLight(Light light) {
        lights.add(light);
    }

    public void turnOnAllLights(){
        for(Light light : lights){
            if(!light.isOn()){
                light.toggle();
            }
        }
    }

    public void turnOffAllLights(){
        for(Light light : lights){
            if(light.isOn()){
                light.toggle();
            }
        }
    }
}


