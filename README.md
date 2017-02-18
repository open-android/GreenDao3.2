GreenDao3.2

* Orm是对象与数据的映射，简单说就是让javabean和数据库表建立绑定关系。
GreenDao是对android原生SQLite的封装，GreenDao的特色是通过插件自动生成DAO层类。

* [配套视频](https://www.boxuegu.com/web/html/video.html?courseId=172&sectionId=8a9bdf305a3a4c00015a5008c0b900b0&chapterId=8a9bdf305a3a4c00015a5008fcca00b1&vId=8a9bdf305a3a4c00015a500a10a300b2&videoId=5665D92F3A2D1BFA9C33DC5901307461)

## 配置说明：

### 1.在project的build.gradle添加classpath，注意仓库是mavenCentral()

    classpath 'org.greenrobot:greendao-gradle-plugin:3.2.1'

### 2.在module的build.gradle中应用greendao并添加依赖
	apply plugin: 'org.greenrobot.greendao'
	compile 'org.greenrobot:greendao:3.2.0'

### 3.在module的build.gradle中android节点下配置

    /*针对greenDao的一些配置*/
    greendao {
        schemaVersion 1 //数据库版本号
        daoPackage 'com.heima.greendao.dao' //自动生成的工具类的包名
        targetGenDir 'src/main/java' //java路径
    }

 
### 需要的权限
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>

### 第一步：建立Orm关系。以Student 为例。
	@Entity
	public class Student {
	
	    @Id
	    private long id;
	    private String name;
	}
### 第二步：Rebuild工程，在daoPackage 下生成DaoMaster、DaoSession、StudentDao三个类。



### 第三步：通过DaoMaster获取Session对象。
	mDaoSession=mDaoMaster.newSession();
	再通过DaoSession.getDao()即可拿到StudentDao对象。

### 第四步：使用Dao层进行增删改查。

* 最后说明：GreenDao的特色是插件生成Dao类，因此必须配置正确，而数据库版本，表名等配置为自动生成，由greendao来维护。


* 详细的使用方法在DEMO里面都演示啦,如果你觉得这个库还不错,请赏我一颗star吧~~~

* 欢迎关注微信公众号

![](http://upload-images.jianshu.io/upload_images/4037105-8f737b5104dd0b5d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
