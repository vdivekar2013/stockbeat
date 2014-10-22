package in.co.nitro.stockbeat.data;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class StockDataCollector extends HandlerThread {
	
	public StockDataCollector(String name) {
		super(name);
	}
	
	public static class StockDataHandler extends Handler {

		// method where actual communication with Google will occur
		@Override
		public void handleMessage(Message msg) {
			// place code here to fetch data from Google
			// After getting data, post message to the main looper for the UI to update
			super.handleMessage(msg);
		}

		public StockDataHandler(Looper looper) {
			super(looper);
		}
		
	}

}
