import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Kane extends JFrame implements AutoCloseable {

	private Player player;

	private BufferedInputStream stream;

	public void play(String file) throws JavaLayerException, FileNotFoundException {
		if (player == null) {
			stream = new BufferedInputStream((new FileInputStream(file)));
			player = new Player(stream);
		}
		player.play();
	}

	@Override
	public void close() {
		try {
			if (player != null) {
				player.close();
			}
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 500, 500);
		frame.setVisible(true);
		
		JButton btn = new JButton("鐘かね言うんじゃねえよガキのくせによぉ！？");
		btn.setActionCommand("鐘かね言うんじゃねえよガキのくせによぉ！？");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				switch (cmd) {
				case "鐘かね言うんじゃねえよガキのくせによぉ！？":
					try (Kane kane = new Kane()) {
						for(int i = 0;i <= 108;i++){
							kane.play("nc8370.mp3");
						}
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (JavaLayerException e2) {
						e2.printStackTrace();
					}

					break;
				}
			}
		});
		frame.add(btn);
	}

}
