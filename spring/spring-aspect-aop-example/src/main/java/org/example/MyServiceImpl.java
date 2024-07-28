package org.example;

import org.springframework.stereotype.Service;

@Service("myService")
public class MyServiceImpl implements MyService{


    @Override
    public void execute() {
        System.out.println("execute MyServiceImpl#execute");
    }
}
