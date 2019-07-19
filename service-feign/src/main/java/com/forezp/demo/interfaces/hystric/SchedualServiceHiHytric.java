package com.forezp.demo.interfaces.hystric;

import com.forezp.demo.interfaces.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHytric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
