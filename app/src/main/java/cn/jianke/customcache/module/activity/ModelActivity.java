package cn.jianke.customcache.module.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import cn.jianke.customcache.R;
import cn.jianke.customcache.data.ListCache;
import cn.jianke.customcache.data.SpLocalCache;
import cn.jianke.customcache.module.adapter.ModelAdapter;
import cn.jianke.customcache.module.bean.Model;

/**
 * @className: ModelActivity
 * @classDescription: 读取缓存的页面
 * @author: leibing
 * @createTime: 2016/08/26
 */
public class ModelActivity extends AppCompatActivity implements View.OnClickListener{
    // ListView
    private ListView cacheLv;
    // 适配器
    private ModelAdapter cacheAdapter;
    // 数据源
    private ArrayList<Model> mData;
    // 缓存对象
    private SpLocalCache<ListCache> mSpLocalCache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        // FindView
        cacheLv = (ListView) findViewById(R.id.lv_show_cache);
        // 初始化缓存对象
        mSpLocalCache = new SpLocalCache<>(ListCache.class, Model.class);
        // 初始化数据源
        mData = new ArrayList<>();
        // 初始化Adapter
        cacheAdapter = new ModelAdapter(mData, ModelActivity.this);
        // 绑定ListView
        cacheLv.setAdapter(cacheAdapter);
        // onClick
        findViewById(R.id.btn_read_cache).setOnClickListener(this);
        findViewById(R.id.btn_clear_data).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_read_cache:
                // 读取缓存数据
                mSpLocalCache.read(ModelActivity.this, new SpLocalCache.LocalCacheCallBack() {
                    @Override
                    public void readCacheComplete(Object obj) {
                        if (obj != null) {
                            ListCache<Model> mReadCache = (ListCache<Model>) obj;
                            if (mReadCache != null){
                                ArrayList<Model> modelArrayList = mReadCache.getObjList();
                                if (modelArrayList != null){
                                    mData = modelArrayList;
                                    // 更新UI
                                    updateUI(mData);
                                }
                            }
                        }else {
                            System.out.println("dddddddddddddddddddd 缓存为空,请检查!");
                        }
                    }
                });
                break;
            case R.id.btn_clear_data:
                mData.clear();
                // 更新UI
                updateUI(mData);
                break;
            default:
                break;
        }
    }

    /**
     * 更新UI
     * @author leibing
     * @createTime 2016/08/27
     * @lastModify 2016/08/27
     * @param mData 数据源
     * @return
     */
    public void updateUI(ArrayList<Model> mData){
        if (cacheAdapter != null) {
            cacheAdapter.setData(mData);
            cacheAdapter.notifyDataSetChanged();
        }
    }
}
