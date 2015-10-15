import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class JNotePro extends JFrame{
	private JMenuBar bar;
	private JMenu file, edit, help;
	private JMenuItem copy, paste, save, exit, about, appen;
	private JTextArea t;
	String s, text, filename;
	
	public JNotePro()
	{
		super("JNotePro");
		
		bar=new JMenuBar();
		
		file=new JMenu("File");
		edit=new JMenu("Edit");
		help=new JMenu("Help");
		
		copy=new JMenuItem("Copy");
		paste=new JMenuItem("Paste");
		save=new JMenuItem("Save as..");
		appen=new JMenuItem("Save");
		exit=new JMenuItem("Exit");
		about=new JMenuItem("About");
		
		t=new JTextArea();
		
		bar.add(file);
		bar.add(edit);
		bar.add(help);
		
		file.add(appen);
		file.add(save);
		file.add(exit);
		
		edit.add(copy);
		edit.add(paste);
		
		help.add(about);
		
		getContentPane().add(new JScrollPane(t));
		
		filename="Default.txt";
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text=t.getText();
				filename=JOptionPane.showInputDialog("Enter the File name and address:");
				
				filename=filename+".txt";
				
				try{
					RandomAccessFile NameFile=new RandomAccessFile(filename, "rw");
					NameFile.seek(NameFile.length());
					NameFile.writeBytes(text);
				}
				catch(IOException ex)
				{
					System.out.println("Can't write");
				}
			}
		});
		
		appen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text=t.getText();
				try{
					RandomAccessFile NameFile=new RandomAccessFile(filename, "rw");
					NameFile.seek(NameFile.length());
					NameFile.writeBytes(text);
				}
				catch(IOException ex)
				{
					System.out.println("Can't write");
				}
				JOptionPane.showMessageDialog(null, "File saved at "+filename);
			}
		});
		
		copy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				s=t.getText()+t.getSelectedText();
			}
		});
		
		paste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				t.setText(s);
			}
		});
		
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "This is a test notepad program, Zakir");
			}
		});
		setJMenuBar(bar);
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String args[]){
		new JNotePro();
	}
}