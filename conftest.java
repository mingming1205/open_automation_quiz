#! /usr/bin/env python
#-*-coding:utf-8-*-
# created by zc on Sep9th,2020
#安卓版app下载链接http://www.pc6.com/az/401579.html

package com.java.base;
package com.chengyifamily.patient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import os
import time
import random
from appium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

public class Test{

    @pytest.fixture(scope="session",autouse = True)
    def appdriver():
        print("Test Health starts...")
        PATH = lambda p:os.path.abspath(os.path.join(os.path.dirname(__file__),p))
        desired_caps={}
        desired_caps = {'platformName': 'Android',
                        'platformVersion': '6.0',
                        'deviceName': 'HUAWEI VNS-AL00',
                        'app': PATH(r"E:\apptest\OrangerFamily.apk"),
                        'appPackage': 'com.chengyifamily.patient',
                        'noReset': True,
                        'appActivity': 'com.chengyifamily.patient.SplashActivity',
                        'automationName':'uiautomator2',
                        'unicodeKeyboard': True,
                        'resetKeyboard': True,
                        'autoAcceptAlert': True,
                        # 'uiautomator2ServerLaunchTimeout':3000
                        }

        global driver
        driver = webdriver.Remote("http://localhost:4723/wd/hub", desired_caps)
        return driver
}

public class Test{

    @pytest.fixture(scope="function")

    def login(appdriver):
        print("Test health login starts...")
        try:
            login = "12345678907"
            pwd = "123456"
            appdriver.findElement(By.id("kw"))
            appdriver.findElement(By.id('account_edit')).clear()
            appdriver.findElement(By.id('account_edit')).send_keys(login)
            appdriver.findElement(By.id('password_edit')).clear()
            appdriver.findElement(By.id('password_edit')).send_keys(pwd)
            appdriver.findElement(By.id('login_button')).click()
            appdriver.implicitly_wait(5)

            def always_allow(appdriver, number=3):
                for i in range(number):
                    loc = ("xpath", "//*[@text='允许']")
                    try:
                        e = WebDriverWait(appdriver, 3, 0.1).until(EC.presence_of_element_located(loc))
                        e.click()
                    except:
                        pass
            always_allow(appdriver)
        except Exception as e:
            pass
        appdriver.implicitly_wait(2)

    @pytest.fixture(scope="function")
    def logout(appdriver):
        print("Testing Health ends.")
        appdriver.implicitly_wait(6)
        appdriver.findElement('my_center').click()
        appdriver.implicitly_wait(2)
        appdriver.findElement(By.name('text("设置")')).click()
        appdriver.findElement(By.id('exit_btn')).click()
        appdriver.findElement(By.id('android:id/button1')).click()
        appdriver.implicitly_wait(3)

    @pytest.fixture(scope="session",autouse= True)
    def close_appdriver():
        yield driver
        driver.close_app()
        driver.quit()
}



