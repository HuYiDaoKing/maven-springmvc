package service;

import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/10/9.
 */

@Service
public class HelloService {
    public String sayHello(String name) {
        return "hello:" + name;
    }
}
