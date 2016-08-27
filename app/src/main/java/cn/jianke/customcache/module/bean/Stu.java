package cn.jianke.customcache.module.bean;

import java.io.Serializable;

/**
 * @className: Stu
 * @classDescription: 测试实体
 * @author: leibing
 * @createTime: 2016/08/27
 */
public class Stu implements Serializable{
    // 序列化UID 当需要反序列化的时候,此UID必须要.
    private static final long serialVersionUID = -2468652259166571739L;

    // 名称
    private String stuName;
    // 年龄
    private int stuAge;
    // 地址
    private String stuAddress;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }
}
