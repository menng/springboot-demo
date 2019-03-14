package org.springboot.demo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class CaffeineController {

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

    @RequestMapping("/listProvinces")
    public Object listProvinces() {
        return provinceCache.get("province", this::getAllProvinces);
    }

    @RequestMapping("/getProvinceById/{id}")
    public Object getProvinceById(@PathVariable("id") Integer id) {
        return provinceMapCache.get("province").get(id);
    }

    private Map<Integer, Province> getProvinceMap(String s) {
        return getAllProvinces("province").stream().
                collect(Collectors.toMap(Province::getId, a -> a));
    }

    private List<Province> getAllProvinces(String s) {
        return Arrays.asList(
                Province.builder().id(1).name("北京").name("我喜欢北京").build(),
                Province.builder().id(2).name("上海").name("上海是一座国际化大都市").build(),
                Province.builder().id(3).name("重庆").name("重庆是个美丽的城市").build());
    }
}

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class Province {

    private Integer id;

    private String name;

    private String desc;
}
