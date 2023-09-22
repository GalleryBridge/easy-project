const Mock = require ('mockjs')

const Random = Mock.Random

let Result = {
    code: 200,
    msg: '操作成功',
    data: null
}

Mock.mock('/captcha','get',() => {

    Result.data = {
        token: Random.string(32),
        captchaImg: Random.dataImage('80x36','p7m5w')
    }
    return Result
})

Mock.mock('/login','post',() => {

    //  无法在header中传入数据jwt


    return Result
})