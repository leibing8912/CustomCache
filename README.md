# CustomCache
一个基于xml格式数据保存的本地缓存方案,支持对象缓存兼容列表缓存,减弱对sqlite的依赖.
# How to Uses
## if you need to use cache list,define this cache and init like this:
// define 

private SpLocalCache<ListCache>  mSpLocalCache;

// init

mSpLocalCache = new SpLocalCache<>(ListCache.class, Model.class);

in this code, we can find two parameter：ListCache.class and Model.class.

the first parameter shows this is a list cache, other shows the list need save what.

// save

mSpLocalCache.save(this, mListCache);

// read

mSpLocalCache.read(ModelActivity.this, new SpLocalCache.LocalCacheCallBack() {
                    @Override
                    public void readCacheComplete(Object obj) {
                        if (obj != null) {
                            ListCache<Model> mReadCache = (ListCache<Model>) obj;
                    }
                });
                
## if we do not need to cache list,only cache a object,we just to define and init like this:
// define

private SpLocalCache<Model>  mSpLocalCache;

// init
mSpLocalCache = new SpLocalCache<>(Model.class);

// save
mSpLocalCache.save(this, mModel);

// read

mSpLocalCache.read(ModelActivity.this, new SpLocalCache.LocalCacheCallBack() {
                    @Override
                    public void readCacheComplete(Object obj) {
                        if (obj != null) {
                            Model mReadCache = (Model) obj;
                    }
                });

#### if you find problems ,you just click [leibing@126.com]("leibing1989@126.com") to mail me.
#### if you Approve me,please start me.

