package com.example.saboresalentejanoscatalogo;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Produto extends Activity 
{
	private String nameImage;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produto);
		
		nameImage = getIntent().getStringExtra(GaleriaProdutos.NOME_PRODUTO);
		
		//Toast.makeText(this, nameImage, Toast.LENGTH_LONG).show();
		displayImage();
	};
	
	
	private void displayImage()
	{
		Bitmap bitmap=null;
		
		TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
		TypedArray imgs_names = getResources().obtainTypedArray(R.array.image_name);

		for (int i=0; i<imgs_names.length(); i++)
		{
			String imageName = imgs_names.getString(i);
			if (imageName.equalsIgnoreCase(nameImage))
			{
				bitmap = BitmapFactory.decodeResource(this.getResources(), imgs.getResourceId(i, -1));
			}
		}
		
		ImageView image = (ImageView) findViewById(R.id.iv_imagem);
		image.setImageBitmap(bitmap);
	}
}
