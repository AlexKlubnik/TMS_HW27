<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="static/bootstrap.min.css">
    <link rel="stylesheet" href="static/mystyle.css">
    <title>Request form</title>
</head>
<body>

<div class="container">
    <div class="row"><h2>Hello, Administrator!</h2></div>
    <div class="row">
        <form action="requests" method="post">

            <div class="col-md-4 col-xl-4">
                <div class="mb-3">
                    <label for="request_id" class="form-label">Request id:</label>
                    <input type="text" class="form-control" id="request_id" name="id"/>
                    <c:if test="${errors['id'] != null}">
                        <div style="color: red">
                            <c:out value="${errors['id']}"/>
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="col-md-4 col-xl-4">
                <div class="mb-3">
                    <label for="request_service" class="form-label">Request service:</label>
                    <input type="text" class="form-control" id="request_service" name="service"/>
                    <c:if test="${errors['service']!=null}">
                        <div style="color: red">
                            <c:out value="${errors['service']}"/>
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="col-md-4 col-xl-4">
                <div class="mb-3">
                    <label for="request_price" class="form-label">Request price:</label>
                    <input type="text" class="form-control" id="request_price" name="price"/>
                    <c:if test="${errors['price']!=null}">
                        <div style="color: red">
                            <c:out value="${errors['price']}"/>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary">Add request</button>
            </div>
        </form>

    </div>
</div>


<script src="static/bootstrap.bundle.js"></script>
</body>
</html>
