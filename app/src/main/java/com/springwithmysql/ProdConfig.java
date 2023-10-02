package com.springwithmysql;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Profile("prod")
public class ProdConfig implements ConfigInterface{
    @Override
    public void run() {
        Logger logger = Logger.getLogger(ProdConfig.class.getName());
        logger.info("Rodando ambiente PROD");
    }
}
