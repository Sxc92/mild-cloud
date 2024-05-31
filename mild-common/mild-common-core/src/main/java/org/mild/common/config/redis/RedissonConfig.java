package org.mild.common.config.redis;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import lombok.RequiredArgsConstructor;
import org.mild.common.enums.RedisModeEnums;
import org.mild.common.handler.NameMapperHandler;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisException;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.CompositeCodec;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author 史偕成
 * @date 2024/05/30 21:28
 **/
@Configuration
@RequiredArgsConstructor
public class RedissonConfig {


    private final RedissonProperties redissonProperties;

    private final ObjectMapper objectMapper;

    @Bean
    public RedissonClient redissonClient() throws IOException {
        ObjectMapper om = objectMapper.copy();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的。序列化时将对象全类名一起保存下来
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        TypedJsonJacksonCodec jsonCodec = new TypedJsonJacksonCodec(Object.class, om);
        // 组合序列化 key 使用 String 内容使用通用 json 格式
        CompositeCodec codec = new CompositeCodec(StringCodec.INSTANCE, jsonCodec, jsonCodec);
        Config config = new Config();
        config.setThreads(redissonProperties.getThreads())
                .setLockWatchdogTimeout(redissonProperties.getLockWatchdogTimeout())
                .setNettyThreads(redissonProperties.getNettyThreads())
                // 缓存 Lua 脚本 减少网络传输(redisson 大部分的功能都是基于 Lua 脚本实现)
                .setUseScriptCache(true)
                .setCodec(codec);

        RedisModeEnums redisModeEnums = RedisModeEnums.get(redissonProperties.getMode());
        if (redisModeEnums == null) {
            throw new RedisException("redis mode is null");
        }
        switch (redisModeEnums) {
            case SINGLE -> singleConfig(config, redissonProperties);
            case CLUSTER -> clusterConfig(config, redissonProperties);
        }
        config.setCodec(codec);
        return Redisson.create(config);
    }

    /**
     * 单机配置
     *
     * @param config             配置
     * @param redissonProperties yml配置
     * @return Config
     */
    public static void singleConfig(Config config, RedissonProperties redissonProperties) {
        RedissonProperties.SingleServerConfig singleServerConfig = redissonProperties.getSingleServerConfig();
        if (ObjectUtil.isNull(singleServerConfig)) {
            throw new RedisException("Single server configuration is null");
        }
        // 使用单机模式
        config.useSingleServer()
                .setAddress(singleServerConfig.getAddress())
                .setDatabase(singleServerConfig.getDatabase())
//                   设置redis key前缀
                .setNameMapper(new NameMapperHandler(redissonProperties.getKeyPrefix()))
                .setTimeout(singleServerConfig.getTimeout())
                .setClientName(singleServerConfig.getClientName())
                .setIdleConnectionTimeout(singleServerConfig.getIdleConnectionTimeout())
                .setSubscriptionConnectionPoolSize(singleServerConfig.getSubscriptionConnectionPoolSize())
                .setConnectionMinimumIdleSize(singleServerConfig.getConnectionMinimumIdleSize())
                .setConnectionPoolSize(singleServerConfig.getConnectionPoolSize());
    }


    /**
     * 集群配置
     *
     * @param config             配置
     * @param redissonProperties yml配置
     * @return Config
     */
    public static void clusterConfig(Config config, RedissonProperties redissonProperties) {
        RedissonProperties.ClusterServersConfig clusterServersConfig = redissonProperties.getClusterServersConfig();
        if (ObjectUtil.isNull(clusterServersConfig)) {
            throw new RedisException("cluster server configuration is null");
        }
        // 使用集群模式
        config.useClusterServers()
                //设置redis key前缀
                .setNameMapper(new NameMapperHandler(redissonProperties.getKeyPrefix()))
                .setTimeout(clusterServersConfig.getTimeout())
                .setClientName(clusterServersConfig.getClientName())
                .setIdleConnectionTimeout(clusterServersConfig.getIdleConnectionTimeout())
                .setSubscriptionConnectionPoolSize(clusterServersConfig.getSubscriptionConnectionPoolSize())
                .setMasterConnectionMinimumIdleSize(clusterServersConfig.getMasterConnectionMinimumIdleSize())
                .setMasterConnectionPoolSize(clusterServersConfig.getMasterConnectionPoolSize())
                .setSlaveConnectionMinimumIdleSize(clusterServersConfig.getSlaveConnectionMinimumIdleSize())
                .setSlaveConnectionPoolSize(clusterServersConfig.getSlaveConnectionPoolSize())
                .setReadMode(clusterServersConfig.getReadMode())
                .setSubscriptionMode(clusterServersConfig.getSubscriptionMode());
    }
}
