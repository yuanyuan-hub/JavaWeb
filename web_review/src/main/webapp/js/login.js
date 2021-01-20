function login(form) {
    //校验用户名密码，
    if(form.oninvalid){//校验不通过，提示、不提交
        // alert("用户名为空")
        return false;
    }
    /**
     * ajax请求，需要抓包查看内容
     * 1.请求：url,method,Content-Type(请求数据类型)，data（请求数据）
     * 2.响应：
     */

    $.ajax({
        // url: "../data/login.ok.json",//静态json文件模拟后端servlet返回
        url: "../data/login.error.json",//静态json文件模拟后端servlet返回
        type: "POST",
        success: function (r) {
            if(r.ok){//r={ok: true}
                //登录操作，用户名密码校验通过
               // alert("登录成功，跳转页面")
                $("#login_error").hide();
                //相对路径写法，是以引入js的html文件作业相对路径的参照点
                window.location.href = "main.html";
            }else{//r={ok:false, code: xxx, msg: xxx}
                // alert("错误码："+r.code+"\n错误消息："+r.msg)
                $("#login_error").html(r.msg);
                $("#login_error").show();
            }
        }
    })
    return false;
}