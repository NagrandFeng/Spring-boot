package demo;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Created by Administrator on 2016/7/26.
 */
@SpringBootApplication
public class Appboot {
    private static Logger logger = Logger.getLogger(Appboot.class);

    public static void main(String[] args) {
        SpringApplication.run(Appboot.class,args);
        logger.info("============= SpringBoot Start Success =============");
    }
}
