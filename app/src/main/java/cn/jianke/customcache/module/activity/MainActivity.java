package cn.jianke.customcache.module.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.ArrayList;
import cn.jianke.customcache.R;
import cn.jianke.customcache.data.ListCache;
import cn.jianke.customcache.data.SpLocalCache;
import cn.jianke.customcache.module.bean.Model;
import cn.jianke.customcache.module.bean.Stu;

/**
 * @className: MainActivity
 * @classDescription: 首页
 * @author: leibing
 * @createTime: 2016/08/26
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // 数据列表
    private ArrayList<Model> modelList;
    private ArrayList<Stu> stuList;
    // 数据
    private Model mModel;
    private Stu mStu;
    // 缓存对象
    private SpLocalCache<ListCache>  mSpLocalCache;
    private SpLocalCache<ListCache> lSpLocalCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化数据源
        modelList = new ArrayList<>();
        stuList = new ArrayList<>();
        // 模拟数据
        mModel = new Model();
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

        mStu = new Stu();
        mStu.setStuName("周杰伦");
        mStu.setStuAge(37);
        mStu.setStuAddress("台湾");
        stuList.add(mStu);

        mStu = new Stu();
        mStu.setStuName("那英");
        mStu.setStuAge(45);
        mStu.setStuAddress("沈阳");
        stuList.add(mStu);

        mStu = new Stu();
        mStu.setStuName("庾澄庆");
        mStu.setStuAge(49);
        mStu.setStuAddress("台湾");
        stuList.add(mStu);

        mStu = new Stu();
        mStu.setStuName("汪峰");
        mStu.setStuAge(42);
        mStu.setStuAddress("北京");
        stuList.add(mStu);

        // 初始化缓存对象
        mSpLocalCache = new SpLocalCache<>(ListCache.class, Model.class);
        lSpLocalCache = new SpLocalCache<>(ListCache.class, Stu.class);

        // 缓存List数据
        ListCache<Model> mListCache = new ListCache<>();
        mListCache.setObjList(modelList);
        ListCache<Stu> stuListCache = new ListCache<>();
        stuListCache.setObjList(stuList);

        // 缓存数据
        mSpLocalCache.save(this, mListCache);
        lSpLocalCache.save(this, stuListCache);
        // onClick
        findViewById(R.id.btn_turnto_model).setOnClickListener(this);
        findViewById(R.id.btn_turnto_stu).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_turnto_model:
                turnToOtherPages(ModelActivity.class);
                break;
            case R.id.btn_turnto_stu:
                turnToOtherPages(StuActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 跳转到其他页面
     * @author leibing
     * @createTime 2016/08/27
     * @lastModify 2016/08/27
     * @param pageClass 页面Activity类
     * @return
     */
    private void turnToOtherPages(Class pageClass){
        Intent intent = new Intent();
        intent.setClass(this, pageClass);
        startActivity(intent);
    }
}
