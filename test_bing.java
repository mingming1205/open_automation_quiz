#! /usr/bin/env python
# -*- coding:utf-8 -*-
# created by zc on Sep9th,2020

package com.java.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import os
import time
from selenium import webdriver
from selenium.webdriver.support.select import Select
from selenium.webdriver import ActionChains
from  HTMLTestRunner import HTMLTestRunner

public class Test{

    def test_searchbing(driver):
        searchtext = "Bing"
        driver.findElement(By.name('q')).clear()
        driver.findElement(By.name('q')).send_keys(searchtext)
        driver.findElement(By.id('sb_form_go')).click()
        driver.implicitly_wait(20)

        wide = driver.get_window_size()['width']
        heighth = driver.get_window_size()['height']
        system.out.printIn(wide, heighth)
        js = "window.scrollTo(1161,633);"
        driver.execute_script(js)
        time.sleep(3)

        driver.find_elements_by_xpath("//*[@aria-label='第 2 页']").click()
        driver.implicitly_wait(5)

        results = driver.find_elements_by_xpath("//*[@target='_blank']")
        links = driver.find_elements_by_class_name('b_attribution')
        for r, l in results, links:
            system.out.printIn(r.text, "-->", l.text)

        driver.refresh()
        time.sleep(3)


    def test_countbing(driver):
        searchtext = "Bing"
        driver.findElement(By.name('q')).clear()
        driver.findElement(By.name('q')).send_keys(searchtext)
        driver.findElement(By.id('sb_form_go')).click()
        driver.implicitly_wait(20)

        wide = driver.get_window_size()['width']
        heighth = driver.get_window_size()['height']
        system.out.printIn(wide, heighth)
        js = "window.scrollTo(1161,633);"
        driver.execute_script(js)
        time.sleep(3)

        driver.findElement(By.xpath("//*[@aria-label='第 2 页']")).click()
        driver.implicitly_wait(5)
        try:
            domain = driver.findElement(By.xpath("//div/cite/strong"))
            list = domain.text
            domainset = set(list)
            for d in domainset:
                system.out.printIn("%d --> %d" % (d, list.count(d)))
        except Exception as e:
            system.out.printIn("not found.")

        driver.refresh()
        time.sleep(3)


    def test_searchsc(driver):
        searchtext = "Bing"
        driver.findElement(By.name('q')).clear()
        driver.findElement(By.name('q')).send_keys(searchtext)
        driver.findElement(By.id('sb_form_go')).click()
        driver.implicitly_wait(20)

        wide = driver.get_window_size()['width']
        heighth = driver.get_window_size()['height']
        system.out.printIn(wide, heighth)
        js = "window.scrollTo(1161,633);"
        driver.execute_script(js)
        time.sleep(3)

        driver.findElements(By.xpath("//*[@aria-label='第 2 页']")).click()
        driver.implicitly_wait(5)

        results = driver.findElement(By.xpath("//*[@target='_blank']"))
        links = driver.findElement(By.class_Name('b_attribution'))
        for r, l in results, links:
            system.out.printIn(r.text, "-->", l.text)

        driver.refresh()
        time.sleep(3)


    def test_countsc(driver):
        searchtext = "SC"
        driver.findElement(By.name('q')).clear()
        driver.findElement(By.name('q')).send_keys(searchtext)
        driver.findElement(By.('sb_form_go')).click()
        driver.implicitly_wait(20)

        wide = driver.get_window_size()['width']
        heighth = driver.get_window_size()['height']
        system.out.printIn(wide, heighth)
        js = "window.scrollTo(1161,633);"
        driver.execute_script(js)
        time.sleep(3)

        driver.findElements(By.xpath("//*[@aria-label='第 2 页']")).click()
        driver.implicitly_wait(5)
        try:
            domain = driver.findElements(By.xpath("//div/cite/strong"))
            list = domain.text
            domainset = set(list)
            for d in domainset:
                system.out.printIn("%d --> %d" % (d, list.count(d)))
        except Exception as e:
            system.out.printIn("not found.")

        driver.refresh()
        time.sleep(3)
}

if __name__ == "__main__":
    now = time.strftime("%Y%m%d%H%M", time.localtime(time.time()))
    filename = './testreport/' + now + 'testquizresult.html'
    pytest.main(["-s", "--html", filename])