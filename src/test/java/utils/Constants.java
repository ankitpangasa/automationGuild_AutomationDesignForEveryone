package utils;

public class Constants {
    public static String CONF_PATH = "conf/";
    static String ENV_KEY = "environment";
    static String DEFAULT_PROPERTY_FILE = "default";
    public static String PROPERTY_SUFFIX = ".properties";

    public enum ENVIRONMENTS {
        DEV,
        STAGE,
        PROD
    }

    static String DEFAULT_ENV = "stage";
}
