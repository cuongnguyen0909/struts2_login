<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <h1 style="weight: bold; color: brown">Đăng nhập thành công</h1>
        <h1>
            Chào mừng <s:property value="user.username" /> đã đến với chúng tôi. 
        </h1>
        <s:form action="logout">
            <s:submit value="Logout"/>
        </s:form>

    </body>
</html>
