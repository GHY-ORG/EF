package cn.ghy.models;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.math.BigInteger;

public class Authority implements GrantedAuthority, Serializable {

    private Integer id;
    private String authorityName;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public String getAuthority() {

        return getAuthorityName();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
