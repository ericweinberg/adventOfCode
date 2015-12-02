package com.muddworks.adventOfCode;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    private static Logger logger = LoggerFactory.getLogger(Utils.class);

    public static String getInputString(String fileName) {
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(fileName);
        try {
            return IOUtils.toString(inputStream);
        } catch (IOException e) {
            logger.error("Exception converting to a string", e);
        }
        return null;
    }
}
