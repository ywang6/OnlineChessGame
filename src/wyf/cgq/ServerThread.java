package wyf.cgq;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;
public class ServerThread extends Thread
{
	Server father; //����Server������
	ServerSocket ss;//����ServerSocket������
	boolean flag=true;
	public ServerThread(Server father)
	{//������
		this.father=father;
		ss=father.ss;
	}
	public void run()
	{
		while(flag)
		{
			try
			{
				Socket sc=ss.accept();//�ȴ��ͻ�������
				ServerAgentThread sat=new ServerAgentThread(father,sc);
				sat.start();//���������������������߳�
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}