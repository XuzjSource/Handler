package com.example.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button button;
	private TextView textView;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.buttonId);
		textView = (TextView) findViewById(R.id.textViewId);
		handler = new MyHandler();
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread t = new NetThread();
				t.start();
			}
		});
	}

	class MyHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			String temp = (String)msg.obj;
			textView.setText(textView.getText()+" "+temp);
		}
	}
	class NetThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000);
			} catch (InterruptedException c) {
				// TODO Auto-generated catch block
				c.printStackTrace();
			}
			Message msg = handler.obtainMessage();
			msg.obj="today is nice";
			handler.sendMessage(msg);
		}
	}
}
