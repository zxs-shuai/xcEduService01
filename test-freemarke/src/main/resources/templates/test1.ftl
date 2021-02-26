<!DOCTYPE html>
<html>
<head>
    <meta charset="utf‐8">
    <title>Hello World!</title>
</head>
<body>
Hello ${name}!
输出stu1的学生信息：<br/>
姓名：${stuMap['stu1'].name}<br/>
年龄：${stuMap['stu1'].age}<br/>
输出stu1的学生信息：<br/>
姓名：${stuMap.stu1.name}<br/>
年龄：${stuMap.stu1.age}<br/>
遍历输出两个学生信息：<br/>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>
    <#list stuMap?keys as k>
        <tr>
            <td>${k_index + 1}</td>
            <td>${stuMap[k].name}</td>
            <td>${stuMap[k].age}</td>
            <td >${stuMap[k].mondy}</td>
        </tr>
    </#list>
</table>

<br>
遍历输出两个学生信息999：<br/>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>
<#--    判断stus是否存在-->
    <#if stus??>

    <#list stus  as stu>
        <tr>
            <td>${stu_index + 1}</td>
            <td <#if stu.name =='小明'>style="background:red;"</#if>>${stu.name}</td>
            <td>${stu.age}</td>
            <td <#if stu.mondy gt 300>style="background: red" </#if>  >${stu.mondy}</td>
        </tr>
    </#list>

    </#if>
</table>
</body>
</html>