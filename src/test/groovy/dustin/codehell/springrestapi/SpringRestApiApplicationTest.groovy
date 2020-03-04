package dustin.codehell.springrestapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import spock.lang.Specification

@SpringBootTest
class SpringRestApiApplicationTest extends Specification {

    @Autowired
    Environment env;

    def "Application is running"() {
        expect:
        env != null;
    }
}
