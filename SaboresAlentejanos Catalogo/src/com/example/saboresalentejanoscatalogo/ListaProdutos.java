package com.example.saboresalentejanoscatalogo;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListaProdutos extends ListActivity 
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//setContentView(R.layout.activity_lista_produtos);
		
		//Criar o array da lista de produtos
		//final ListView listview = (ListView) findViewById(R.id.listview);
		String[] values = new String[] {"Mel","Azeite","Queijo","Enchidos","Doces","Licor"};

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		
		setListAdapter(adapter);
	}

}
