import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game2  extends JPanel
{
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	
	private void moveBall()
	{
		if (x + xa > getWidth() - 30 || x + xa < 0) 
		{
			xa = -xa;
		}
		if (y + ya > getHeight() - 30  || y + ya < 0)
		{
			ya = -ya;
		}
		x = x+xa;
		y = y+ya;
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x, y, 30, 30);;
	}
	public static void main(String[] args) throws InterruptedException
	{
		JFrame  frame = new JFrame("Game2");
		Game2 game2 = new Game2();
		frame.add(game2);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true)
		{
			game2.moveBall();
			game2.repaint();
			Thread.sleep(10);
		}
	}
}
