#! /usr/bin/env python
#-*- coding:utf-8 -*-
# created by zc on Sep9th,2020

import os
import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains


@pytest.fixture(scope="session",autouse=True)
def driver():
    weburl = 'https://www.ianzhang.cn/bing/'
    global driver
    # driver = webdriver.Ie()
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get(weburl)
    return driver
    driver.implicitly_wait(10)

@pytest.fixture(scope="session",autouse=True)
def driver_close():
    yield driver
    driver.quit()