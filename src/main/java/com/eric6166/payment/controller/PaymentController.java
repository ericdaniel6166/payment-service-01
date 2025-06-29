package com.eric6166.payment.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        log.info("ping");
        return ResponseEntity.ok("pong payment-service-01");
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        log.info("test");
        Map<String, String> map = new HashMap<>();
        map.put(ZoneOffset.UTC.getId(), LocalDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.MICROS).toString());
        return ResponseEntity.ok(map);
    }


}
