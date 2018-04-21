package cn.like.study.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * @program: MyCode
 * @description: ehcache官方示例
 * @author: like
 * @create: 2018-04-16 23:00
 **/
public class Ehcache3API {
    public static void main(String[] args) {
        //创建缓存管理器，同时创建缓存实例preConfigured
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                                ResourcePoolsBuilder.heap(100))
                                .build())
                .build(true);
        //从缓存管理器中获取缓存实例
        Cache<Long, String> preConfigured
                = cacheManager.getCache("preConfigured", Long.class, String.class);
        preConfigured.put(1L,"li ke");
        System.out.println(preConfigured.get(1L));

        //不再创建cacheManager时创建缓存实例，单独创建
        Cache<Long, String> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                        ResourcePoolsBuilder.heap(100)).build());
        myCache.put(1L, "da one!");
        String value = myCache.get(1L);
        System.out.println(value);
        cacheManager.close();
    }
}
