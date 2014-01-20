package com.cuti.polideportivo.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cuti.polideportivo.Socio;
import com.cuti.polideportivo.sql.PolideportivoSQLiteHelper;


public class SociosDAO {
	
	private static SociosDAO sociosInstance = null;
	
	private PolideportivoSQLiteHelper dbHelper;
	private SQLiteDatabase db;
	
	private SociosDAO(Context context) {
		dbHelper = PolideportivoSQLiteHelper.getInstance(context);
		db = dbHelper.getOpenDb();
	}

	public static SociosDAO getInstance(Context context) {
		
		if (sociosInstance == null) {
			sociosInstance = new SociosDAO(context);
		}
		return sociosInstance;
	}
	
	public boolean crearSocioNuevo(String documento, String nombre, String apellido, String sexo,
			String estadoCivil, String nacionalidad, String fechaNacimiento,
			String domicilio, String localidad, String celular,
			String telefono, String email, String categoria,
			String actividadesPreferidas) {
		
		// Creo un ContentValues para los valores a setear al nuevo Deporte
		ContentValues values = new ContentValues();
		values.put(PolideportivoSQLiteHelper.COLUMNA_DOCUMENTO, documento);
		values.put(PolideportivoSQLiteHelper.COLUMNA_NOMBRE, nombre);
		values.put(PolideportivoSQLiteHelper.COLUMNA_APELLIDO, apellido);
		values.put(PolideportivoSQLiteHelper.COLUMNA_SEXO, sexo);
		values.put(PolideportivoSQLiteHelper.COLUMNA_ESTADO_CIVIL, estadoCivil);
		values.put(PolideportivoSQLiteHelper.COLUMNA_NACIONALIDAD, nacionalidad);
		values.put(PolideportivoSQLiteHelper.COLUMNA_FECHA_NACIMIENTO, fechaNacimiento);
		values.put(PolideportivoSQLiteHelper.COLUMNA_DOMICILIO, domicilio);
		values.put(PolideportivoSQLiteHelper.COLUMNA_LOCALIDAD, localidad);
		values.put(PolideportivoSQLiteHelper.COLUMNA_CELULAR, celular);
		values.put(PolideportivoSQLiteHelper.COLUMNA_TELEFONO, telefono);
		values.put(PolideportivoSQLiteHelper.COLUMNA_EMAIL, email);
		values.put(PolideportivoSQLiteHelper.COLUMNA_CATEGORIA, categoria);
		values.put(PolideportivoSQLiteHelper.COLUMNA_ACTIVIDADES_PREFERIDAS, actividadesPreferidas);
		
		// Ejecuto el comando insert para crear en la Tabla Deporte
		// el nuevo deporte con los valores que quiero
		// el codigo no lo defino porque se autogenera correlativo
		long codigo = db.insert(PolideportivoSQLiteHelper.TABLA_SOCIOS, 
				null, values);
		
		return true;
	}
	
	public void eliminarSocioPorDocumento(Socio socio) {
		
		String documento = socio.getDocumento();
		db.delete(PolideportivoSQLiteHelper.TABLA_SOCIOS, 
				PolideportivoSQLiteHelper.COLUMNA_DOCUMENTO
					+ " = " + documento, null);
	}
	
	public List<Socio> obtenerTodosLosSocios() {
		
		List<Socio> socios = new Vector<Socio>();
		
        Cursor cursor = db.query(PolideportivoSQLiteHelper.TABLA_SOCIOS, PolideportivoSQLiteHelper.columnasSocios, null, null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Socio nuevoSocio = crearSocioDesdeCursor(cursor);
            socios.add(nuevoSocio);
            cursor.moveToNext();
        }
 
        cursor.close();
		return socios;

	}
	
	private Socio crearSocioDesdeCursor(Cursor cursor) {
		Socio socio = new Socio(
				cursor.getString(1),  // nombre
				cursor.getString(2),  // descripcion
				cursor.getString(3),"","","","","","","","","","",""); // nombre imagen
		return socio;
	}

}
