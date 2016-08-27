package cn.jianke.customcache.module.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import cn.jianke.customcache.R;
import cn.jianke.customcache.data.ListCache;
import cn.jianke.customcache.data.SpLocalCache;
import cn.jianke.customcache.module.adapter.StuAdapter;
import cn.jianke.customcache.module.bean.Stu;

public class StuActivity extends AppCompatActivity implements View.OnClickListener{
    // ListView
    private ListView cacheLv;
    // 适配器
    private StuAdapter cacheAdapter;
    // 数据源
    private ArrayList<Stu> mData;
    // 缓存对象
    private SpLocalCache<ListCache> mSpLocalCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        // FindView
        cacheLv = (ListView) findViewById(R.id.lv_show_cache);
        // 初始化缓存对象
        mSpLocalCache = new SpLocalCache<>(ListCache.class, Stu.class);
        // 初始化数据源
        mData = new ArrayList<>();
        // 初始化Adapter
        cacheAdapter = new StuAdapter(mData, StuActivity.this);
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
                mSpLocalCache.read(StuActivity.this, new SpLocalCache.LocalCacheCallBack() {
                    @Override
                    public void readCacheComplete(Object obj) {
                        if (obj != null) {
                            ListCache<Stu> mReadCache = (ListCache<Stu>) obj;
                            if (mReadCache != null){
                                ArrayList<Stu> modelArrayList = mReadCache.getObjList();
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
    public void updateUI(ArrayList<Stu> mData){
        if (cacheAdapter != null) {
            cacheAdapter.setData(mData);
            cacheAdapter.notifyDataSetChanged();
        }
    }
}
