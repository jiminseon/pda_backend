package com.example.record;

import lombok.Getter;
import lombok.Setter;

public class LombokDemo {
    public static void main(String[] args) {
        LL ll = new LL();
        ll.setA("ss");

    }
}

@Getter
@Setter
class LL {
    String a;
}
