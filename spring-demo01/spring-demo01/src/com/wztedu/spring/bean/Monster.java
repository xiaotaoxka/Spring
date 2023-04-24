package com.wztedu.spring.bean;

/**
 * @author xiaotao
 * @version 1.0
 * JavaBean / Entity
 */
public class Monster {
    private Integer monsterId;
    private String name;
    private String skill;

    public Monster(Integer monsterId, String name, String skill) {
        // System.out.println("Monster有参构造器被调用");
        this.monsterId = monsterId;
        this.name = name;
        this.skill = skill;
    }

    // 无参构造器一定要给，Spring反射创建对象时需要使用
    public Monster() {

    }

    public void setMonsterId(Integer monsterId) {
        this.monsterId = monsterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getMonsterId() {
        return monsterId;
    }

    public String getName() {
        return name;
    }

    public String getSkill() {
        return skill;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterId=" + monsterId +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
