package com.example.saboresalentejanoscatalogo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Produto extends Activity 
{
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produto);
		
		String nomeImage = getIntent().getStringExtra(GaleriaProdutos.NOME_PRODUTO);
		
		Toast.makeText(this, nomeImage, Toast.LENGTH_LONG).show();
	};
}
