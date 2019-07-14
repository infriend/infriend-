package com.jsyunsi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//2736 * 1824
public class Star extends Frame implements ActionListener
{
	public static void main(String[] args)
	{
		new Star();
	}
	
	//���ڴ�С
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_LENGTH = 600;
	//��ȡ��Ļ��С
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenWidth = screenSize.width;
	int screenLength = screenSize.height;
	//������������
	int []coordx = new int [60];
	int []coordy = new int [60];
	//����һ������
	Image image = null;
	//���尴ť
	MenuBar jmb = null;
	Menu jm = null;
	MenuItem jm1 = null;
	MenuItem jm2 = null;
	private boolean printable = true;
	
	
	
	public void update(Graphics g)
	{
		image = this.createImage(FRAME_WIDTH, FRAME_LENGTH);
		Graphics gps = image.getGraphics();
		gps.setFont(new Font("TimesRoman", Font.BOLD, 30));
		for (int i = 0; i < 60; i++)
		{
			int R, G, B;
			R = (int) (Math.random()*255);
			G = (int) (Math.random()*255);
			B = (int) (Math.random()*255);
			gps.setColor(new Color(R, G, B));
					
			gps.drawString("��", coordx[i]++%FRAME_WIDTH, coordy[i]++%FRAME_LENGTH);	
		}
		g.drawImage(image, 0, 0, null);
	}
	
	public Star()
	{
		jmb = new MenuBar();
		jm = new Menu("Stop/Continue");
		jm.setFont(new Font("TimesRoman", Font.BOLD, 15));
		
		jm1 = new MenuItem("Stop");
		jm1.addActionListener(this);
		jm1.setActionCommand("Stop");
		
		jm2 = new MenuItem("Continue");
		jm2.addActionListener(this);
		jm2.setActionCommand("Continue");
		jmb.add(jm);
		jm.add(jm1);
		jm.add(jm2);
		
		this.setMenuBar(jmb);
		for (int i = 0; i < 60; i++)
		{
			coordx[i] = (int) (1 + Math.random()*(800 - 1 + 1));
			coordy[i] = (int) (1 + Math.random()*(600 - 1 + 1));
		}
		this.setBackground(Color.black);
		//���ڿɼ�
		this.setVisible(true);
		//���ô��ڴ�С
		this.setSize(FRAME_WIDTH, FRAME_LENGTH);
		//���ô��ڴ�С���ɱ�
		this.setResizable(false);
		//���ùر�ģʽ
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing (WindowEvent e)
			{
				System.exit(0);
			}
		});
		this.setLocation(screenWidth/2 - FRAME_WIDTH/2, screenLength/2 - FRAME_LENGTH/2);
		
		//�����߳���
		new Thread(new PaintThread()).start();

	}
	private class PaintThread implements Runnable
	{
		public void run()
		{
			while(printable) 
			{
				repaint();
				try 
				{
					Thread.sleep(50);
				}
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Stop"))
		{
			System.out.println("clicked the stop button");
			printable = false;
		}
		if(e.getActionCommand().equals("Continue"))
		{
			System.out.println("clicked the continue button");
			if(!printable)
			{
				printable = true;
				new Thread(new PaintThread()).start();				
			}
		}
	}
}
