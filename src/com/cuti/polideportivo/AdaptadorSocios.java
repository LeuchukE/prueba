package com.cuti.polideportivo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;



import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListAdapter;
import android.widget.TextView;

public class AdaptadorSocios implements ListAdapter {

	private List<Socio> socios;
	private Activity context;

	public AdaptadorSocios(Activity context, List<Socio> socios) {
		this.context = context;
		this.socios = socios;

	}

	static class ViewHolderSocio {
	    TextView doc;
	    TextView nomb;
	  
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		ViewHolderSocio holder;
	    if(rowView == null){
	        LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
	        rowView = inflater.inflate(R.layout.linea_socio, null);
	        
	        holder = new ViewHolderSocio();
	        holder.doc = (TextView) rowView.findViewById(R.id.tvCodigo);
	        holder.nomb = (TextView)  rowView.findViewById(R.id.tvNombre);
	        //holder.imagen = (ImageView) rowView.findViewById(R.id.icon);
	        
	        rowView.setTag(holder);

	    }else{	
	    	
	    	 holder = (ViewHolderSocio) rowView.getTag();
	    }
		
		
	    holder.doc.setText("C.I: "+ socios.get(position).getDocumento());
	    holder.nomb.setText("Nombre: "+ socios.get(position).getNombre());
		
		
		
		return rowView;
	}

	public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());
    }
	
	
	
	public int getCount() {
		// TODO Auto-generated method stub
		return socios.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return socios.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getItemViewType(int arg0) {
		// TODO Auto-generated method stub
		return R.layout.linea_socio;
	}


	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void registerDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void unregisterDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled(int arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}

