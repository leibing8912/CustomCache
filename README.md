# CustomCache
一个基于xml格式数据保存的本地缓存方案,支持对象缓存兼容列表缓存,减弱对sqlite的依赖.

## How to Uses
example code:
```java
public class MainActivity extends AppCompatActivity {

    // 数据列表
    private ArrayList<Model> modelList;
    // 数据对象
    private Stu mStu;
    // 列表缓存
    private SpLocalCache<ListCache> listSpLocalCache;
    // 对象缓存
    private SpLocalCache<Stu> objectSpLocalCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化缓存
        listSpLocalCache = new SpLocalCache<>(ListCache.class, Model.class);
        objectSpLocalCache = new SpLocalCache<>(Stu.class);
        // 初始化数据源
        modelList = new ArrayList<>();
        mStu = new Stu();
        // 模拟数据
        // 列表
        Model mModel = new Model();
        mModel.setName("张三");
        mModel.setAge(18);
        mModel.setAddress("北京");
        modelList.add(mModel);

        mModel = new Model();
        mModel.setName("李四");
        mModel.setAge(20);
        mModel.setAddress("深圳");
        modelList.add(mModel);

        mModel = new Model();
        mModel.setName("王五");
        mModel.setAge(25);
        mModel.setAddress("广州");
        modelList.add(mModel);

        // 对象
        mStu.setStuName("庾澄庆");
        mStu.setStuAge(49);
        mStu.setStuAddress("台湾");

        // 缓存List数据
        ListCache<Model> mListCache = new ListCache<>();
        mListCache.setObjList(modelList);

        // 缓存数据
        listSpLocalCache.save(this, mListCache);
        objectSpLocalCache.save(this, mStu);

        // 读取缓存数据
        listSpLocalCache.read(this, new SpLocalCache.LocalCacheCallBack() {
            @Override
            public void readCacheComplete(Object obj) {
                System.out.println("---------------------------list cache----------------------------------");
                System.out.println("dddddddddddddddddd obj = " + obj);
                if (obj != null){
                    ListCache<Model> mReadCache = (ListCache<Model>) obj;
                    if (mReadCache != null){
                        ArrayList<Model> modelArrayList = mReadCache.getObjList();
                        for(int i=0;i<modelArrayList.size();i++){
                            System.out.println("ddddddddddddd model[" + i + "].name = " + modelArrayList.get(i).getName());
                            System.out.println("ddddddddddddd model[" + i + "].age = " + modelArrayList.get(i).getAge());
                            System.out.println("ddddddddddddd model[" + i + "].address = " + modelArrayList.get(i).getAddress());
                        }
                    }
                }
            }
        });
    
        objectSpLocalCache.read(this, new SpLocalCache.LocalCacheCallBack() {
            @Override
            public void readCacheComplete(Object obj) {
                System.out.println("---------------------------object cache----------------------------------");
                System.out.println("dddddddddddddddddd obj = " + obj);
                if (obj != null){
                    Stu stu = (Stu) obj;
                    System.out.println("ddddddddddddd stu.name = " + stu.getStuName());
                    System.out.println("ddddddddddddd stu.age = " + stu.getStuAge());
                    System.out.println("ddddddddddddd stu.address = " + stu.getStuAddress());
                }
            }
        });
    }
    
```
### Dependencies
```java
buildscript {
  repositories {
     jcenter()
   }
}

dependencies {
    compile 'cn.jianke.customcache:app:1.0.1'
}
```

### License
Copyright 2016 leibing

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


