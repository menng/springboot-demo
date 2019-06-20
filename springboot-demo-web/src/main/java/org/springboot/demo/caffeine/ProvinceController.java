package org.springboot.demo.caffeine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvinceController {

    @Autowired
    private ProvinceCaffeineCache provinceCache;

    @RequestMapping("/province/list")
    public Object listProvinces() {
        return provinceCache.listProvince("province");
    }

    @RequestMapping("/province/{id}")
    public Object getProvinceById(@PathVariable("id") Integer id) {
        return provinceCache.get(id);
    }
}
