package com.gioov.spiny.common.email;

import com.gioov.spiny.system.entity.EmailEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Component
public class EmailQueue {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailQueue.class);

    private static final int QUEUE_MAX_SIZE = 500;

    /**
     * 阻塞队列
     */
    private static BlockingQueue<EmailEntity> blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    private EmailQueue() {}

    private static class Singleton {

        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static EmailQueue emailQueue = new EmailQueue();
    }

    public static EmailQueue getEmailQueue() {
        return Singleton.emailQueue;
    }

    /**
     * 生产入队
     *
     * @param emailEntity EmailEntity
     * @throws InterruptedException
     */
    public void produce(EmailEntity emailEntity) throws InterruptedException {
        blockingQueue.put(emailEntity);
        LOGGER.info("add queue e={}", emailEntity);
    }

    /**
     * 消费出队
     *
     * @return EmailEntity
     * @throws InterruptedException
     */
    public EmailEntity consume() throws InterruptedException {
        return blockingQueue.take();
    }

    public int size() {
        return blockingQueue.size();
    }

}
