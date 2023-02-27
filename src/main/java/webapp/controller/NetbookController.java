package webapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import webapp.model.Netbooks;
import webapp.services.NetbookServices;

@WebServlet("/NetbookController")
public class NetbookController extends HttpServlet {
  
   private static final long serialVersionUID = 1L;
   private NetbookServices netbookServices;  //usamos la calse ModeloProductos
  
   @Resource(name="jdbc/netbooks")     //usamos la conexion Pool
   private DataSource miPool;
  
   
   //creamos el metodo Init(), que es como el main pero del lado del  servidor
   @Override
   public void init() throws ServletException {
        super.init();
        try {
           netbookServices=new NetbookServices(miPool);
         System.out.println(" se ejecuto el init()");
       } catch (Exception e) {}
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Leer el parametro del formulario
       String elComando=request.getParameter("instruccion");
        //si no se envia el parametro listar productos
       if(elComando==null) elComando="listar";
       //redirigir el flujo de ejecucion al metodo adecuado
    switch(elComando) {
       case "listar":
           obtenerProductos(request,response);
           break;
     case "insertarBBDD":
           agregarNetbook(request, response);
           break;
      case "cargar":
           try {
               updateNetbook(request, response);
           } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           break;
   case "actualizarBBDD":
           try {
               actualizaNetbook(request, response);
           } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           break;
   case  "eliminar":
           try {
               deleteNetbook(request,response);
           } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
   break;
       default:
   obtenerProductos(request,response);
       }
   }
//1º
   private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
   List<Netbooks> netbooks;
       try {
           netbooks=netbookServices.getNetbooks();
           request.setAttribute("LISTA_NETBOOKS", netbooks);
           RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaNetbooks.jsp");  
           miDispatcher.forward(request, response); 
   } catch (Exception e) {
           e.printStackTrace();
       }    
   }
   //2º  INSERT
   private void agregarNetbook(HttpServletRequest request, HttpServletResponse response) {
     //para formatear la fecha capturada
       SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
       Date Fecha=null;    // leer la informacion del producto queviene del formulario    
//Al Agregar Netbook no necesito el campo autoincremental num_net , este se agrega al ejecutar la sql
       String numero_serie=request.getParameter("serienet");
       String nombre_teach=request.getParameter("nombreprofe");
       String email_teach=request.getParameter("email");
       String telefono_teach=request.getParameter("telefono");
       String profesion_teach=request.getParameter("profesion");
       double precio_net=Double.parseDouble(request.getParameter("valor"));
    try {
           Fecha=formatoFecha.parse(request.getParameter("fecha"));
       } catch (ParseException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }
       String observacion=request.getParameter("observacion");
       //Crear un objeto del tipo Netbook               
       Netbooks NuevaNetbook=new Netbooks(numero_serie,nombre_teach, email_teach,telefono_teach, profesion_teach,precio_net,Fecha,observacion);
       //Enviar el objeto al modelo y despues insertar el objeto Netbook en la BBDD
       //hay que enviar el obj NuevaNetbook al controlador ServicesNetbook
   try {
           netbookServices.agregarNuevaNetbook(NuevaNetbook);
       } catch (Exception e) {
           System.out.println("No se ejecuto metodo agregarNetbook() del controlador");
           e.printStackTrace();
       }
       //Volver al listado de Netbooks
       obtenerProductos(request,response);
   }
//3º2
   private void actualizaNetbook(HttpServletRequest request, HttpServletResponse response) throws Exception {
       System.out.println("se entra al metodo actualizNetbook del controlador");
       //leer los datos que le vienen del form actualizar
       int numero_net=Integer.parseInt(request.getParameter("numero_net"));
       String numero_serie=request.getParameter("numero_serie");
       String nombre_teach= request.getParameter("nombre_teach");
       String email_teach= request.getParameter("email_teach");
       String telefono_teach= request.getParameter("telefono_teach");
       String profesion_teach=request.getParameter("profesion_teach");
       double precio_net=Double.parseDouble((request.getParameter("precio_net")));
       SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
       Date Fecha=null;
       try {
           Fecha=formatoFecha.parse(request.getParameter("fecha"));
       } catch (ParseException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }
       String observacion= request.getParameter("observacion");
      //crear un obj de tipo producto con la info del formulario
       Netbooks netbookActualizado=new Netbooks(numero_net,numero_serie,nombre_teach, email_teach,telefono_teach, profesion_teach,precio_net,Fecha,observacion);
       //actualizar la BBDD con la info del objeto Producto
       netbookServices.actualizarProducto(netbookActualizado);
       //Volver al listado con la info actualizada
       obtenerProductos(request,response);
   }
   //3º UPDATE - 
   private void updateNetbook(HttpServletRequest request, HttpServletResponse response) throws Exception {
       System.out.println("Se entra al  updateNetbook() del controlador");
       //leer el ID del registro que viene del listado
       int  id_num_net = Integer.valueOf(request.getParameter("numero_net"));
       System.out.println("el id a actualizar es" + id_num_net);
       //enviar C.Articulo al modelo (al controlador modeloProducto)
       System.out.println("Seva al metodo getProducto( int id) del services ");
       Netbooks objNetbook=netbookServices.getProducto(id_num_net);
       //colocarl el campo especifico que se quiere actualizar de ese articulo
       System.out.println("Si todo esta bien vuelve del metodo getProducto() ");
       request.setAttribute("NetbookActualizar", objNetbook);
       //enviar el producto al formukario de actualizar (jsp)
         System.out.println("NOS VAMOS PARA LA PAGINA ACTUALIZAR ");
       RequestDispatcher dispatcher=request.getRequestDispatcher("/ActualizaNetbook.jsp");
       System.out.println("VOLVEMOS DE LA PAGINA ACTUALIZAR ");
       dispatcher.forward(request, response);
   }
   //4to DELETE
   private void deleteNetbook(HttpServletRequest request, HttpServletResponse response) throws Exception {
       System.out.println("Se entra al  deleteNetbook del controlador");
       //leer el ID del registro que viene del listado
       int  id_num_net = Integer.valueOf(request.getParameter("numero_net"));
       System.out.println("el id a eliminarr es" + id_num_net);
       //enviar C.Articulo al modelo (al controlador modeloProducto)
       netbookServices.eliminarProducto(id_num_net);
       //volver a lla lista de productos
    obtenerProductos(request,response);
   }

}
