

String.prototype.replaceAll = function (oldStr, newStr) {
    return this.replace(new RegExp(oldStr, "gm"), newStr);
}
String.prototype.toJson = function () {
    return JSON.parse(this);
}
//字符串转为json  JSON.stringify(this)
//$("#State").is(":checked") 复选框是否被选中
//layer.confirm('保存成功！', { btn: ['确定'] }, function () {
//    window.location.href = "/Console/VideoInfo/VideoTypeList";
//});
