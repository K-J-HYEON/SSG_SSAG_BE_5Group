package com.ssg.config;

import static ch.qos.logback.classic.Level.DEBUG;
import static ch.qos.logback.classic.Level.ERROR;
import static ch.qos.logback.classic.Level.INFO;
import static ch.qos.logback.classic.Level.OFF;
import static ch.qos.logback.classic.Level.WARN;
import static java.io.File.separator;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.filter.LevelFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.RollingPolicy;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.util.FileSize;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogBackConfig {

    @Value("${logs.config.filePath}")
    private String filePath;
    @Value("${logs.config.fileName}")
    private String fileName;

    // 공통 필드, 어펜더 별 설정을 달리 할 경우 지역변수로 변경
    private final LoggerContext logCtx = (LoggerContext) LoggerFactory.getILoggerFactory();

    private final String pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-3level %logger{5} - %msg %n";
    private final String fileNamePattern = ".%d{yyyy-MM-dd}_%i";
    private final String ext = ".log";
    private final String maxFileSize = "10MB";
    private final int maxHistory = 30;



    // 어펜더 목록, 다른 어펜더가 필요할 경우 추가
    private ConsoleAppender<ILoggingEvent> consoleAppender;
    private RollingFileAppender<ILoggingEvent> fileAppender;
    private RollingFileAppender<ILoggingEvent> filterAppender;


    @Bean
    public void logConfig() {
        consoleAppender = getLogConsoleAppender();
        fileAppender = getLogFileAppender();
        filterAppender = getFilterLogFileAppender();
        createLoggers();
    }

    private void createLoggers() {
        // 로거 이름, 로깅 레벨, 상위 로깅 설정 상속 여부
        createLogger("root", INFO, true);
        createLogger("com.ssg.ssg_be", INFO, false);
        createLogger("com.ssg.ssg_be.*..*Controller", DEBUG, false);
        createLogger("com.ssg.ssg_be.*..*Service", WARN, false);
        createLogger("com.ssg.ssg_be.*..*Repository", INFO, false);
        createLogger("com.ssg.config.*..*Security", DEBUG, false);
    }

    // 어펜더 추가 시 로거 등록 필요
    private void createLogger(String loggerName, Level logLevel, Boolean additive) {
        Logger logger = logCtx.getLogger(loggerName);
        logger.setAdditive(additive);
        logger.setLevel(logLevel);
        logger.addAppender(consoleAppender);
        logger.addAppender(fileAppender);
        logger.addAppender(filterAppender);
    }

    // 콘솔 로그 어펜더 생성
    private ConsoleAppender<ILoggingEvent> getLogConsoleAppender() {
        final String appenderName = "STDOUT";

        PatternLayoutEncoder consoleLogEncoder = createLogEncoder(pattern);
        return createLogConsoleAppender(appenderName, consoleLogEncoder);
    }

    // 롤링 파일 어펜더 생성
    private RollingFileAppender<ILoggingEvent> getLogFileAppender() {
        final String appenderName = "LOGS";

        final String logFilePath = filePath + separator + fileName;
        final String archiveLogFile = filePath + separator + appenderName  + separator + fileName + fileNamePattern;

        PatternLayoutEncoder fileLogEncoder = createLogEncoder(pattern);
        RollingFileAppender<ILoggingEvent> logFileAppender = createLogFileAppender(appenderName, logFilePath, fileLogEncoder);
        SizeAndTimeBasedRollingPolicy<RollingPolicy> logFilePolicy = createLogFilePolicy(maxFileSize, maxHistory, archiveLogFile, logFileAppender);

        logFileAppender.setRollingPolicy(logFilePolicy);
        logFileAppender.start();

        return logFileAppender;
    }

    // 롤링 파일 어펜더 생성 (필터 적용)
    private RollingFileAppender<ILoggingEvent> getFilterLogFileAppender() {
        final String appenderName = "ERROR";

        final String errorLogFilePath = filePath + separator + appenderName  + separator + fileName;
        final String errorLogFile = errorLogFilePath + fileNamePattern;

        PatternLayoutEncoder fileLogEncoder = createLogEncoder(pattern);
        RollingFileAppender<ILoggingEvent> logFileAppender = createLogFileAppender(appenderName, errorLogFilePath, fileLogEncoder);
        SizeAndTimeBasedRollingPolicy<RollingPolicy> logFilePolicy = createLogFilePolicy(maxFileSize, maxHistory, errorLogFile, logFileAppender);
        LevelFilter levelFilter = createLevelFilter(ERROR);

        logFileAppender.setRollingPolicy(logFilePolicy);
        logFileAppender.addFilter(levelFilter);
        logFileAppender.start();

        return logFileAppender;
    }

    private PatternLayoutEncoder createLogEncoder(String pattern) {
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(logCtx);
        encoder.setPattern(pattern);
        encoder.start();
        return encoder;
    }

    private ConsoleAppender<ILoggingEvent> createLogConsoleAppender(String appenderName, PatternLayoutEncoder consoleLogEncoder) {
        ConsoleAppender<ILoggingEvent> logConsoleAppender = new ConsoleAppender<>();
        logConsoleAppender.setName(appenderName);
        logConsoleAppender.setContext(logCtx);
        logConsoleAppender.setEncoder(consoleLogEncoder);
        logConsoleAppender.start();
        return logConsoleAppender;
    }

    private RollingFileAppender<ILoggingEvent> createLogFileAppender(String appenderName, String logFilePath, PatternLayoutEncoder logEncoder) {
        RollingFileAppender<ILoggingEvent> logFileAppender = new RollingFileAppender<>();
        logFileAppender.setName(appenderName);
        logFileAppender.setContext(logCtx);
        logFileAppender.setEncoder(logEncoder);
        logFileAppender.setAppend(true);
        logFileAppender.setFile(logFilePath + ext);
        return logFileAppender;
    }

    private SizeAndTimeBasedRollingPolicy<RollingPolicy> createLogFilePolicy(String maxFileSize, int maxHistory, String fileNamePattern, RollingFileAppender<ILoggingEvent> logFileAppender) {
        SizeAndTimeBasedRollingPolicy<RollingPolicy> logFilePolicy = new SizeAndTimeBasedRollingPolicy<>();
        logFilePolicy.setContext(logCtx);
        logFilePolicy.setParent(logFileAppender);
        logFilePolicy.setFileNamePattern(fileNamePattern + ext);
        logFilePolicy.setMaxHistory(maxHistory);
        logFilePolicy.setMaxFileSize(FileSize.valueOf(maxFileSize));
        logFilePolicy.start();
        return logFilePolicy;
    }

    private LevelFilter createLevelFilter(Level level) {
        LevelFilter levelFilter = new LevelFilter();
        levelFilter.setLevel(level);
        levelFilter.setOnMatch(FilterReply.ACCEPT);
        levelFilter.setOnMismatch(FilterReply.DENY);
        levelFilter.start();
        return levelFilter;
    }

}
