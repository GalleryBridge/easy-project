package com.project.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.backend.entity.po.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
