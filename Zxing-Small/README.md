'''java
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity{
	
	public static final int REQ_SCAN = 0x01;
	private TextView logTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		logTv = (TextView)findViewById(R.id.address);
	}

	
	public void doSubmit(View view){
		startActivityForResult(new Intent(this,CaptureActivity.class), REQ_SCAN);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQ_SCAN:
			if(resultCode == RESULT_OK) onScanned(data);
			break;
		default:
			super.onActivityResult(requestCode, resultCode, data);
			break;
		}
	}
	
	private void onScanned(Intent data) {
		
		
		Bundle bundle = data.getExtras();
		String resultFormat = bundle.getString(Intents.Scan.RESULT_FORMAT);
		
		if(BarcodeFormat.QR_CODE.toString().equals(resultFormat)){
			logTv.setText(bundle.getString(Intents.Scan.RESULT));
		}
		
		for(String key : bundle.keySet()){
			String line = String.format("Got: %s -> %s", key,bundle.get(key));
			Log.i(TAG, line);
		}
		
		//logTv.setText(sb.toString());
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
'''