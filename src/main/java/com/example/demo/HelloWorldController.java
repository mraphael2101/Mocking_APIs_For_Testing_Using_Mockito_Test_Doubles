package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/greetings/{name}")
    public @ResponseBody Message greeting(@PathVariable String name) {
        return new Message(name);
    }

    @GetMapping("/greetings/")
    public @ResponseBody
    MessageStub stubGreetingExample() {
        return new MessageStub();
    }
}
