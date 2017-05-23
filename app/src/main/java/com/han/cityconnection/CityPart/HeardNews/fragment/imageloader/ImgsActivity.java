package com.han.cityconnection.CityPart.HeardNews.fragment.imageloader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.han.cityconnection.CityPart.HeardNews.Entity.Photobean;
import com.han.cityconnection.CityPart.HeardNews.contract.HeaderNewContract;
import com.han.cityconnection.R;
import com.han.cityconnection.config.Parameter;
import com.han.cityconnection.config.Urls;
import com.han.cityconnection.persenteer.header.HeaderParsenterImpl;

import org.json.JSONException;
import org.json.JSONObject;

public class ImgsActivity extends Activity implements HeaderNewContract.photoview{
	Bundle bundle;
	FileTraversal fileTraversal;
	GridView imgGridView;
	ImgsAdapter imgsAdapter;
	LinearLayout select_layout;
	Util util;
	RelativeLayout relativeLayout2;
	HashMap<Integer, ImageView> hashImage;
	Button choise_button;
	ArrayList<String> filelist;
	private HeaderParsenterImpl headerParsenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photogrally);
		headerParsenter=new HeaderParsenterImpl(this);
		imgGridView=(GridView) findViewById(R.id.gridView1);
		bundle= getIntent().getExtras();
		fileTraversal=bundle.getParcelable("data");
		imgsAdapter=new ImgsAdapter(this, fileTraversal.filecontent,onItemClickClass);
		imgGridView.setAdapter(imgsAdapter);
		select_layout=(LinearLayout) findViewById(R.id.selected_image_layout);
		relativeLayout2=(RelativeLayout) findViewById(R.id.relativeLayout2);
		choise_button=(Button) findViewById(R.id.button3);
		hashImage=new HashMap<Integer, ImageView>();
		filelist=new ArrayList<String>();
//		imgGridView.setOnItemClickListener(this);
		util=new Util(this);
	}

	@Override
	public void fabuphoto(Photobean photobean) {
		Toast.makeText(this, "发布成功。。。。。。", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showErrorImage() {

	}

	@Override
	public void showErrorMsg(String msg) {

	}

	@Override
	public void showProgressDialog() {

	}

	@Override
	public void turnVideoPlay() {

	}

	@Override
	public void turnDetailInfor() {

	}

	@Override
	public void LoadMore() {

	}

	@Override
	public void LoadRefresh() {

	}

	@Override
	public void showActionBarStyle() {

	}

	class BottomImgIcon implements OnItemClickListener{
		
		int index;
		public BottomImgIcon(int index) {
			this.index=index;
		}
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
		}
	}
	
	@SuppressLint("NewApi")
	public ImageView iconImage(String filepath,int index,CheckBox checkBox) throws FileNotFoundException{
		LayoutParams params=new LayoutParams(relativeLayout2.getMeasuredHeight()-10, relativeLayout2.getMeasuredHeight()-10);
		ImageView imageView=new ImageView(this);
		imageView.setLayoutParams(params);
		//imageView.setBackgroundResource(R.drawable.imgbg);
		float alpha=100;
		imageView.setAlpha(alpha);
		util.imgExcute(imageView, imgCallBack, filepath);
		imageView.setOnClickListener(new ImgOnclick(filepath,checkBox));
		return imageView;
	}
	
	ImgCallBack imgCallBack=new ImgCallBack() {
		@Override
		public void resultImgCall(ImageView imageView, Bitmap bitmap) {
			imageView.setImageBitmap(bitmap);
		}
	};
	
	class ImgOnclick implements OnClickListener{
		String filepath;
		CheckBox checkBox;
		public ImgOnclick(String filepath,CheckBox checkBox) {
			this.filepath=filepath;
			this.checkBox=checkBox;
		}
		@Override
		public void onClick(View arg0) {
			checkBox.setChecked(false);
			select_layout.removeView(arg0);
			choise_button.setText("选中("+select_layout.getChildCount()+")张图片");
			filelist.remove(filepath);
		}
	}
	
	ImgsAdapter.OnItemClickClass onItemClickClass=new ImgsAdapter.OnItemClickClass() {
		@Override
		public void OnItemClick(View v, int Position, CheckBox checkBox) {
			String filapath=fileTraversal.filecontent.get(Position);
			if (checkBox.isChecked()) {
				checkBox.setChecked(false);
				select_layout.removeView(hashImage.get(Position));
				filelist.remove(filapath);
				choise_button.setText("选中("+select_layout.getChildCount()+")张图片");
			}else {
				try {
					checkBox.setChecked(true);
					Log.i("img", "img choise position->"+Position);
					ImageView imageView=iconImage(filapath, Position,checkBox);
					if (imageView !=null) {
						hashImage.put(Position, imageView);
						filelist.add(filapath);
						select_layout.addView(imageView);
						choise_button.setText("选中("+select_layout.getChildCount()+")张图片");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	public void tobreak(View view){
		finish();
	}

	public void sendfiles(View view){
		Map<String,String> map=new HashMap<>();
		String s = creatParamsAdd();
		map.put("param",s);
		headerParsenter.fabuphootos(Urls.APPURL,map);
		/*Intent intent =new Intent(this, MainActivity.class);
		Bundle bundle=new Bundle();
		bundle.putStringArrayList("files", filelist);
		intent.putExtras(bundle);
		startActivity(intent);*/
		
	}
	private String creatParamsAdd() {
		JSONObject jo = new JSONObject();
		try {
			jo.put("usiteID", 2422);
			jo.put("siteID", 2422);
				jo.put("content", "||");
			String images = "";
			for (int i = 0; i < filelist.size(); i++) {
				if (i == 0) {
					images = filelist.get(i);
				} else {
					images = images + "," + filelist.get(i);
				}
			}
			jo.put("image", images);
			jo.put("gambitID", 0);
			jo.put("type", 2);
			jo.put("uID", "28833985");
			jo.put("userName", "sid155010541546617");
			jo.put("source", 2);
				jo.put("mapPoint", "4.9E-324,4.9E-324");
			jo.put("Method","PHSocket_SetTieBaAdd");
			jo.put("requestTime","2017-05-22 11:37:59");
			jo.put("customerKey","707094296CE6AB0D3BA0A577A67D0612");
			String str = "";
			jo.put("vcID", str);
			String aite = "";
			jo.put("atname", aite);
			jo.put("audio", "");
			jo.put("audioTime", 0);
			jo.put("PhoneId","866622010080020");
			jo.put("System_VersionNo","Android 4.4.2");
			jo.put("UserId",28833985);
			jo.put("PhoneNum","");
			jo.put("SystemNo",2);
			jo.put("PhoneNo","Lenovo Z90-3");
			jo.put("SiteId",2422);
			jo.put("customerID",8001);
			jo.put("version","4.6");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return Parameter.createnewsParam(
				Urls.PHSocket_SetTieBaAdd, jo);
	}

}
