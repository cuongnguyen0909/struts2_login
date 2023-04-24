<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <s:if test="hasActionErrors()">
            <div class="error" style="color: red">
                <s:actionerror />
            </div>
        </s:if>
        <s:form action="login" method="post">
            <s:label value="Username" for="username"/>
            <s:textfield name="user.username"/>
            <s:label value="Password" for="user.password"/>
            <s:textfield  type="Password" name="user.password"/>
            <s:submit style="float:left" value="Login"/>
        </s:form>
        <s:form action="login2" method="post">
            <s:label value="Username" for="username"/>
            <s:textfield name="user.username"/>
            <s:label value="Password" for="user.password"/>
            <s:textfield  type="Password" name="user.password"/>
            <s:submit style="float:left" value="Login"/>
        </s:form>
        
    </body>
</html>
