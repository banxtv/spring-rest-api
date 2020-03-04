package dustin.codehell.springrestapi.integrationtests

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

//@Profile("integration")
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest_Vertical_Integrational extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "Controller Returns Result"() {
        given: 'expected Result'
        def expected = 'Hello World Test'

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v1/hello"))
                .andReturn()
                .response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains "Hello World!"'
        result.contentAsString == expected
    }
}
