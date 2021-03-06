package com.example.animals.dao;

import com.example.animals.mapper.UserMapper;
import com.example.animals.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/19
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public Integer addUser(User user){
        return userMapper.insert(user);
    }

    public Integer deleteUser(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public Integer updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User selectUser(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public User login(Long phoneNumber, String password) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("phoneNumber",phoneNumber)
                .andEqualTo("password",password);
        return userMapper.selectOneByExample(example);
    }

    public Integer selectUserByPhoneNumber(Long phoneNumber) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("phoneNumber",phoneNumber);
        return userMapper.selectCountByExample(example);
    }

    public User selectAccountByMark(Short mark) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("mark",mark);
        return userMapper.selectOneByExample(example);
    }

    public List<User> selectUserByIds(List<Long> userId) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andIn("id",userId);
        return userMapper.selectByExample(example);
    }

    public User findByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> findUserByKeyWord(String keyword) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andLike("name","%"+keyword+"%")
                .orLike("nickName","%"+keyword+"%");
        return userMapper.selectByExample(example);
    }

    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
