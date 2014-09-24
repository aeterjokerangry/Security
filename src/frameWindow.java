import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class frameWindow extends JFrame{
	public TextField playerPath;
	public TextField filePath;
	private JButton button1;
	private JButton button2;
	public String fileLocation;	// file location
	
	frameWindow() {
		fileLocation = null;
		
		// Frame setting
		this.setTitle("Computer Security Homework");
		this.setSize(450, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		
		// Movie Player Location UI  
		// button setting
		button1 = new JButton("Player");
		button1.setSize(100, 30);
		button1.setLocation(10, 10);
		button1.addActionListener(new buttonActionListener(button1.getText()));
		this.add(button1);
		// text area setting
		playerPath = new TextField(fileLocation);
		playerPath.setSize(300, 30);
		playerPath.setLocation(120, 10);
		this.add(playerPath);
		
		
		// File Location UI
		// button setting
		button2 = new JButton("File");		
		button2.setSize(100, 30);
		button2.setLocation(10, 60);
		button2.addActionListener(new buttonActionListener(button2.getText()));
		this.add(button2);
		// text area setting
		filePath = new TextField(fileLocation);
		filePath.setSize(300, 30);
		filePath.setLocation(120, 60);
		this.add(filePath);	
	}

	// button action listener inner class
	public class buttonActionListener implements ActionListener {
		
		private String fileSpec;		// file extention string
		
		buttonActionListener(String fileSpec) {
			setFileSpec(fileSpec);
		}
		
		public void actionPerformed(ActionEvent e) {
			
			// file chooser code
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "desktop"));
			
			FileNameExtensionFilter filter = null;
			if (fileSpec == "Player") {
				filter = new FileNameExtensionFilter("exe File", "exe");
			} else if (fileSpec == "File") {
				filter = new FileNameExtensionFilter("avi File", "avi");
			} else {
				filter = new FileNameExtensionFilter("all File");
			}
			
			fileChooser.addChoosableFileFilter(filter);
			
			frameWindow window = new frameWindow();
			int result = fileChooser.showOpenDialog(window);
			//System.out.println(result);
			
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				fileLocation = selectedFile.getPath();
				System.out.println(fileLocation);
				
				
				if (fileSpec == "Player") {
					playerPath.setText(fileLocation);
					playerPath.setVisible(true);
					System.out.println(playerPath.getText());
				} else if (fileSpec == "File") {
					filePath.setText(fileLocation);
					filePath.setVisible(true);
					System.out.println(filePath.getText());
				}
				
			}
			// file chooser code end
			
		}
		
		String getFileLocation() { return fileLocation;}
		void setFileSpec(String fileSpec) { this.fileSpec = fileSpec; }
	}
	
}
