<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<t:pageTemplate pageTitle="Add Car">
    <h1>
        Add a Car
    </h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
        <div class="row g-3">
            <div class="col-sm-6">
                <label for="license_plate" class="form-label">
                    License Plate
                </label>
                <input type="text" class="form-control" id="license_plate" name="license_plate" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Valid License Plate is required.
                </div>
            </div>
        </div>


        <div class="col-sm-6">
            <label for="parking_spot" class="form-label">
                Parking Spot
            </label>
            <input type="text" class="form-control" id="parking_spot" name="parking_spot" placeholder="" value="" required>
            <div class="invalid-feedback">
                Valid Parking Spot is required.
            </div>
        </div>


        <div class="col-sm-6">
            <label for="owner" class="form-label">
                Owner
            </label>
            <select class="form-select" id="owner" name="owner_id" required>
                <option value="">
                    Choose...
                </option>
                <c:forEach var="user" items="${users}">
                    <option value="${user.id}">
                            ${user.username}
                    </option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">
                Please select a valid owner.
            </div>

        </div>
        </div>

        <button type="submit" class="btn btn-primary btn-lg">
            Save :3
        </button>
    </form>


</t:pageTemplate>
