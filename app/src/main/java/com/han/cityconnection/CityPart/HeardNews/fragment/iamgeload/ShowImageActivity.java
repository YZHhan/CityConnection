package com.han.cityconnection.CityPart.HeardNews.fragment.iamgeload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.han.cityconnection.R;

public class ShowImageActivity extends Activity {
	private GridView mGridView;
	private List<String> list;
	private ChildAdapter adapter;
	private TextView save;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_image_activity);
		View inflateview = LayoutInflater.from(this).inflate(R.layout.grid_child_item,null);
		save= (TextView) inflateview.findViewById(R.id.wancheng);
		mGridView = (GridView) findViewById(R.id.child_grid);
		list = getIntent().getStringArrayListExtra("data");
		adapter = new ChildAdapter(this, list, mGridView);
		mGridView.setAdapter(adapter);
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<String> backList = new ArrayList<>();
				/*for (int i = 0; i < list.size(); i++) {
					if (list.get(i)) {
						backList.add(list.get(i));
					}
				}*/
				Intent data = new Intent();
				data.putExtra("list", (Serializable) backList);
				setResult(20, data);
				finish();
			}
		});
	}

	@Override
	public void onBackPressed() {
		Toast.makeText(this, "选中" + adapter.getSelectItems().size() + " item", Toast.LENGTH_SHORT).show();
		super.onBackPressed();
	}
	
	

	
}
