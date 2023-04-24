package com.wztedu.spring.factory;

import com.wztedu.spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

public class MyInstanceFactory {
    private Map<String, Monster> monster_Map;

    // 通过普通代码块进行初始化
    {
        monster_Map = new HashMap<>();
        monster_Map.put("monster03", new Monster(30000, "牛魔王~~", "芭蕉扇"));
        monster_Map.put("monster04", new Monster(40000, "狐狸~~", "魅惑"));
    }

    // 写一个方法返回 Monster 对象
    public Monster getMonster(String key) {
        if (monster_Map.containsKey(key)) {
            return monster_Map.get(key);
        }
        return null;
    }
}
