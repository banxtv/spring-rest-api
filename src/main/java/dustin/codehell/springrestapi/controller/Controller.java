package dustin.codehell.springrestapi.controller;

import dustin.codehell.springrestapi.services.FunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class Controller {

    private final FunService funService;

    @Autowired
    public Controller(FunService funService) {
        this.funService = funService;
    }

    @GetMapping("/hello")
    public String getControllerResult() {
        return funService.GetServiceResult();
    }
}
