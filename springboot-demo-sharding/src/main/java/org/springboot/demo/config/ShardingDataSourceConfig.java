package org.springboot.demo.config;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

@Slf4j
@Configuration
@EnableConfigurationProperties(ShardingMasterSlaveConfig.class)
@MapperScan(basePackages = "org.springboot.demo.mapper")
public class ShardingDataSourceConfig {

    @Autowired(required = false)
    private ShardingMasterSlaveConfig shardingMasterSlaveConfig;

    private static final String MAPPER_LOCATION = "classpath:mapper/**.xml";

    @Bean("dataSource")
    public DataSource masterSlaveDataSource() throws SQLException {
        Map<String, DataSource> dataSourceMap = Maps.newHashMap();
        dataSourceMap.putAll(shardingMasterSlaveConfig.getDataSources());

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("city");
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id", new ModuloShardingTableAlgorithm()));

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, Maps.newHashMap(), new Properties());
        log.info("masterSlaveDataSource config complete");

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ShardingDataSourceConfig.MAPPER_LOCATION));

        return sessionFactory.getObject();
    }

    private TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("city");
        result.setActualDataNodes("ds_master.city");
        result.setKeyGeneratorColumnName("id");
        return result;
    }
}

@Slf4j
class ModuloShardingTableAlgorithm implements PreciseShardingAlgorithm {

    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        log.info("collection:" + JSON.toJSONString(collection) + ",preciseShardingValue:" + JSON.toJSONString(preciseShardingValue));
        return null;
    }
}