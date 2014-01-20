package com.cuti.polideportivo.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PolideportivoSQLiteHelper extends SQLiteOpenHelper {
	
	private static PolideportivoSQLiteHelper sInstance = null;
	
	private SQLiteDatabase db = null;
	
	// Nombre Base Datos
	public static final String DATABASE_NAME = "polideportivo.db";
	public static final int DATABASE_VERSION = 1;
	
	// En este caso defino las ctes de la tabla Deporte
	// Nombre Tabla
	public static final String TABLA_SOCIOS = "socios";
	
	// Columnas Tabla Deporte
	public static final String COLUMNA_CODIGO = "codigo";
	public static final String COLUMNA_DOCUMENTO = "documento";
	public static final String COLUMNA_NOMBRE = "nombre";
	public static final String COLUMNA_APELLIDO = "apellido";
	public static final String COLUMNA_SEXO = "sexo";
	public static final String COLUMNA_ESTADO_CIVIL = "estadoCivil";
	public static final String COLUMNA_NACIONALIDAD = "nacionalidad";
	public static final String COLUMNA_FECHA_NACIMIENTO = "fechaNacimiento";
	public static final String COLUMNA_DOMICILIO = "domicilio";
	public static final String COLUMNA_LOCALIDAD = "localidad";
	public static final String COLUMNA_CELULAR = "celular";
	public static final String COLUMNA_TELEFONO = "telefono";
	public static final String COLUMNA_EMAIL = "email";
	public static final String COLUMNA_CATEGORIA = "categoria";
	public static final String COLUMNA_ACTIVIDADES_PREFERIDAS = "actividadesPreferidas";
	
	
	public static final String[] columnasSocios = 
		{ PolideportivoSQLiteHelper.COLUMNA_CODIGO,
		PolideportivoSQLiteHelper.COLUMNA_DOCUMENTO,
		PolideportivoSQLiteHelper.COLUMNA_NOMBRE,
		PolideportivoSQLiteHelper.COLUMNA_APELLIDO,
		PolideportivoSQLiteHelper.COLUMNA_SEXO,
		PolideportivoSQLiteHelper.COLUMNA_ESTADO_CIVIL,
		PolideportivoSQLiteHelper.COLUMNA_NACIONALIDAD,
		PolideportivoSQLiteHelper.COLUMNA_FECHA_NACIMIENTO,
		PolideportivoSQLiteHelper.COLUMNA_DOMICILIO,
		PolideportivoSQLiteHelper.COLUMNA_LOCALIDAD,
		PolideportivoSQLiteHelper.COLUMNA_CELULAR,
		PolideportivoSQLiteHelper.COLUMNA_TELEFONO,
		PolideportivoSQLiteHelper.COLUMNA_EMAIL,
		PolideportivoSQLiteHelper.COLUMNA_CATEGORIA,
		PolideportivoSQLiteHelper.COLUMNA_ACTIVIDADES_PREFERIDAS
		};
	
	// SQL para creacion de la Tabla Deporte
	private static final String TABLA_SOCIOS_CREACION = "CREATE TABLE "
			+ TABLA_SOCIOS + "(" + COLUMNA_CODIGO + " INTEGER primary key autoincrement, " 
			+ COLUMNA_DOCUMENTO + " TEXT not null,"
			+ COLUMNA_NOMBRE + " TEXT,"
			+ COLUMNA_APELLIDO + " TEXT,"
			+ COLUMNA_SEXO + " TEXT,"
			+ COLUMNA_ESTADO_CIVIL + " TEXT,"
			+ COLUMNA_NACIONALIDAD + " TEXT,"
			+ COLUMNA_FECHA_NACIMIENTO + " TEXT,"
			+ COLUMNA_DOMICILIO + " TEXT,"
			+ COLUMNA_LOCALIDAD + " TEXT,"
			+ COLUMNA_CELULAR + " TEXT,"
			+ COLUMNA_TELEFONO + " TEXT,"
			+ COLUMNA_EMAIL + " TEXT,"
			+ COLUMNA_CATEGORIA + " TEXT,"
			+ COLUMNA_ACTIVIDADES_PREFERIDAS + " TEXT "
					+ ");";

	public static PolideportivoSQLiteHelper getInstance(Context context) {

		// Use the application context, which will ensure that you 
		// don't accidentally leak an Activity's context.
		// See this article for more information: http://bit.ly/6LRzfx
		if (sInstance == null) {
			sInstance = new PolideportivoSQLiteHelper(context.getApplicationContext());
		}
		return sInstance;
	}

	private PolideportivoSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public SQLiteDatabase getOpenDb() {
		if (db == null || !db.isOpen()){
			db = sInstance.getWritableDatabase();
		}
		return db;
	}
	
	public void close() {
		if (db != null && db.isOpen()){
			db.close();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		
		database.execSQL(TABLA_SOCIOS_CREACION);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
		
		Log.w(PolideportivoSQLiteHelper.class.getName(),
				"Actualizando la version de la base de datos: " + oldVersion + " a "
						+ newVersion + ", se eliminan los datos viejos en este caso");
		
		// Tabla SOCIOS
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_SOCIOS);
		onCreate(db);

	}

}
