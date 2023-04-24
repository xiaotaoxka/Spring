package com.wztedu.spring.wztapplicationcontext;

import com.wztedu.spring.bean.Monster;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1. 这个程序用于实现 Spring 的一个简单容器机制
 * 2. 后面还会详细的实现
 * 3. 这里我们实现如何将 beans.xml 文件如何解析，并生成对象，放入容器中
 * 4. 提供一个方法 getBeans(id) 返回对应的对象
 *
 * @author xiaotao
 * @version 1.0
 */
public class WztApplicationContext {

    private ConcurrentHashMap<String, Object> singletonObject =
            new ConcurrentHashMap<>();

    // 构造器
    // 接收一个容器的配置文件 比如：beans.xml 该文件默认在 src 下
    public WztApplicationContext(String iocBeanXmlFile) throws Exception {

        // 1. 得到类的加载路径
        String path = this.getClass().getResource("/").getPath();

        // 2. 创建 Saxreader
        SAXReader saxReader = new SAXReader();

        // 3. 得到Document
        Document document = saxReader.read(new File(path + iocBeanXmlFile));

        // 4. 得到rootDocument
        Element rootElement = document.getRootElement();

        // 5. 得到第一个 bean-monster01
        Element bean = (Element) rootElement.elements().get(0);

        // 6. 获取到第一个 bean-monster01 的相关属性
        String id = bean.attributeValue("id");
        String classFullPath = bean.attributeValue("class");
        List<Element> property = bean.elements("property");

        // 获取
        Integer monsterId = Integer.parseInt(property.get(0).attributeValue("value"));
        String name = property.get(1).attributeValue("value");
        String skill = property.get(2).attributeValue("value");

        // 7. 使用反射创建对象
        Class<?> aClass = Class.forName(classFullPath);

        // 这里的 o 对象就是一个 Monster 对象
        Monster o = (Monster) aClass.newInstance();

        // 用反射赋值
        // Method[] declaredMethods = aClass.getDeclaredMethods();
        // for (Method declaredMethod : declaredMethods) {
        //     declaredMethod.invoke()
        // }

        o.setMonsterId(monsterId);
        o.setName(name);
        o.setSkill(skill);

        // 将创建好的对象放入 singletonObject
        singletonObject.put(id, o);
    }

    public Object getBean(String id) {
        if (singletonObject.contains(id)) {
            return singletonObject.get(id);
        }
        return null;
    }
}
