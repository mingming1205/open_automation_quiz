#! /usr/bin/env python
# -*- coding:utf-8 -*-
# created by zc on Sep9th,2020

package com.java.base;
package com.chengyifamily.patient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import os,time
from appium import webdriver
from HTMLTestRunner import HTMLTestRunner
from selenium.common.exceptions import InvalidArgumentException
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common import exceptions as EX
from selenium.webdriver.common.action_chains import ActionChains


public class Testpatientinfo{

    def test_patinfologin(login):
        login

    def test_patinfosmoke(appdriver):
        appdriver.findElement(By.id('my_center')).click()
        appdriver.findElement(By.name('text("个人信息")')).click()
        appdriver.findElement(By.id('tv_smokevalue')).click()
        appdriver.findElement(By.name('text("吸烟")')).click()
        appdriver.findElement(By.id('android:id/button1')).click()

        width = appdriver.get_window_size()['width']
        height = appdriver.get_window_size()['height']
        number = 3
        for i in range(number):
            try:
                appdriver.findElement(By.id('et_smokecount')).click()
                break
            except Exception as e:
                appdriver.swipe(width / 2, height * 0.8, width / 2, height * 0.2)

        appdriver.findElement(By.id('et_smokecount')).clear()
        countvalue='2'
        yearvalue='3'
        appdriver.findElement(By.id('et_smokecount')).send_keys(countvalue)
        appdriver.findElement(By.id('et_smokeyear')).clear()
        appdriver.findElement(By.id('et_smokeyear')).send_keys(yearvalue)
        appdriver.findElement(By.id('bar_right_text')).click()
        appdriver.find_element_by_android_uiautomator('text("个人信息")').click()
        width = appdriver.get_window_size()['width']
        height = appdriver.get_window_size()['height']
        number = 3
        for i in range(number):
            try:
                appdriver.findElement(By.id('et_smokecount')).click()
                break
            except Exception as e:
                appdriver.swipe(width / 2, height * 0.8, width / 2, height * 0.2)

        assert appdriver.findElement(By.id('et_smokecount')).text==countvalue
        assert appdriver.findElement(By.id('et_smokeyear')).text==yearvalue
        system.out.printIn("吸烟的测试用例执行通过")
        appdriver.findElement(By.id('bar_right_text')).click()

    def test_patinfologout(logout):
        logout
}

if __name__ == '__main__':
    now = time.strftime("%Y%m%d%H%M%S",time.localtime(time.time()))
    filename = './testreport/' + now + 'testpersonalinfomationresult.html'
    pytest.main(["-q","--html",filename])