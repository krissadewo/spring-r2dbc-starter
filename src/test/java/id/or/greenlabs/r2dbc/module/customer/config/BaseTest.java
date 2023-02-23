package id.or.greenlabs.r2dbc.module.customer.config;

import id.or.greenlabs.r2dbc.common.DummyData;
import id.or.greenlabs.r2dbc.config.R2dbcConfig;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * @author ksadewo
 * @created 06/02/2023 - 2:39 PM
 */
@SpringBootTest(
    classes = {
        ApplicationTests.class
    }
)
@ContextConfiguration(classes = {
    DummyData.class
})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Import(R2dbcConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
public class BaseTest {

    @Autowired
    protected DummyData dummyData;
}
