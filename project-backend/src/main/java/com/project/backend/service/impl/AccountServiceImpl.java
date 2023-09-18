package com.project.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.backend.controller.common.ErrorCode;
import com.project.backend.entity.po.Account;
import com.project.backend.entity.vo.AccountVo;
import com.project.backend.exception.BusinessException;
import com.project.backend.mapper.AccountMapper;
import com.project.backend.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import com.project.backend.utils.Constant;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    //  盐值 混淆密码
    private static final String SALT = "Laidor";
    @Override
    public AccountVo accountLogin(String accountName, String accountPassword /*HttpServletRequest request*/) throws BusinessException {
        AccountVo accountVo = new AccountVo();
        //  加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + accountPassword).getBytes());
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accountName",accountName);
        queryWrapper.eq("accountPassword",accountPassword);
        Account account = this.baseMapper.selectOne(queryWrapper);
        if (account == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在或密码错误");
        }
        //  记录用户的登录状态
//        request.getSession().setAttribute(Constant.USER_LOGIN_STATE,account);
        return getLoginAccountVo(account);
    }


    @Override
    public AccountVo getLoginAccountVo(Account account) {
        if (account == null) {
            return null;
        }
        AccountVo loginAccountVo = new AccountVo();
        BeanUtils.copyProperties(account, loginAccountVo);
        return loginAccountVo;
    }

}
