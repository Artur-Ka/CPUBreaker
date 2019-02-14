import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BreakerFrame extends JFrame
{
	private static final long serialVersionUID = -3073949441356796615L;

	public BreakerFrame()
	{
		setTitle("CPUBreaker v 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		final JLabel statusLabel = new JLabel("Статус: ");
		final JLabel status = new JLabel("остановлено");
		
		final JButton start = new JButton("Старт");
		start.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				status.setText("запущено");
				CPUBreaker.start();
			}
		});
		
		final JButton stop = new JButton("Стоп");
		stop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				status.setText("остановлено");
				CPUBreaker.stop();
			}
		});
		
		add(statusLabel);
		add(status);
		add(start);
		add(stop);
		
		pack();
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new BreakerFrame().setVisible(true);
			}
		});
	}
}