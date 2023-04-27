package com.wztedu.spring.annotation;

import com.wztedu.spring.wztapplicationcontext.WztApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WztSpringApplicationContext 作用类似于Spring原生 ioc 容器
 *
 * @author xiaotao
 * @version 1.0
 */
public class WztSpringApplicationContext {
    private Class configClass;
    // ioc 我存放的就是通过反射创建的对象（基于注解的方式）
    private ConcurrentHashMap<String, Object> ioc =
            new ConcurrentHashMap<>();

    // 构造器
    public WztSpringApplicationContext(Class configClass) {
        this.configClass = configClass;
        // System.out.println("this.configClass= " + configClass);

        // 获取要扫描的包是什么
        // 1. 先得到 WztSpringConfig 配置的 @ComponentScan(value = "com.wztedu.spring.component")
        ComponentScan componentScan = (ComponentScan) this.configClass.getDeclaredAnnotation(ComponentScan.class);

        // 2. 通过 componentScan 的 value 得到要扫描的包
        String path = componentScan.value();
        System.out.println("要扫描的包= " + path);

        // 得到要扫描的包下的所有的资源（类 .class）
        // 1. 得到一个类的加载器
        ClassLoader classLoader =
                WztSpringApplicationContext.class.getClassLoader();

        // 一定要把 . 替换成 /
        path = path.replace(".", "/");
        // 2. 通过类的加载器获得到要扫描的包的资源 url => 类似一个路径
        URL resource =
                classLoader.getResource(path);

        // System.out.println("resource= " + resource);

        // 3. 将要加载的资源（.class）路径下的文件进行遍历 => io
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println("==================");
                System.out.println(f.getAbsolutePath());
                // D:\Desktop\Spring\hspSpring\spring-demo01\spring-demo01\out\production\spring-demo01\com\wztedu\spring\component\UserService.class
                // 获得到 com.wztedu.spring.component.UserService
                String fileAbsolutePath = f.getAbsolutePath();

                // 这里我们只处理 .class 文件
                if (fileAbsolutePath.endsWith(".class")) {

                    // 1. 先获取到类名
                    String className = fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf("\\") + 1, fileAbsolutePath.indexOf(".class"));
                    // 2. 获取类的完整的路径（全类名）
                    String classFullName = path.replace("/", ".") + "." + className;
                    // System.out.println("classFullName= " + classFullName);

                    // 3. 判断该类是不是需要注入到容器中，就看该类是不是有注解 @Component @Service ..
                    // 4. aClass.isAnnotationPresent(Component.class) 判断该类是否有 Component注解
                    try {
                        // 这时我们就得到了该类的 Class对象
                        Class<?> aClass = classLoader.loadClass(classFullName);
                        if (aClass.isAnnotationPresent(Component.class) ||
                                aClass.isAnnotationPresent(Controller.class) ||
                                aClass.isAnnotationPresent(Service.class) ||
                                aClass.isAnnotationPresent(Repository.class)) {

                            // 这里演示一个Component注解指定value, 分配id
                            if (aClass.isAnnotationPresent(Component.class)) {
                                // 获取到该注解
                                Component component = aClass.getDeclaredAnnotation(Component.class);

                                String value = component.value();
                                if (!"".endsWith(value)) {
                                    className = value;
                                }
                            }

                            // 这时就可以反射对象，并放入到容器中
                            Class<?> clazz = Class.forName(classFullName);
                            Object instance = clazz.newInstance();
                            // StringUtils StringUtils.uncapitalize(className) 将首字母小写
                            ioc.put(StringUtils.uncapitalize(className), instance);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 编写方法返回容器对象
    public Object getBean(String name) {
        return ioc.get(name);
    }
}
