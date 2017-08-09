package com.daimler.aync.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.task.pool")
public class TaskThreadPoolConfig {
    private int corePoolSize = 10;

    private int maxPoolSize = 15;

    private int keepAliveSeconds = 3;

    private int queueCapacity = 100;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }
}
