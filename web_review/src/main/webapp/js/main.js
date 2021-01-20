$(function () {
    $.ajax({
        url:"../data/article.ok.json",
        type:"get",
        success:function (r) {
            if(r.ok){
                let content = '<ul>';
                //根据响应数据拼接文章字符串
                for(let a of r.data)
                content += '<li>';
                content += a.title;
                content += '</li>';

            }
        }
    })
})