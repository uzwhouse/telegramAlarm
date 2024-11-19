import java.util.logging.Level;
import java.util.logging.Logger;

public class TelegramAlarmExample {
    static {
        String sourceLogConf = "java.util.logging.config.file";
        String changedLogConf = TelegramAlarmExample.class.getClassLoader().getResource("logging.properties").getPath();
        System.setProperty(sourceLogConf, changedLogConf);
    }

    private static Logger logger = Logger.getLogger(TelegramAlarmExample.class.getName());

    public static void main(String[] args) {
        try {
            System.out.println(0 / 0);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Severe", e);
        }
    }
}
