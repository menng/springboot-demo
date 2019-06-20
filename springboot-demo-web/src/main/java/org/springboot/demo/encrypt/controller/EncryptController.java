package org.springboot.demo.encrypt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springboot.demo.encrypt.annotation.RequestDecryptBody;
import org.springboot.demo.encrypt.annotation.ResponseEncryptBody;
import org.springboot.demo.encrypt.bean.DecryptParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EncryptController {

    @RequestMapping("/encrypt")
    @ResponseEncryptBody
    public Object encrypt(@RequestDecryptBody DecryptParam param) {
        return "success";
    }
}
