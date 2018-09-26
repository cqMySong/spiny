package com.gioov.spiny.common.email;

import com.gioov.spiny.system.entity.EmailEntity;
import com.gioov.spiny.system.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Component
public class ConsumeEmailQueue {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeEmailQueue.class);

    private static final int CORE_POOL_SIZE = 5;

    private static final int MAXIMUM_POOL_SIZE = CORE_POOL_SIZE * 3;

    /**
     * 当前线程数大于 corePoolSize、小于 maximumPoolSize 时，超出 corePoolSize 的线程数的生命周期
     */
    private static final long KEEP_ACTIVE_TIME = 200;

    /**
     * 设置时间单位，秒
     */
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    /**
     * 设置线程池缓存（阻塞）队列的排队策略为 FIFO（先进先出），并且指定缓存队列大小为 5
     */
    private static final BlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<Runnable>(CORE_POOL_SIZE);

    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        private final AtomicInteger integer = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "ThreadPool thread: " + integer.getAndIncrement());
        }
    };

    @Autowired
    private EmailService emailService;

    @PostConstruct
    public void startThread() {
        LOGGER.info("Email queue create.");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ACTIVE_TIME, TIME_UNIT, WORK_QUEUE, THREAD_FACTORY);

        executor.submit(new PollEmail(emailService));
        executor.submit(new PollEmail(emailService));
        executor.submit(new PollEmail(emailService));
        executor.submit(new PollEmail(emailService));
        executor.submit(new PollEmail(emailService));

    }

    public class PollEmail implements Runnable {

        EmailService emailService;

        private PollEmail(EmailService emailService) {
            this.emailService = emailService;
        }

        @Override
        public void run() {
            while (true) {

                try {
                    EmailEntity emailEntity = EmailQueue.getEmailQueue().consume();
                    if (emailEntity != null) {
                        emailService.send(emailEntity);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @PreDestroy
    public void destroyThread() {

        LOGGER.info("Email queue destroy.");

    }
}
