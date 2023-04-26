package constants;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Path {

    public static String nomePc;

    static {
        try {
            nomePc = InetAddress.getLocalHost().getHostName();
        }  catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static final String CHROME_DRIVER_IOS= System.getProperty("user.dir") + "/src/test/java/common/drivers/ios/chromedriver";
    public static final String CHROME_DRIVER_LINUX= System.getProperty("user.dir") + "/src/test/java/common/drivers/linux/chromedriver";
}
