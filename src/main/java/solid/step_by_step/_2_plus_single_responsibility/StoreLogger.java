package solid.step_by_step._2_plus_single_responsibility;

import org.apache.log4j.Logger;

/**
 * @author LinnykOleh
 */
public class StoreLogger {

    private Logger logger;

    public StoreLogger(Class clazz) {
        this.logger = Logger.getLogger(clazz);
    }

    public void saving(int id) {
        logger.info("Saving message " + id);
    }

    public void saved(int id) {
        logger.info("Saved message " + id);
    }

    public void reading(int id) {
        logger.debug("Reading message " + id);
    }

    public void didNotFind(int id) {
        logger.debug("No message " + id + " found.");
    }

    public void returning(int id) {
        logger.debug("Returning message " + id);
    }

}

