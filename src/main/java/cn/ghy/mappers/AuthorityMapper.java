package cn.ghy.mappers;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.ghy.models.Authority;

@Mapper
@Repository
public interface AuthorityMapper {

    @Select("select id, authority_name as authorityname, description" + " from authorities where id in "
            + "(select authority_id from usergroup_authority where usergroup_id in "
            + "(select usergroup_id from usergroup_member where user_id = #{userId}) )  ")
    List<Authority> getAuthorityByUserId(BigInteger userId);
}
