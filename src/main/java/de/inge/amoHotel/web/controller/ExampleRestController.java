package de.inge.amoHotel.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Meine View Page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div>Web Application. Passed parameter : </br>\n" +
                "        <span>Hallo Welt!</span>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
