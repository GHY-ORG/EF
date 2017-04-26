package cn.ghy.apicontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ghy.mappers.UserInfoMapper;
import cn.ghy.models.UserInfo;

@RestController
@RequestMapping(path = "/api/user")
public class UserApiController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 通过用户 username 获取用户基本信息接口
     * 
     * @param username
     * @return UserInfo
     */
    @RequestMapping(path = "/{username}", method = { RequestMethod.GET })
    public UserInfo getUserByUsername(@PathVariable String username) {
        UserInfo result = userInfoMapper.findByUsername(username);
        return result;
    }

    @RequestMapping(path = "/", method = { RequestMethod.POST })
    public void addUser(@PathVariable UserInfo updateUserInfo) {

    }

    @RequestMapping(path = "/", method = { RequestMethod.PUT })
    public void updateUser(@PathVariable UserInfo updateUserInfo) {

    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.DELETE })
    public void deleteUser(@PathVariable String id) {

    }

}
