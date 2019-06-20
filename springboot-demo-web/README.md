## springboot web 项目
### Caffeine 
本地缓存框架

### FastJsonHttpMessageConverterConfig
[FastJsonHttpMessageConverterConfig.java](src/main/java/org/springboot/demo/config/FastJsonHttpMessageConverterConfig.java)

使用fastJson替换默认的HttpMessageConverter

### 自定义注解
#### 自定义参数注解
- 定义注解
- 编写参数注解解析器，实现`HandlerMethodArgumentResolver`
- 将自定义注解添加的Spring的参数解析器集合中
