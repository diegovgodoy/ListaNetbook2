 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--   CSS  Personalizado-->
<link rel="stylesheet" href="./dashboard.css">
<!--Adding datatable css cdn-->
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
<!--Adding  bOOTSTRAP datatable css cdn-->
<link rel="stylesheet"
    href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">
<!--   Adding Jquery CDN-->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<!--   Adding DATATABLE CDN-->
<script
    src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

<!--   Adding BOOTSTRAP PARA DATATABLE-->
<script
    src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js"></script>

<script src="./main.js"></script>
<title>Document</title>
</head>
<body>
    <!-- Nav Bar -->
    <nav
        class="navbar navbar-dark fixed-top bg-primary flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Duomly
            Dashboard</a> <input type="text"
            class="form-control form-control-primary w-100"
            placeholder="Search...">
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap"><a class="nav-link" href="#">Logout</a>
            </li>
        </ul>
    </nav>
    <div class="container-sm">100% wide until small breakpoint</div>
    <!-- Container -->
    <div class="container-fluid">
        <div class="row">
            <hr>
            <hr>
            <
            <div class="btn-group">
                <a href="#" class="btn btn-primary active" aria-current="page">Active
                    link</a> <a href="#" class="btn btn-primary">Link</a> <a href="#"
                    class="btn btn-primary">Link</a>
            </div>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <h5>
                    <img src="assets/boton_panel4.svg" alt="" width="30" height="24"
                        class="d-inline-block align-text-top">LISTA DE NETBOOKS
                    INVENTARIADAS
                </h5>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button class="btn btn-primary me-md-2" type="button"
                        onclick="window.location.href='InsertarNetbook.jsp'">
                        INSERTAR</button>
                    <button class="btn btn-primary" type="button">Button</button>
                </div>
                <hr>
                <table id="example" class="display nowrap" style="width: 100%">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nº Serie</th>
                            <th>Nombre Profesor</th>
                            <th>Email</th>
                            <th>Teleono</th>
                            <th>Profesion</th>
                            <th>Valor</th>
                            <th>Fecha</th>
                            <th>Observacion</th>
                        </tr>
                    </thead>
                    <c:forEach var="tempNet" items="${LISTA_NETBOOKS}">
                        <!-- link para ACTUALIZAR cada producto *Update producto* -->
                        <c:url var="linkTemp" value="NetbookController">
                            <c:param name="instruccion" value="cargar"></c:param>
                            <c:param name="numero_net" value="${tempNet.numero_net}"></c:param>
                            <!-- Usamos para editar el campo indice que es el codigo del producto -->
                            <!-- Siempre se actualiza un producto a partir del id seleccionado -->
                        </c:url>

                        <!-- link para ELIMINARcada producto *DELETE producto* -->
                        <c:url var="linkTempeEliminar" value="NetbookController">
                            <c:param name="instruccion" value="eliminar"></c:param>
                            <c:param name="numero_net" value="${tempNet.numero_net}"></c:param>
                            <!-- Capturamos el id co codigo  del producto -->
                            <!-- Siempre se eliminar un producto a partir del id seleccionado -->
                        </c:url>
                        <tbody>
                            <tr>
                                <td>${tempNet.numero_net}</td>
                                <td>${tempNet.numero_serie}</td>
                                <td>${tempNet.nombre_teach}</td>
                                <td>${tempNet.email_teach}</td>
                                <td>${tempNet.telefono_teach}</td>
                                <td>${tempNet.profesion_teach}</td>
                                <td>${tempNet.precio_net}</td>
                                <td>${tempNet.fecha}</td>
                                <td>${tempNet. observacion}</td>
                                <td><a href="${linkTemp}" class="btn btn-info">Actualizar</a>&nbsp;&nbsp;<a
                                    href="${linkTempeEliminar}" class="btn btn-dark">Eliminar</a></td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </main>
        </div>
     </div>
    <script src="main.js"></script>
</body>
</html>
