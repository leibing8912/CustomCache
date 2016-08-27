package cn.jianke.customcache.module.bean;

import java.io.Serializable;

/**
 * @className: Model
 * @classDescription: 测试实体
 * @author: leibing
 * @createTime: 2016/08/26
 */
public class Model implements Serializable{
    // 序列化UID 当需要反序列化的时候,此UID必须要.
    private static final long serialVersionUID = -3276096981990292013L;
    // 名称
    private String name;
    // 年龄
    private int age;
    // 家庭住址
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
