package com.serenitydojo.assertiondemo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenAddingNumbers {

    @Test
    public void shouldAddTwoIntegersCorrectly(){

        int a = 1;
        int b = 2;

        int sum = a +b;

       // Assert.assertEquals(4,sum); // Junit assertion - Expected & actual

        assertThat(sum).isEqualTo(3) ;// assertJ Core - actual & Expected
    }
}
