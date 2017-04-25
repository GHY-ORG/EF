package cn.ghy.mappers;

import cn.ghy.models.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.JDBCType;

@Mapper
@Repository
public interface UserInfoMapper {

    @Results({ @Result(property = "status", column = "status", typeHandler = EnumOrdinalTypeHandler.class) })
    @Select("select id, username, password," +
            " gender, email, student_number as studentNumber," +
            " mobile, location, nickname, realname," +
            " idcard, lastmodified, status" +
            " from users where username = #{username}")
    UserInfo findByUsername(String username);


    @Select("")
    UserInfo findById(int id);
}
