<!DOCTYPE html>


<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>

    <body>
        <g:form name="addExpense" url="[controller:'User',action:'addExpense']"style="margin: 0 auto; width:320px">
            <h1>name</h1>
            <g:textField name="name" value="" />
            <h1>balance</h1>
            <g:textField name="balance" value="" /> <br/><br/>
            <g:actionSubmit value="Add expense" action="addExpense"/>
        </g:form>
    </body>
</html>