package org.mild.common.utils;

import cn.hutool.extra.spring.SpringUtil;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBatch;
import org.redisson.api.RBucket;
import org.redisson.api.RBucketAsync;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * redis操作工具
 *
 * @author 史偕成
 * @date 2024/05/30 19:38
 **/
@Component
public class RedisUtils {

    private static final RedissonClient CLIENT = SpringUtil.getBean(RedissonClient.class);

    /************************** 公共操作***********************************************/
    /**
     * 获取Bucket
     *
     * @param k 缓存的键值
     * @return
     */
    public static <T> RBucket<T> getBucket(final String k) {
        return CLIENT.getBucket(k);
    }


    /*****************************字符串操作************************************/
    /**
     * 缓存基础类型。这是一个泛型方法，用于缓存键值对。
     *
     * @param k   键，用于标识缓存中的数据。
     * @param v   值，与键对应的数据。
     * @param <T> 泛型参数，表示值的类型。
     */
    public static <T> void set(final String k, final T v) {
        set(k, v, false);
    }

    /**
     * 将键值对存储到Redis中。
     *
     * @param k         键，类型为String。
     * @param v         值，类型为泛型T。
     * @param isSaveTtl 是否保存时间戳，如果为true，则在设置值的同时保持原有的过期时间不变；
     *                  如果为false，则只设置值，不保留原有过期时间。
     */
    public static <T> void set(final String k, final T v, final boolean isSaveTtl) {
        RBucket<Object> bucket = getBucket(k);
        if (isSaveTtl) {
            try {
                bucket.setAndKeepTTL(v);
            } catch (Exception e) {
                long timeToLive = bucket.remainTimeToLive();
                set(k, v, Duration.ofMillis(timeToLive));
            }
        } else {
            bucket.set(v);
        }
    }

    /**
     * 将给定的键值对存储到Redis，并设置过期时间。
     *
     * @param k        键，类型为String。
     * @param v        值，类型为泛型T。
     * @param duration 过期时间，类型为Duration。
     *                 该方法没有返回值。
     */
    public static <T> void set(final String k, final T v, final Duration duration) {
        // 创建一个批处理对象
        RBatch batch = CLIENT.createBatch();
        // 获取异步操作的桶（Bucket），用于存储键值对
        RBucketAsync<T> bucket = batch.getBucket(k);
        // 异步设置值
        bucket.setAsync(v);
        // 异步设置过期时间
        bucket.expireAsync(duration);
        // 执行批处理操作
        batch.execute();
    }

    /**
     * 在指定的持续时间内，如果键不存在，则设置键值对。
     *
     * @param k        键，类型为String。
     * @param v        值，类型为泛型T。
     * @param duration 持续时间，指定键值对应该保持的有效期。
     * @param <T>      值的泛型类型。
     * @return 如果设置成功（即键不存在），返回true；如果键已存在，则不进行设置并返回false。
     */
    public static <T> boolean setIfAbsent(final String k, final T v, final Duration duration) {
        // 获取与键对应的桶（存储单元）
        RBucket<T> bucket = getBucket(k);
        // 在桶中设置值，如果键不存在，则返回true；否则，不进行设置并返回false
        return bucket.setIfAbsent(v, duration);
    }

    /**
     * 如果键已存在，则设置该键对应的值，并指定过期时间；如果键不存在，则不进行任何操作。
     *
     * @param k        键，用于标识存储的数据。
     * @param v        值，需要存储的数据。
     * @param duration 过期时间，指定该键值对的存续时间。
     * @param <T>      泛型参数，表示存储数据的类型。
     * @return 如果键已存在，并成功设置了值，则返回true；否则，返回false。
     */
    public static <T> boolean setIfExists(final String k, final T v, final Duration duration) {
        // 获取与键对应的桶（存储单元）
        RBucket<T> bucket = getBucket(k);
        // 在存储桶中设置值，如果键不存在则返回true，否则不设置并返回false
        return bucket.setIfExists(v, duration);
    }


    /**
     * 通过键获取对应的值。
     * 这个方法是泛型方法，能够根据键从某个存储中获取相应类型的值。
     *
     * @param k 键，用于从存储中获取值。
     * @return 返回与键对应的值。值的类型由调用时的上下文决定。
     */
    public static <T> T get(final String k) {
        // 获取与键对应的存储桶
        RBucket<T> rBucket = getBucket(k);
        // 从存储桶中获取值
        return rBucket.get();
    }


    /**
     * 根据Key 获取值。请注意，返回的值类型由调用者指定，减少了类型转换的风险。
     * 该方法会优雅地处理异常和空值情况。
     *
     * @param clazz 期望的返回类型
     * @param <T>   泛型参数，指定返回值类型
     * @return 获取到的值，如果为null且没有异常，则返回null。如果发生异常，则抛出运行时异常。
     */
    public static <T> T convertVal(T obj, Class<T> clazz) {
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
