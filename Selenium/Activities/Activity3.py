from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Edge()

driver.get("https://training-support.net/webelements/login-form/")
print(driver.title)

driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
driver.find_element(By.XPATH, "//input[@id='password']").send_keys("password")

driver.find_element(By.XPATH, "//button[text()='Log in']").click()

time.sleep(30)
driver.quit()
