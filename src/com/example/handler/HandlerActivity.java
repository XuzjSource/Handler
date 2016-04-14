package com.example.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class HandlerActivity extends Activity {

	private Button startButton;
	private Button endButton;
	private ProgressBar bar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler);
		startButton = (Button) findViewById(R.id.startButton);
		endButton = (Button) findViewById(R.id.endButton);
		
		bar = (ProgressBar)findViewById(R.id.bar);
		
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bar.setVisibility(View.VISIBLE);
				updateBarHandler.post(updateThread);
				
			}
		});
		
		endButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	Handler updateBarHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			bar.setProgress(msg.arg1);
			updateBarHandler.post(updateThread);			
		}
	};
	
	Runnable updateThread = new Runnable(){
		
		int i = 0;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("begin thread");
			i = i+10;
			Message msg = updateBarHandler.obtainMessage();
			msg.arg1 = i;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException c) {
				// TODO Auto-generated catch block
				c.printStackTrace();
			}
			updateBarHandler.sendMessage(msg);
			if(i==100){
				updateBarHandler.removeCallbacks(updateThread);
			}
		}
		
	};
	
	
}
