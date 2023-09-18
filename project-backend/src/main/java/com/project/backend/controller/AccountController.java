package com.project.backend.controller;

import com.project.backend.entity.po.Account;
import com.project.backend.entity.vo.AccountVo;
import com.project.backend.service.IAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户接口
 */

@RestController
@RequestMapping("auth/api")
public class AccountController {

    @Resource
    private IAccountService accountService;

    @PostMapping
    public AccountVo userLogin(String accountName,String account_passwrod){
        AccountVo accountVo = accountService.accountLogin(accountName, account_passwrod);
        return accountVo;
    }

}
