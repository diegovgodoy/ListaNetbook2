package webapp.model;

import java.util.Date;

public class Netbooks {
    private int numero_net;
    private String numero_serie;
    private String nombre_teach;
    private String email_teach;
    private String telefono_teach;
    private String profesion_teach;
    private double precio_net;
    private Date fecha;                       //java.util.Date;
    private String observacion;

//Contructor con campo clave
public Netbooks(int numero_net, String numero_serie, String nombre_teach, String email_teach, String telefono_teach,String profesion_teach, double precio_net, Date fecha, String observacion) {
        this.numero_net = numero_net;
        this.numero_serie = numero_serie;
        this.nombre_teach = nombre_teach;
        this.email_teach = email_teach;
        this.telefono_teach = telefono_teach;
        this.profesion_teach = profesion_teach;
        this.precio_net = precio_net;
        this.fecha = fecha;
        this.observacion = observacion;
    }
    //Constructor sin campo clave
public Netbooks(String numero_serie, String nombre_teach, String email_teach, String telefono_teach,
            String profesion_teach, double precio_net, Date fecha, String observacion) {
        this.numero_serie = numero_serie;
        this.nombre_teach = nombre_teach;
        this.email_teach = email_teach;
        this.telefono_teach = telefono_teach;
        this.profesion_teach = profesion_teach;
        this.precio_net = precio_net;
        this.fecha = fecha;
        this.observacion = observacion;
    }
public int getNumero_net() {
	return numero_net;
}
public void setNumero_net(int numero_net) {
	this.numero_net = numero_net;
}
public String getNumero_serie() {
	return numero_serie;
}
public void setNumero_serie(String numero_serie) {
	this.numero_serie = numero_serie;
}
public String getNombre_teach() {
	return nombre_teach;
}
public void setNombre_teach(String nombre_teach) {
	this.nombre_teach = nombre_teach;
}
public String getEmail_teach() {
	return email_teach;
}
public void setEmail_teach(String email_teach) {
	this.email_teach = email_teach;
}
public String getTelefono_teach() {
	return telefono_teach;
}
public void setTelefono_teach(String telefono_teach) {
	this.telefono_teach = telefono_teach;
}
public String getProfesion_teach() {
	return profesion_teach;
}
public void setProfesion_teach(String profesion_teach) {
	this.profesion_teach = profesion_teach;
}
public double getPrecio_net() {
	return precio_net;
}
public void setPrecio_net(double precio_net) {
	this.precio_net = precio_net;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getObservacion() {
	return observacion;
}
public void setObservacion(String observacion) {
	this.observacion = observacion;
}
@Override
public String toString() {
	return "Netbooks [numero_net=" + numero_net + ", numero_serie=" + numero_serie + ", nombre_teach=" + nombre_teach
			+ ", email_teach=" + email_teach + ", telefono_teach=" + telefono_teach + ", profesion_teach="
			+ profesion_teach + ", precio_net=" + precio_net + ", fecha=" + fecha + ", observacion=" + observacion
			+ "]";
}

//getters and setter



//    método toString()

}
