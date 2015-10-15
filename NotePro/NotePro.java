import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotePro extends Frame{
	private MenuBar bar;
	private Menu file, edit;
	private MenuItem copy, paste, save, exit;
	private TextArea t;
	String s;
	
	public NotePro()
	{
		super("Zakir");
		bar=new MenuBar();
		setMenuBar(bar);
		file=new Menu("File");
		edit=new Menu("Edit");
		copy=new MenuItem("Copy");
		paste=new MenuItem("Paste");
		save=new MenuItem("Save");
		exit=new MenuItem("Exit");
		t=new TextArea();
		bar.add(file);
		bar.add(edit);
		file.add(save);
		file.add(exit);
		edit.add(copy);
		edit.add(paste);
		add(t);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text=t.getText();
				try{
					RandomAccessFile NameFile=new RandomAccessFile("Name.txt", "rw");
					NameFile.seek(NameFile.length());
					NameFile.writeBytes(text);
				}
				catch(IOException ex)
				{
					System.out.println("Can't write");
				}
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
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String args[]){
		new NotePro();
	}
}