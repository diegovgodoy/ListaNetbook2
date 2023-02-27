<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
    crossorigin="anonymous">
<link rel="stylesheet" href="./dashboard.css">
<title>Insert title here</title>
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
    <!-- Container -->
    <div class="container-fluid">
        <div class="row">
            <!-- Sidear -->
            <div class="col-md-2 bg-light d-none d-md-block sidebar">
                <div class="left-sidebar">

                    <ul class="nav flex-column sidebar-nav">
                        <li class="nav-item"><a class="nav-link active" href="#">
                                <svg class="bi bi-chevron-right" width="16" height="16"
                                    viewBox="0 0 20 20" fill="currentColor"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                        d="M6.646 3.646a.5.5 0 01.708 0l6 6a.5.5 0 010 .708l-6 6a.5.5 0 01-.708-.708L12.293 10 6.646 4.354a.5.5 0 010-.708z"
                                        clip-rule="evenodd" /></svg> Informática
                        </a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- MAIN -->
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
        <hr>
        <hr>
        <h3>ACTUALIZAR REGISTROS</h3>
        <hr>
        <form name="form1" method="get" action="NetbookController">
            <input type="hidden" name="instruccion" value="actualizarBBDD">
            <!-- *INSERT Producto* -->
            <input type="hidden" name="numero_net"
                value="${NetbookActualizar.numero_net}">
            <!--  
            <div class="row mb-3">
                <label for="CArt" class="col-sm-2 col-form-label">Codigo Articulo</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="CArt" name="CArt">
                </div>
            </div> -->
            <div class="row mb-3">
                <label for="serienet" class="col-sm-2 col-form-label">Numero
                    Serie</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="numero_serie"
                        name="numero_serie" value="${NetbookActualizar.numero_serie}">
                </div>
            </div>
            <div class="row mb-3">
                <label for="nombreprofe" class="col-sm-2 col-form-label">Nombre
                    Profesor</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="nombre_teach"
                        name="nombre_teach" value="${NetbookActualizar.nombre_teach}"
                        placeholder="0000.00">
                </div>
            </div>
            <div class="row mb-3">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="email_teach"
                        name="email_teach" value="${NetbookActualizar.email_teach}"
                        placeholder="AAAA-MM-DD">
                </div>
            </div>
            <div class="row mb-3">
                <label for="telefono" class="col-sm-2 col-form-label">Telefono</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="telefono_teach"
                        name="telefono_teach" value="${NetbookActualizar.telefono_teach}">
                </div>
            </div>
            <div class="row mb-3">
                <label for="profesion" class="col-sm-2 col-form-label">Profesion</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="profesion_teach"
                        name="profesion_teach"
                        value="${NetbookActualizar.profesion_teach}">
                </div>
            </div>
            <div class="row mb-3">
                <label for="valor" class="col-sm-2 col-form-label">Valor</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="precio_net"
                        name="precio_net" value="${NetbookActualizar.precio_net}">
                </div>
            </div>
            <div class="row mb-3">
                <label for="fecha" class="col-sm-2 col-form-label">Fecha</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="fecha" name="fecha"
                        placeholder="AAAA-MM-DD" value="${NetbookActualizar.fecha}">
                </div>
            </div>
            
            <div class="row mb-3">
                <label for="observacion" class="col-sm-2 col-form-label">Observacion</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="observacion"
                        name="observacion" value="${NetbookActualizar.observacion}">
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Actualzicacion
                    de Datos </label>
                <div class="col-sm-2">
                    <button type="submit" class="btn btn-primary" name="envio"
                        id="envio" value="enviar">Enviar Datos</button>
                </div>
                <div class="col-sm-2">
                    <button type="reset" class="btn btn-primary" name="borrar"
                        id="borrar" value="Restablecer">Restablecer</button>
                </div>
            </div>
        </form>
        <h3>Formulario de Registro</h3>
        <hr>
        <div class="alert alert-primary" role="alert">Sistema de Registro de Netbooks</div>
    </main>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>
