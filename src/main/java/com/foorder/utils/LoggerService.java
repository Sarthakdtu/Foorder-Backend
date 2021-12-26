package com.foorder.utils;
import com.foorder.FoorderApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    private static Logger logger = LoggerFactory.getLogger(FoorderApplication.class);

    public static void info(String log){
        logger.info(log);
    }

    public static void error(String log){
        logger.error(log);
    }

    public static void debug(String log){
        logger.debug(log);
    }


}