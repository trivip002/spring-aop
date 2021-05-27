package com.example.demo;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Test
    public void solution1() {
        var n = 3;
        var a = new int[]{1, 2, 1};
        var b = new int[]{2, 3, 3};
        var c = new int[a.length][2];
        for (var i = 0; i < a.length; i++) {
            c[i] = new int[]{a[i], b[i]};
        }
        var result = new int[0][];
        for (var i = 1; i <= n; i++) {
            for (var j = 0; j < c.length; j++) {
                if ((c[j][0] == i && c[j][1] == i + 1) || (c[j][1] == i && c[j][0] == i + 1)) {
                    result = ArrayUtils.add(result, c[j]);
                    c = ArrayUtils.removeElement(c, c[j]);
                    j--;
                } else if (c[j][0] == i || c[j][1] == i) {
                    c = ArrayUtils.removeElement(c, c[j]);
                    j--;
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
    }

}
