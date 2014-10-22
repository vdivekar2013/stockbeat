package in.co.nitro.stockbeat.data;

import java.util.List;

import android.os.Message;

// this class is triggered at every defined interval by the scheduler
public class ScheduledTask implements Runnable {

	private List<Instrument> instrumentList;
	private StockDataCollector stockDataCollector;

	public ScheduledTask( StockDataCollector stockDataCollector,List<Instrument> instrumentList) {
		this.stockDataCollector = stockDataCollector;
		this.instrumentList = instrumentList;
	}
	@Override
	public void run() {
		if(null != stockDataCollector) {
			// create and attach handler to the stock collector thread
			StockDataCollector.StockDataHandler stockDataHandler = new StockDataCollector.StockDataHandler(stockDataCollector.getLooper());
			Message message =Message.obtain();
			// instrument list is passed through the general purpose object
			message.obj = instrumentList;
			// send the message which will be executed on handle-Message method of the handler
			stockDataHandler.sendMessage(message);
		}
	}

}
