package com.example.saboresalentejanoscatalogo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaProdutos extends ListActivity 
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//Criar o array da lista de produtos
		String[] values = new String[] {"Mel","Azeite","Queijo","Enchidos","Doces","Licor"};

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_layout, values);
		
		setListAdapter(adapter);
	}

		
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		String item = (String) getListAdapter().getItem(position);
		
		
		Intent intent = new Intent(ListaProdutos.this,GaleriaProdutos.class);
		intent.putExtra("batata", item);
		startActivity(intent);
	}
}
