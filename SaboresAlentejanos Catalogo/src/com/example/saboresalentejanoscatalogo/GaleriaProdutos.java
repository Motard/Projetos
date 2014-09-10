package com.example.saboresalentejanoscatalogo;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class GaleriaProdutos extends Activity {
	private GridView gridView;
	private GridViewAdapter customGridAdapter;
	private String produto;
	
	public static final String NOME_PRODUTO = "nome_produto"; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_galeria_produtos);
		
		produto = getIntent().getStringExtra("batata");
		produto = produto.toLowerCase();
		
		
		gridView = (GridView) findViewById(R.id.gridView);
		customGridAdapter = new GridViewAdapter(this, R.layout.row_grid,getData());
		gridView.setAdapter(customGridAdapter);
		
		gridView.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) 
			{	
				Object o = gridView.getItemAtPosition(position);
				ImageItem imageItem = (ImageItem) o;
				
				String nameImage = imageItem.getTitle();
				
				Intent intent = new Intent(GaleriaProdutos.this,Produto.class);
				intent.putExtra(NOME_PRODUTO, nameImage);
				startActivity(intent);
			}
		});
		
	}
	
	private ArrayList getData()
	{
		final ArrayList imageItems = new ArrayList();
		
		TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
		TypedArray imgs_names = getResources().obtainTypedArray(R.array.image_name);

		
		for (int i = 0; i<imgs.length(); i++)
		{
			//Obter o nome do ficheiro e se este for igual ao produto selecionada adicionar ‡s imageItems
			String nameFile = imgs.getString(i);
			if (!nameFile.contains(produto))
				continue;
			
			Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), imgs.getResourceId(i, -1));
			String bitmap_name = imgs_names.getString(i);
			
			imageItems.add(new ImageItem(bitmap, bitmap_name));
		}
		return imageItems;
	}

}
