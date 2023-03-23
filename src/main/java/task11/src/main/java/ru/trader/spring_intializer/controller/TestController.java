package ru.trader.spring_intializer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @RequestMapping("/test")
    public ResponseEntity getTest() {
        try{
            return ResponseEntity.ok("Сервер работает!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }

    }

}
