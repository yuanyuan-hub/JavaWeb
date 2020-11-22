function load() {
    alert("load OK");
}

$(function () {//jquery的方式：body加载完之后执行的代码
    alert("load OK");
    // jquery的ajax方法，异步的方式发起http网络请求
    // 方法的传入参数，是json格式对象
    let data = {
        username: "abc",
        password: "123"
    };
    $.ajax({
        type: "POST",//请求方法
        url: "data/login.json",//请求路径
        contentType: "application/json",//请求的数据类型，默认: "application/x-www-form-urlencoded"
        data: JSON.stringify(data),//请求数据，如果数据类型是json，需要将json对象转换为字符串
        success: function(r){
            alert(JSON.stringify(r));
        },error: function (jqXHR, textStatus, errorThrown) {
            console.log("jqXHR={\n"+jqXHR.status+",\n"+jqXHR.statusText+",\n"+jqXHR.responseText
                +"},\ntextStatus="+textStatus+",\nerrorThrown="+errorThrown);
        }
    });
    $.ajax({
        type: "POST",//请求方法
        url: "data/no.json",//请求路径
        contentType: "application/json",//请求的数据类型，默认: "application/x-www-form-urlencoded"
        data: JSON.stringify(data),//请求数据，如果数据类型是json，需要将json对象转换为字符串
        success: function(r){
            alert(JSON.stringify(r));
        },error: function (jqXHR, textStatus, errorThrown) {
            console.log("jqXHR={\n"+jqXHR.status+",\n"+jqXHR.statusText+",\n"+jqXHR.responseText
                +"},\ntextStatus="+textStatus+",\nerrorThrown="+errorThrown);
        }
    });
});