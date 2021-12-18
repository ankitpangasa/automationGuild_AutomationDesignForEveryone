package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.TestCases;

public class Utils {

  public static String DEFAULT_TEST_SUITE = "HEARTBEAT";
  private static String defaultPropFile = Constants.CONF_PATH + Constants.DEFAULT_PROPERTY_FILE + Constants.PROPERTY_SUFFIX;

  public static String getEnvironment(String env) {
    String sysEnv = System.getProperty(Constants.ENV_KEY);
    if (sysEnv != null)
      return sysEnv;
    else if (env != null)
      return env;
    else {
      String defaultPro = getPropertyValue(defaultPropFile, Constants.ENV_KEY);
      if (defaultPro != null)
        return defaultPro;
      else
        return Constants.DEFAULT_ENV;
    }
  }

  public static TestCases loadTestCases(String filename){
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    try{
      TestCases testCases = mapper.readValue(new File(filename), TestCases.class);
      System.out.println(testCases);
      return testCases;
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getPropertyValue(String propertyFile, String property) {
    Properties properties = loadProperties(propertyFile);
    if (properties != null) {
      return properties.getProperty(property);
    }
    return null;
  }

  private static Properties loadProperties(String propertyFile) {
    try {
      InputStream input = new FileInputStream(propertyFile);
      Properties prop = new Properties();
      prop.load(input);
      input.close();
      return prop;
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
