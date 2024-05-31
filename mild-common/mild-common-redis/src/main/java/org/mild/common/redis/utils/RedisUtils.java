package org.mild.common.redis.utils;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.client.RedisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * redis操作工具
 *
 * @author 史偕成
 * @date 2024/05/30 19:38
 **/
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RedisUtils {

    private final RedissonClient redissonClient;

    /*****************************字符串操作************************************/
    /**
     * 塞入值
     *
     * @param k 键
     * @param v 值
     */
    public void setStr(String k, String v) {
        RBucket<Object> bucket = redissonClient.getBucket(k);
        bucket.set(v);
    }

    /**
     * 字符串获取值
     *
     * @param k 键
     * @return
     */
    public String getStr(String k) {
        RBucket<Object> bucket = redissonClient.getBucket(k);
        return convertVal(bucket.get(), String.class);
    }


    /**
     * 根据Key 获取值。请注意，返回的值类型由调用者指定，减少了类型转换的风险。
     * 该方法会优雅地处理异常和空值情况。
     *
     * @param clazz 期望的返回类型
     * @param <T>   泛型参数，指定返回值类型
     * @return 获取到的值，如果为null且没有异常，则返回null。如果发生异常，则抛出运行时异常。
     */
    public static <T> T convertVal(Object obj, Class<T> clazz) {
        try {
            if (obj != null && !clazz.isAssignableFrom(obj.getClass())) {
                // 如果获取的值类型与期望类型不匹配，则抛出运行时异常
                throw new RuntimeException("Value type mismatch. Expected: " + clazz.getSimpleName() + ", found: " + obj.getClass().getSimpleName());
            }
            // 安全地转换类型
            return clazz.cast(obj);
        } catch (Exception e) {
            // 处理Redis操作过程中可能抛出的异常
            // 根据具体情况，这里可以选择记录日志、重试或其他错误处理策略
            // 为了简化示例，这里直接抛出运行时异常
            throw new RuntimeException("Error retrieving value from Redis for key: ", e);
        }
    }
}
