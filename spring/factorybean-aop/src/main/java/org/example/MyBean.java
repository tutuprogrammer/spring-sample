package org.example;

import org.springframework.stereotype.Component;

class MyBean {
    private String name;

    public String getName() {
        System.out.println("execute MyBean#getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
