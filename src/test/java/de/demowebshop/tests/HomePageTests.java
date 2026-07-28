package de.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {

        Assert.assertTrue(isHomeComponentPresent());//условие(элемент isHome...)=true

    }
}