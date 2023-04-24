package com.wztedu.spring.factory;

import com.wztedu.spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotao
 * @version 1.0
 * 静态工厂类-可以返回Monster
 */
public class MyStaticFactory {

    private static Map<String, Monster> monsterMap;

    // 使用 static 代码块进行初始化

    static {
        monsterMap = new HashMap<>();
        monsterMap.put("monster01", new Monster(100, "牛魔王", "芭蕉扇"));
        monsterMap.put("monster02", new Monster(200, "狐狸", "魅惑"));
    }

    // 提供一个方法, 返回 Monster 方法
    public static Monster getMonster(String key) {
        if (monsterMap.containsKey(key)) {
            return monsterMap.get(key);
        }
        return null;
    }

}
