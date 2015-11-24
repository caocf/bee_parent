package com.bee.sms;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by suntongwei on 15/11/16.
 */
public class SMSCodeFactory implements Runnable {

    // CODE码保存缓存
    // key: 手机号
    // value: SMSCode
    private Map<String, SMSCode> codeCache = new ConcurrentHashMap<>();

    // 最大存放1000条code码
    private static final int MAX = 1000;

    // 1小时清除1次
    private static final long GC_CYCLE = 1l * 1000 * 60 * 60;

    // CODE有效时间15分钟
    private static final long EFF_TIME = 1l * 1000 * 60 * 15;

    // 创建单线程
    private Thread thread;

    // 上一次清理时间
    private long lastClearTime = 0;

    /**
     * 放入code
     *
     * @param code
     * @param phone
     */
    public void putCode(String code, String phone) {
        if (codeCache.size() >= MAX) {
            System.out.println("code cache size MAX.");
            clearCache();
        }
        codeCache.put(phone, new SMSCode(code, System.currentTimeMillis()));
    }

    /**
     * 获取code
     *
     * @param phone
     * @return
     */
    public String getCode(String phone) {
        if (codeCache.containsKey(phone)) {
            SMSCode code = codeCache.get(phone);
            if (System.currentTimeMillis() - code.createTime < EFF_TIME) {
                return code.code;
            } else {
                codeCache.remove(phone);
            }
        }
        return null;
    }

    /**
     * 清理code
     */
    private void clearCache() {
        long curTime = System.currentTimeMillis();
        lastClearTime = curTime;
        for (Iterator<String> it = codeCache.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            if (curTime - codeCache.get(key).createTime > EFF_TIME) {
                codeCache.remove(key);
            }
        }
    }

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                if (lastClearTime > 0) {
                    long t = System.currentTimeMillis() - lastClearTime;
                    if (t < GC_CYCLE) {
                        Thread.sleep(GC_CYCLE - t);
                    }
                }
                System.out.println("clear code cache start.");
                clearCache();
                Thread.sleep(GC_CYCLE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            thread.interrupt();
        } finally {
            System.out.println("clear code thread is exit.");
        }
    }

    /**
     * 初始化，启动线程
     */
    private void init() {
        thread = new Thread(this);
        thread.start();
    }

    /**
     *
     */
    class SMSCode {
        public String code;
        public Long createTime;
        public SMSCode(String c, Long t) {
            this.code = c;
            this.createTime = t;
        }
    }


    private static SMSCodeFactory ourInstance = new SMSCodeFactory();
    public static SMSCodeFactory getInstance() {
        return ourInstance;
    }
    private SMSCodeFactory() {
        init();
    }
}
