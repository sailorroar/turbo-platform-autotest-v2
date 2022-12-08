package ru.cbgr.qa.turbo.service;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Slf4j
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
//            log.error("Тест завершился неудачно, повторная попытка запуска!");
            return true;
        }
//        log.error("!!! ТЕСТ ЗАВЕРШЕН НЕУДАЧНО ПОСЛЕ " + retryCount + " ПОПЫТОК !!!");
        return false;
    }
}
