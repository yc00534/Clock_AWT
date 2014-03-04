package Clock_AWT;

import java.awt.BasicStroke;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock_AWT extends Frame implements WindowListener
{

	Calendar			c;
	final static int	radiusUHr	= 150;
	int					y, x, xAussen, yAussen;
	int					korY, korX;
	int					min, grad;
	int					nummerLineDicke;

	public Clock_AWT(String string)
	{
		addWindowListener(this);
		setVisible(true);
		setSize(600, 600);
		x = getWidth() / 2 - radiusUHr;
		y = getHeight() / 2 - radiusUHr;

		yAussen = getHeight() / 2;
		xAussen = getWidth() / 2;

		while (true)
		{
			Graphics g = getGraphics();
			c = new GregorianCalendar();

			try
			{
				Thread.sleep(100);

				// berinigung des GUI
				g.clearRect(0, 0, getWidth(), getHeight());

				// Kreis wird gezeichnet
				g.drawOval(x, y, radiusUHr * 2, radiusUHr * 2);

				// Risiki =)
				zeichneRisiki(135, 1, 150);

				// StrundenZeiger werden gezichnet
				zeichneZeiger(c.get(Calendar.SECOND), 140, 1);
				zeichneZeiger(c.get(Calendar.MINUTE), 120, 3);
				zeichneZeiger((int) (c.get(Calendar.HOUR) * 5 + 1), 80, 5);

			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void zeichneRisiki(int radiusInnen, int nummerLineDicke, int b)
	{
		Graphics g = getGraphics();
		Graphics2D d2 = (Graphics2D) g;

		for (int i = 0; i < 60; i++)
		{
			grad = i * 6;

			korY = -(int) (Math.cos(Math.toRadians(grad)) * radiusInnen);
			korX = (int) (Math.sin(Math.toRadians(grad)) * radiusInnen);

			int korY2 = -(int) (Math.cos(Math.toRadians(grad)) * radiusUHr);
			int korX2 = (int) (Math.sin(Math.toRadians(grad)) * radiusUHr);

			if ((i % 5 == 0))
			{
				d2.setStroke(new BasicStroke(nummerLineDicke + 2));
			} else
			{
				d2.setStroke(new BasicStroke(nummerLineDicke));
			}

			g.drawLine((korY + xAussen), (korX + yAussen), korY2 + yAussen,
					korX2 + xAussen);

		}
	}

	public void zeichneZeiger(int c, int rad, int nummerLineDicke)
	{

		Graphics g = getGraphics();
		Graphics2D d2 = (Graphics2D) g;

		grad = c * 6;

		korY = -(int) (Math.cos(Math.toRadians(grad)) * rad);
		korX = (int) (Math.sin(Math.toRadians(grad)) * rad);

		d2.setStroke(new BasicStroke(nummerLineDicke));
		g.drawLine(xAussen, yAussen, (korX + xAussen), (korY + yAussen));

	}

	public static void main(String[] args)
	{
		new Clock_AWT("Uhr");

	}

	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void windowClosing(WindowEvent e)
	{

		System.exit(0);
	}

	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}
}
