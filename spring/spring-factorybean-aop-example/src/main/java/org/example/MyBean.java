package org.example;

import org.springframework.stereotype.Component;

class MyBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }

    public void exec() {
        System.out.println("execute MyBean#exec()");
    }
}
