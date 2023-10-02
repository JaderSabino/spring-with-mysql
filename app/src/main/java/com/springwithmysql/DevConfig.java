package com.springwithmysql;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Profile("dev")
public class DevConfig implements ConfigInterface{
    @Override
    public void run() {
        Logger logger = Logger.getLogger(DevConfig.class.getName());
        logger.info("Rodando ambiente DEV");
    }
}
