package cn.ghy.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.springframework.stereotype.Repository;

import cn.ghy.models.UserInfo;

@Mapper
@Repository
public interface UserInfoMapper {

    @Results({ @Result(property = "status", column = "status", typeHandler = EnumOrdinalTypeHandler.class) })
    @Select("select id, username, password," + " gender, email, student_number as studentNumber,"
            + " mobile, location, nickname, realname," + " idcard, lastmodified, status"
            + " from users where username = #{username}")
    UserInfo findByUsername(String username);

    @Select("")
    UserInfo findById(int id);
}
