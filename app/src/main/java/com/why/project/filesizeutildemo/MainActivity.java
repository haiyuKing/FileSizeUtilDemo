package com.why.project.filesizeutildemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.why.project.filesizeutildemo.utils.FileSizeUtil;

import java.io.File;

public class MainActivity extends AppCompatActivity {

	private Button btn_getFolderSize;
	private TextView tv_folderSize;
	private Button btn_getFileSize;
	private TextView tv_fileSize;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();
	}

	private void initViews() {
		btn_getFolderSize = (Button) findViewById(R.id.btn_getFolderSize);
		tv_folderSize = (TextView) findViewById(R.id.tv_folderSize);
		btn_getFileSize = (Button) findViewById(R.id.btn_getFileSize);
		tv_fileSize = (TextView) findViewById(R.id.tv_fileSize);
	}

	private void initEvents() {

		btn_getFolderSize.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String folderPath = Environment.getExternalStorageDirectory().toString() + File.separator + "intentFile";
				Log.w("MainActivity","folderPath="+folderPath);
				String folderSize = FileSizeUtil.getAutoFolderOrFileSize(folderPath);
				tv_folderSize.setText(tv_folderSize.getText() + folderSize);
			}
		});

		btn_getFileSize.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory().toString() + File.separator + "intentFile" + File.separator + "imgdemo.jpg";
				double fileSizeKB = FileSizeUtil.getFolderOrFileSize(filePath,FileSizeUtil.SIZETYPE_KB);
				String fileSize = FileSizeUtil.getAutoFolderOrFileSize(filePath);
				tv_fileSize.setText(tv_fileSize.getText() + "\n" +
										"fileSizeKB=" + fileSizeKB + "\n" +
										"fileSize=" + fileSize);
			}
		});
	}
}
