<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<t:pageTemplate pageTitle="Add User">
    <h1>
        Add User
    </h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddUser">
        <div class="row g-3">
            <div class="col-sm-6">
                <label for="username" class="form-label">
                    Username
                </label>
                <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Valid Username is required.
                </div>
            </div>
        </div>


        <div class="col-sm-6">
            <label for="email" class="form-label">
                Email
            </label>
            <input type="text" class="form-control" id="email" name="email" placeholder="" value="" required>
            <div class="invalid-feedback">
                Valid email is required.
            </div>
        </div>

        <div class="col-sm-6">
            <label for="password" class="form-label">
                Password
            </label>
            <input type="text" class="form-control" id="password" name="password" placeholder="" value="" required>
            <div class="invalid-feedback">
                Password is required.
            </div>
        </div>


        <div class="col-sm-6">
            <label for="userGroups" class="form-label">
                Groups
            </label>
            <select class="form-select" id="user_groups" name="user_groups" multiple>
                <c:forEach var="user_group" items="${userGroups}" varStatus="status">
                    <option value="${user_group}">
                            ${user_group}
                    </option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">
                Please select a valid group.
            </div>

        </div>
        </div>

        <button type="submit" class="btn btn-primary btn-lg">
            Save :3
        </button>
    </form>


</t:pageTemplate>
