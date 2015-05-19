package net.lee.bmobfileoperation;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by LEE on 2015/5/19.
 */
public class TestModel extends BmobObject {

    private String name;
    private int age;
    private String objectIdFromServer;
    private BmobFile icon;

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

    public BmobFile getIcon() {
        return icon;
    }

    public void setIcon(BmobFile icon) {
        this.icon = icon;
    }

    @Override
    public String getObjectId() {
        return objectIdFromServer;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectIdFromServer = objectId;
    }
}
