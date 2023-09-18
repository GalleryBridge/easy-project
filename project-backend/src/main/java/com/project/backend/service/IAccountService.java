package com.project.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.backend.entity.po.Account;
import com.project.backend.entity.vo.AccountVo;

import javax.servlet.http.HttpServletRequest;

public interface IAccountService extends IService<Account> {

    AccountVo accountLogin(String accountName, String accountPassword);

    public AccountVo getLoginAccountVo(Account account);
}
