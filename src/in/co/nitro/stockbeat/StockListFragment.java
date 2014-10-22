package in.co.nitro.stockbeat;

import in.co.nitro.stockbeat.data.ScheduledTask;
import in.co.nitro.stockbeat.data.StockDataCollector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StockListFragment extends Fragment {
	
	// scheduler to execute background task of fetching data from Google
	private ScheduledExecutorService scheduledExecutorService;
	// thread with message queue used for pushing message at defined interval to the background thread
	private StockDataCollector stockDataCollector;
	private static final String COLLECTOR = "Stock Collector"; // thread name
	private static final int INTERVAL = 1; // every 1 minute

	public StockListFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_stocklist,
				container, false);
		return rootView;
	}

	@SuppressLint("NewApi")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		// get the scheduler
		scheduledExecutorService = Executors.newScheduledThreadPool(1);
		// create the thread with message queue
		stockDataCollector = new StockDataCollector(COLLECTOR);
		// schedule background task to which thread with message queue and instrument list reference is passed
		scheduledExecutorService.scheduleWithFixedDelay(new ScheduledTask(stockDataCollector,((StockBeatActivity)getActivity()).getInstrumentList()), 0, INTERVAL, TimeUnit.MINUTES);
	}
}
