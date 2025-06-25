package com.eric6166.payment.controller;

import com.eric6166.base.utils.BaseMessageConst;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    private final MessageSource messageSource;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        log.info("ping");
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        log.info("test");
        Map<String, String> map = new HashMap<>();
        map.put(BaseMessageConst.MSG_INF_RESOURCE_CREATED,
                messageSource.getMessage(BaseMessageConst.MSG_INF_RESOURCE_CREATED, new String[]{"abc"}, LocaleContextHolder.getLocale()));
        map.put(BaseMessageConst.MSG_INF_RESOURCE_UPDATED,
                messageSource.getMessage(BaseMessageConst.MSG_INF_RESOURCE_UPDATED, new String[]{"abc"}, LocaleContextHolder.getLocale()));
        map.put(BaseMessageConst.MSG_ERR_RESOURCE_EXISTED,
                messageSource.getMessage(BaseMessageConst.MSG_ERR_RESOURCE_EXISTED, new String[]{"abc"}, LocaleContextHolder.getLocale()));
        map.put(ZoneOffset.UTC.getId(), LocalDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.MICROS).toString());
        return ResponseEntity.ok(map);
    }


}
