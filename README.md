# AInject

模块|auto-inject
---|---
最新版本|[![Download](https://api.bintray.com/packages/iyifei/maven/auto-inject/images/download.svg)](https://bintray.com/iyifei/maven/auto-inject/_latestVersion)


> Android Studio 自动注入框架，可轻松实现跨Module代码注入过程。

# 基本用法
### step1: 添加依赖和配置
- project gradle file
```
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:x.x.x'
        //自动注入插件
        classpath "com.sjtu.yifei:auto-inject:1.0.1"
    }
}

```
- app gradle file
```
//在plugin:'com.android.application'下添加以下插件，用于自动注入
apply plugin: 'com.sjtu.yifei.autoinject'

implementation("com.sjtu.yifei:auto-inject:1.0.1") {
        transitive = false
}
```

### step2: 需要自动注入类的声明
```
@Inject //添加该注解即可
public class LoginManagerService implement ILoginManager {
    @Override
    void login(Activity activity) {
       Intent intent = new Intent(activity, LoginActivity.class);
       activity.startActivity(intent);
    }

    @Override
    User getUser(CallBack callback) {
        //...网络或者  或者  本地数据库 等回去异步返回或者同步返回结果

    }
}
```

### step3: 注入到该类，必须实现InjectContract接口，声明注入的方法
```java
   //必须实现InjectContract接口
   public class ServiceManager implements InjectContract {

   /**
     *
     * "@Inject" 注解标示的class 最终都会注入到该"@IMethod"注解标示过的方法中
     *  注："@IMethod"注解标示过的方法将由编译器自动注入实现代码，注入最终的代码如下如：
     *
     * @IMethod
     * public void iMethodName() {
     *       injectClass("injectClassName1")
     *       injectClass("injectClassName2")
     *       injectClass("injectClassName3")
     *       injectClass("injectClassName4")
     * }
     *
     * 用户可以在该方法中通过反射完成自己的业务需求
     * @param className class name
     */
    @IMethod
    public void startInject() {
       //todo
    }

    @Override
    public void injectClass(String serviceClassName) {
         //todo
    }

}
```

### step4: build 编译即可

# 欢迎 fork、issues

