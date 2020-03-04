package dustin.codehell.springrestapi.unittests.controller

import dustin.codehell.springrestapi.controller.Controller
import dustin.codehell.springrestapi.services.FunService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@WebMvcTest(Controller)
class ControllerTest_UnittestyMocked extends Specification {

    @SpringBean
    private FunService service = Mock(FunService)

    @Autowired
    private MockMvc mockMvc;

    def "Controller Returns Result"() {
        given: 'expected Result'
        def expected = 'Hello World!'

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v1/hello")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains "Hello World!"'
        result.contentAsString == expected

        and: 'service is called'
        1 * service.GetServiceResult() >> expected
    }
}
