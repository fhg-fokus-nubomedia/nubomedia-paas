package org.project.openbaton.nubomedia.api.openshift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by maa on 26/09/2015.
 */
public class ConfigReader {

    private static Logger log = LoggerFactory.getLogger(ConfigReader.class);

    public static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        File f = new File("/etc/nubomedia/paas.properties");
        if (!f.exists()) {
            log.info("loading default properties file");
            properties.load(ConfigReader.class.getResourceAsStream("/paas.properties"));
        }
        else {
            log.info("loading properties from " + f.getAbsolutePath());
            properties.load(new FileInputStream(f));
        }
        log.debug("Loaded Properties: " + properties);

        return properties;
    }

}
