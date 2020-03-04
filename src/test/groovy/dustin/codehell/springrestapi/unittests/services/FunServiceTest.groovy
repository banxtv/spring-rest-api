package dustin.codehell.springrestapi.unittests.services

import dustin.codehell.springrestapi.services.FunService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class FunServiceTest extends Specification {

    @Autowired
    FunService sut;

    def "Service returns result"() {
        given: "a service"
        sut = new FunService();

        when: "service is called"
        def result = sut.GetServiceResult();

        then: "a result is returned"
        assert result != null

        and: "and contains specific content"
        assert result == "Hello World Test"
    }
}
