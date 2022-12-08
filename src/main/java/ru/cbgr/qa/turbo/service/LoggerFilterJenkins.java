package ru.cbgr.qa.turbo.service;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/** Класс, используется, чтобы отсеять все ненужные логи в консоли jenkins
 * указывается в конфигурации логера для jenkins */
public class LoggerFilterJenkins extends Filter<ILoggingEvent>{

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getMessage().contains("УСПЕХ")) {
            return FilterReply.ACCEPT;
        } else if (event.getMessage().contains("НЕУДАЧА")) {
            return FilterReply.ACCEPT;
        } else if (event.getMessage().contains("СОБЫТИЕ")) {
            return FilterReply.ACCEPT;
        } else if (event.getMessage().contains("[Configuration]")) {
            return FilterReply.DENY;
        } else {
            return FilterReply.DENY;
        }
    }
}
