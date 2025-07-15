package springapp2.gui;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public JTextField name() {
		return new JTextField(15);
	}
	@Bean
	public JTextField email() {
		return new JTextField(15);
	}
	
	@Bean
	public JButton jbutton() {
		return new  JButton();
	}
	
	@Bean
	public Mywin mywin() {
		Mywin win = new Mywin(name(),email(),jbutton());
	
		
		return win;
		
	}

}
