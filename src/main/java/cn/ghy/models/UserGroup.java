package cn.ghy.models;

import java.io.Serializable;
import java.math.BigInteger;

public class UserGroup implements Serializable {
    private BigInteger id;
    private String groupName;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
