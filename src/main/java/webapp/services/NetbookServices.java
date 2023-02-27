package webapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import webapp.model.Netbooks;

public class NetbookServices {
private DataSource origenDatos;
    public NetbookServices(DataSource origenDatos) {
    this.origenDatos = origenDatos;
    }
//1º
    public List<Netbooks> getNetbooks() throws Exception{
       List<Netbooks> netbooks=new ArrayList<>();
        Connection miConexion=null;
        Statement miStatement=null;
        ResultSet miResultset=null;
       miConexion=origenDatos.getConnection();
//---------crear sentencia sql y statement----------------
        String instruccionSql="SELECT *FROM netbook17sf";
        miStatement=miConexion.createStatement();
        miResultset=miStatement.executeQuery(instruccionSql);
    //-----------recorrrer el resultset obtenido----------
        while ( miResultset.next()) {
            int numero_net=miResultset.getInt("num_net");
            String numero_serie=miResultset.getString("num_serie");
            String nombre_teach=miResultset.getString("name_teach");
            String email_teach=miResultset.getString("email_teach");
            String telefono_teach=miResultset.getString("phone_teach");
            String profesion_teach=miResultset.getString("job_teach");
            double precio_net=miResultset.getDouble("value_net");
            Date fecha=miResultset.getDate("fecha_entrega");     //java.util.Date;
            String observacion=miResultset.getString("observations");
            Netbooks tempNet=new Netbooks(numero_net,numero_serie,nombre_teach,email_teach,telefono_teach,profesion_teach,precio_net,fecha,observacion);
            netbooks.add(tempNet);
        }        
    return  netbooks;    
    }
//2º
    public void agregarNuevaNetbook(Netbooks nuevaNetbook)throws Exception {
        // TODO Auto-generated method stub
        System.out.println("se ejecuto metodo agregarNuevaNetbook() ");
        //obtener la conexion con la bd
        Connection miConexion=null;
        PreparedStatement miStatement=null;
        try {
            miConexion=origenDatos.getConnection();
            //Crear instruccion sql que inserte el producto
            //Al Agregar Netbook no necesito el campo autoincremental num_net , este se agrega al ejecutar la sql
            String sql="INSERT INTO netbook17sf(num_serie,name_teach,email_teach,"
                    + "phone_teach,job_teach,value_net,fecha_entrega,observations) VALUES(?,?,?,?,?,?,?,?)";

            miStatement=miConexion.prepareStatement(sql);
            //establecer parametro para el producto
            miStatement.setString(1,nuevaNetbook.getNumero_serie());
            miStatement.setString(2,nuevaNetbook.getNombre_teach());
            miStatement.setString(3,nuevaNetbook.getEmail_teach());
            miStatement.setString(4,nuevaNetbook.getTelefono_teach());
            miStatement.setString(5,nuevaNetbook.getProfesion_teach());
            miStatement.setDouble(6,nuevaNetbook.getPrecio_net());
            java.util.Date utilDate=nuevaNetbook.getFecha();
            java.sql.Date fechaConvertida= new java.sql.Date(utilDate.getTime());
            // miStatement.setDate(7,(java.sql.Date) nuevaNetbook.getFecha());
            miStatement.setDate(7,fechaConvertida);
            miStatement.setString(8,nuevaNetbook.getObservacion());
            //ejecutar la instruccion sql
            miStatement.execute();
            System.out.println("se ejecuto metodo agregarNuevaNetbook() ");
} catch (Exception e) {
            System.out.println(e+ " NO SE ejecuto metodo agregarNuevaNetbook() ");
        }finally {
            miStatement.close();
            miConexion.close();
            System.out.println( " se cerro conexion ");
        }
}
//3º - 1
    public Netbooks getProducto(int id_num_net) {
        System.out.println("se entra al metodo getProducto(int id_num_net) " +id_num_net );
        Netbooks elProducto=null;
        Connection miConexion=null;
        PreparedStatement miStatement=null;
        ResultSet miResultset=null;
        int cArticulo=id_num_net;
        try {
            //Establecer la conexion con la BD
            miConexion=origenDatos.getConnection();
            //Crear sql que busque el producto
            String sql="SELECT * FROM netbook17sf WHERE num_net=?";
            //crear consulta preparada
            miStatement=miConexion.prepareStatement(sql);
            //establecdr los parametros de esa consulta
            miStatement.setInt(1, cArticulo);
            //ejecutar la consulta
            miResultset=miStatement.executeQuery();
            //obtener datos de respuesta
    if(miResultset.next()) {
                int numero_net=miResultset.getInt("num_net");
                String numero_serie=miResultset.getString("num_serie");
                String nombre_teach=miResultset.getString("name_teach");
                String email_teach=miResultset.getString("email_teach");
                String telefono_teach=miResultset.getString("phone_teach");
                String profesion_teach=miResultset.getString("job_teach");
                double precio_net=miResultset.getDouble("value_net");
                Date fecha=miResultset.getDate("fecha_entrega");
                String observacion=miResultset.getString("observations");
                //    elProducto=new Productos(c_art,seccion,n_art,precio,fecha,importado,p_orig);
                elProducto=new Netbooks(numero_net,numero_serie,nombre_teach,email_teach,telefono_teach,profesion_teach,precio_net,fecha,observacion);
            }else {
                throw new Exception("No hemos encontrado el produto con codigo articulo" + cArticulo);
            }
            System.out.println("se ejecuto metodo getNetbook() ");
    } catch (Exception e) {
            System.out.println(e+ " NO SE ejecuto metodo getNetbook() ");
        }
    return elProducto;
    }
//3º3ra
    public void actualizarProducto(Netbooks netbookActualizado) throws Exception {
        System.out.println(" se entra al metodo actualizar producto del services ");
        System.out.println(" dESPUES DE OBTNER ID Y EJECUTARSE  getProducto ");
        System.out.println( " valor id " +netbookActualizado.getNumero_net()   );
        Connection miConexion=null;
        PreparedStatement miStatement=null;
        //Establecer la conexion
        try{
            miConexion=origenDatos.getConnection();
            //Crear sentencia SQL
            String sql="UPDATE netbook17sf SET  num_serie=?,name_teach=?,email_teach=?,phone_teach=?,job_teach=?,value_net=?,fecha_entrega=?,observations=?"
                    + " WHERE num_net=? ";
            //cREAR LA CONSULTA PREPARADA
            miStatement=miConexion.prepareStatement(sql);
            System.out.println( " valor id " +netbookActualizado.getNumero_net()   );
            //Establecer los parametros
            miStatement.setString(1,netbookActualizado.getNumero_serie());
            miStatement.setString(2,netbookActualizado.getNombre_teach());
            miStatement.setString(3,netbookActualizado.getEmail_teach());
            miStatement.setString(4,netbookActualizado.getTelefono_teach());
            miStatement.setString(5,netbookActualizado.getProfesion_teach());
            miStatement.setDouble(6,netbookActualizado.getPrecio_net());
            java.util.Date utilDate=netbookActualizado.getFecha();
            java.sql.Date fechaConvertida= new java.sql.Date(utilDate.getTime());
            miStatement.setDate(7,fechaConvertida);

            miStatement.setString(8,netbookActualizado.getObservacion());
            miStatement.setInt(9,netbookActualizado.getNumero_net());
            //Ejecutar la instruccion SQL
            miStatement.execute();
    }finally {
            miStatement.close();
            miConexion.close();
            System.out.println( " se cerro conexion ");
        }
}
    //4 1º
    public void eliminarProducto(int id_num_net) throws Exception {
        // TODO Auto-generated method stub
        Connection miConexion=null;
        PreparedStatement miStatement=null;
        //Establecer la conexion
        try {
            miConexion=origenDatos.getConnection();
            //Crear instruccion SQL de la eliminacion
            String sql="DELETE FROM netbook17sf WHERE num_net=? ";
            //Preparar la consulta
            miStatement=miConexion.prepareStatement(sql);
            //Establecer parametros de la consulta
            miStatement.setInt(1, id_num_net);
            miStatement.execute();
        }finally {
            miStatement.close();
            miConexion.close();
            System.out.println( " se cerro conexion ");
        }
    }
}
