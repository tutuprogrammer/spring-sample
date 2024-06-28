package org.example;

import org.springframework.stereotype.Component;

@Component
class MyBean {
    private String name;

    public MyBean() {
        this.name = "myBean";
    }

    public String getName() {
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
