package com.viniciusmo.countdown;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CountdownDemo extends Activity implements OnClickListener,
		OnCountdownFinish {
	private TextView txtCountdown;
	private Button start;
	private Button stop;
	private CountdownTimer countdownTimer;
	private int SECONDS = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtCountdown = (TextView) findViewById(R.id.countdown);
		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		countdownTimer = new CountdownTimer(this, SECONDS, txtCountdown);
		countdownTimer.setOnCountdownFinish(this);
		countdownTimer.start();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			countdownTimer.start();
			break;
		case R.id.stop:
			countdownTimer.stop();
			break;
		}
	}

	@Override
	public void onCountdownFinish() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				txtCountdown.setText("Finish");
			}
		});
	}
}
