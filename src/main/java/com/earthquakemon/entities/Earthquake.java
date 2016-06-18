package com.earthquakemon.entities;

import java.util.Date;

public class Earthquake {

    private long idPk;

	private String alerta;

	//Llave primaria del Earthquake
	private String id;
	
	// Título en ingles del evento : Ejemplo : "M 1.7 - 15km SSW of Tehachapi, California"
	private String titulo;
	
	// Magnitud del Earthquake Rango [-1.0 a 10.0]
	private double magnitud;
	
	// Lugar donde ocurrio el Earthquake
	private String lugar;
	
	// Dia y hora en que ocurrio el sismo
	private Date tiempo;
	
	// Dia y hora en que se actualizo datos del sismo
	private Date actualizacion;
	
	// Enlace a la página del USGS para el evento
	private String url;
	
	// Enlace al detalle GeoJSON a partir de un Resumen GeoJSON . Devuelve un nuevo JSON
	private String urldetalle;
	
	// 0= No hay alerta de tsunami  1 = Existe alerta de tsunami
	private int tsunami;
	
	// Tipo de evento: earthquake o  quarry
	private String tipo;
	
	// Un número significativo describiendo cómo es el caso. Los números mayores indican un evento
	// más significativo. Este valor se determina en un número de factores, incluyendo: magnitud,
	// máximo MMI, los informes de fieltro, y el impacto estimado. [0, 1000]
	private int significancia;
	
	// Las coordenadas del sismo
	private double longitud;
	private double latitud;
	private double profundidad;

    public Earthquake() {
    }

    public Earthquake(String id,String alerta ,String titulo, double magnitud, String lugar,
                      Date tiempo, Date actualizacion, String url, String urldetalle,
                      int tsunami, String tipo, double longitud, double latitud,
                      double profundidad, int significancia) {
		super();
		this.id = id;
		this.alerta = alerta;
		this.titulo = titulo;
		this.magnitud = magnitud;
		this.lugar = lugar;
		this.tiempo = tiempo;
		this.actualizacion = actualizacion;
		this.url = url;
		this.urldetalle = urldetalle;
		this.tsunami = tsunami;
		this.tipo = tipo;
		this.longitud = longitud;
		this.latitud = latitud;
		this.profundidad = profundidad;
		this.significancia=significancia;
	}

    public long getIdPk() {
        return idPk;
    }

    public void setIdPk(long idPk) {
        this.idPk = idPk;
    }

	public String getAlerta() {
		return alerta;
	}

	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getMagnitud() {
		return magnitud;
	}
	public void setMagnitud(double magnitud) {
		this.magnitud = magnitud;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public Date getTiempo() {
		return tiempo;
	}
	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}
	public Date getActualizacion() {
		return actualizacion;
	}
	public void setActualizacion(Date actualizacion) {
		this.actualizacion = actualizacion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrldetalle() {
		return urldetalle;
	}
	public void setUrldetalle(String urldetalle) {
		this.urldetalle = urldetalle;
	}
	public int getTsunami() {
		return tsunami;
	}
	public void setTsunami(int tsunami) {
		this.tsunami = tsunami;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(double profundidad) {
		this.profundidad = profundidad;
	}
	public int getSignificancia() {
		return significancia;
	}
	public void setSignificancia(int significancia) {
		this.significancia = significancia;
	}

}
