package com.sloera.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tempService")
@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
public class TempService {

    public String test(String var1){
        return var1;
    }
}
