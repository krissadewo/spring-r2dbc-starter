package id.or.greenlabs.r2dbc.module.item.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

/**
 * @author ksadewo
 * @created 06/02/2023 - 2:38 PM
 */
@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
public class ApplicationTests {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApplicationTests.class);

        try {
            if (args.length > 0) { //activating profiles
                springApplication.setAdditionalProfiles(args);
            }

            springApplication.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
