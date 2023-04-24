package com.wztedu.spring.factory;

import com.wztedu.spring.bean.Monster;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotao
 * @version 1.0
 * 是一个 FactionBean
 */
public class MyFactionBean implements FactoryBean<Monster> {

    // 这个 key 就是配置时候指定要获取的对象对应的 key
    private String key;
    private Map<String, Monster> monster_map;

    {
        monster_map = new HashMap<>();
        monster_map.put("monster03", new Monster(30000, "牛魔王~~", "芭蕉扇"));
        monster_map.put("monster04", new Monster(40000, "狐狸~~", "魅惑"));
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public Monster getObject() throws Exception {
        if (monster_map.containsKey(key)) {
            return monster_map.get(key);
        }
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return Monster.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
