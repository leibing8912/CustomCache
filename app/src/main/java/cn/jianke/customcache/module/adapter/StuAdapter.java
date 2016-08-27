package cn.jianke.customcache.module.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import cn.jianke.customcache.R;
import cn.jianke.customcache.module.bean.Stu;
import cn.jianke.customcache.utils.StringUtil;

/**
 * @className: StuAdapter
 * @classDescription: 缓存数据适配器
 * @author: leibing
 * @createTime: 2016/08/27
 */
public class StuAdapter extends BaseAdapter{
    // 数据源
    private ArrayList<Stu> mData;
    // 布局
    private LayoutInflater inflater;

    /**
     *
     * @author leibing
     * @createTime 2016/08/26
     * @lastModify 2016/08/26
     * @param mData 数据源
     * @param context 上下文
     * @return
     */
    public StuAdapter(ArrayList<Stu> mData, Context context){
        this.mData = mData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData == null ?0:mData.size();
    }

    /**
     * 设置数据源
     * @author leibing
     * @createTime 2016/08/26
     * @lastModify 2016/08/26
     * @param mData 数据源
     * @return
     */
    public void setData(ArrayList<Stu> mData){
        this.mData = mData;
    }

    @Override
    public Object getItem(int i) {
        return mData == null ? null:mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = inflater.inflate(R.layout.item_cache, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        if (mData != null && i< mData.size())
            holder.updateStu(mData.get(i));

        return view;
    }

    static class ViewHolder{
        private TextView nameTv, ageTv, addressTv;
        public ViewHolder(View view){
            nameTv = (TextView) view.findViewById(R.id.tv_name);
            ageTv = (TextView) view.findViewById(R.id.tv_age);
            addressTv = (TextView) view.findViewById(R.id.tv_address);
        }
        public void updateStu(Stu stu){
            if (stu == null)
                return;
            if (StringUtil.isNotEmpty(stu.getStuName()))
                nameTv.setText("stuName:" + stu.getStuName());
            if (stu.getStuAge() != 0)
                ageTv.setText("stuAge:" + stu.getStuAge());
            if (StringUtil.isNotEmpty(stu.getStuAddress()))
                addressTv.setText("stuAddress:" + stu.getStuAddress());
        }
    }
}
