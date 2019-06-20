package org.springboot.demo.caffeine;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author menng
 */
@Component
public class ProvinceCaffeineCache {

    private Cache<String, List<Province>> provinceCache = Caffeine.newBuilder()
            .initialCapacity(8)
            .maximumSize(32)
            .expireAfterAccess(1L, TimeUnit.MINUTES)
            .build();

    private LoadingCache<String, Map<Integer, Province>> provinceMapCache = Caffeine.newBuilder()
            .initialCapacity(8)
            .maximumSize(32)
            .expireAfterWrite(1L, TimeUnit.MINUTES)
            .build(this::getProvinceMap);

    private Map<Integer, Province> getProvinceMap(String s) {
        return getAllProvinces("province").stream().
                collect(Collectors.toMap(Province::getId, a -> a));
    }

    private List<Province> getAllProvinces(String s) {
        return Arrays.asList(
                Province.builder().id(1).name("北京").name("我喜欢北京").date(LocalDateTime.now()).build(),
                Province.builder().id(2).name("上海").name("上海是一座国际化大都市").date(LocalDateTime.now()).build(),
                Province.builder().id(3).name("重庆").name("重庆是个美丽的城市").date(LocalDateTime.now()).build());
    }

    public Province get(Integer s) {
        return provinceMapCache.get("province").get(s);
    }

    public List<Province> listProvince(String s) {
        return provinceCache.get(s, this::getAllProvinces);
    }
}
