import java.util.ArrayList;
import java.util.List;

public class CPUBreaker
{
	private static List<Thread> _threads = new ArrayList<>();
	
	public static void start()
	{
		Thread t;
		
		for (int i = 0; i < 10; i++)
		{
			t = new Thread(new MyThread());
			t.start();
			_threads.add(t);
		}
	}
	
	public static void stop()
	{
		for (Thread t : _threads)
		{
			t.interrupt();
			t = null;
		}
		
		_threads.clear();
	}
	
	private static class MyThread implements Runnable
	{
		@Override
		public void run()
		{
			while (!Thread.currentThread().isInterrupted())
			{
				Math.pow(Math.random(), Math.random());
			}
		}
	}
}