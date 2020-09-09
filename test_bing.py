#! /usr/bin/env python
#-*- coding:utf-8 -*-
#created by zc on Sep9th,2020


import os
import time
import pytest
from selenium import webdriver
from selenium.webdriver.support.select import Select
from selenium.webdriver import ActionChains
from  HTMLTestRunner import HTMLTestRunner


def test_searchbing(driver):
    searchtext = "Bing"
    driver.find_element_by_name('q').clear()
    driver.find_element_by_name('q').send_keys(searchtext)
    driver.find_element_by_id('sb_form_go').click()
    driver.implicitly_wait(20)

    wide = driver.get_window_size()['width']
    heighth = driver.get_window_size()['height']
    print(wide, heighth)
    js = "window.scrollTo(1161,633);"
    driver.execute_script(js)
    time.sleep(3)
    
    driver.find_elements_by_xpath("//*[@aria-label='第 2 页']").click()
    driver.implicitly_wait(5)
    
    results = dr.find_elements_by_xpath("//*[@target='_blank']")
    links = dr.find_elements_by_class_name('b_attribution')
    for r,l in results,links:
        print(r.text,"-->",l.text)
        
    driver.refresh()
    time.sleep(3)  
            
def test_countbing(driver):
    searchtext = "Bing"
    driver.find_element_by_name('q').clear()
    driver.find_element_by_name('q').send_keys(searchtext)
    driver.find_element_by_id('sb_form_go').click()
    driver.implicitly_wait(20)

    wide = driver.get_window_size()['width']
    heighth = driver.get_window_size()['height']
    print(wide, heighth)
    js = "window.scrollTo(1161,633);"
    driver.execute_script(js)
    time.sleep(3)
    
    driver.find_elements_by_xpath("//*[@aria-label='第 2 页']").click()
    driver.implicitly_wait(5)
    try:
        domain = driver.find_elements_by_xpath("//div/cite/strong")
        list = domain.text
        domainset = set(list)
        for d in domainset:
            print("%d --> %d" %(d,list.count(d)))
    except Exception as e:
        print("not found.")    

    driver.refresh()
    time.sleep(3)

def test_searchsc(driver):
    searchtext = "Bing"
    driver.find_element_by_name('q').clear()
    driver.find_element_by_name('q').send_keys(searchtext)
    driver.find_element_by_id('sb_form_go').click()
    driver.implicitly_wait(20)

    wide = driver.get_window_size()['width']
    heighth = driver.get_window_size()['height']
    print(wide, heighth)
    js = "window.scrollTo(1161,633);"
    driver.execute_script(js)
    time.sleep(3)
    
    driver.find_elements_by_xpath("//*[@aria-label='第 2 页']").click()
    driver.implicitly_wait(5)
    
    results = dr.find_elements_by_xpath("//*[@target='_blank']")
    links = dr.find_elements_by_class_name('b_attribution')
    for r,l in results,links:
        print(r.text,"-->",l.text)
        
    driver.refresh()
    time.sleep(3)  
    
def test_countsc(driver):
    searchtext = "SC"
    driver.find_element_by_name('q').clear()
    driver.find_element_by_name('q').send_keys(searchtext)
    driver.find_element_by_id('sb_form_go').click()
    driver.implicitly_wait(20)

    wide = driver.get_window_size()['width']
    heighth = driver.get_window_size()['height']
    print(wide, heighth)
    js = "window.scrollTo(1161,633);"
    driver.execute_script(js)
    time.sleep(3)
    
    driver.find_elements_by_xpath("//*[@aria-label='第 2 页']").click()
    driver.implicitly_wait(5)
    try:
        domain = driver.find_elements_by_xpath("//div/cite/strong")
        list = domain.text
        domainset = set(list)
        for d in domainset:
            print("%d --> %d" %(d,list.count(d)))
    except Exception as e:
        print("not found.")    

    driver.refresh()
    time.sleep(3)


if __name__=="__main__":
    now = time.strftime("%Y%m%d%H%M", time.localtime(time.time()))
    filename = './testreport/' + now + 'testquizresult.html'
    pytest.main(["-s", "--html", filename])

