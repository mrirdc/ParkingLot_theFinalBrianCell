<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:pageTemplate pageTitle="Cats">
    <h1>Cats</h1>
    <div class="container text-center">
        <div class="row">
            <div class="col">
                Cat 1
            </div>
            <div class="col">
                Spot 1
            </div>
            <div class="col">
                User 1
            </div>
        </div>
        <div class="row">
            <div class="col">
                Cat 2
            </div>
            <div class="col">
                Spot 2
            </div>
            <div class="col">
                User 2
            </div>
        </div>
    </div>
    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>
