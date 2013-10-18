<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
    <title></title>
</head>

<body>

<div style="padding:20px;">
    <g:link action="index">refresh</g:link> |
    <g:link controller="redirector" action="redirectBackToIndex">redirect from controller</g:link> |
    <g:link controller="redirector" action="redirectBackToIndexFromService">redirect from service</g:link> |
    <g:if test="${flash.message}">
        <div style="padding:20px;">
            ${flash.message}
        </div>
    </g:if>
</div>

</body>
</html>