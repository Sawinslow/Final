import java.awt.Component;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.swing.JTextField;

public class MusicDriver {

	private JFrame frmMusicPlaylist;
	private JTextField Ratingtxtfield;
	static LinkedList<String> linkedlist = new LinkedList<String>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicDriver window = new MusicDriver();
					window.frmMusicPlaylist.setVisible(true);
					
					Songinfo Thankyounext = new Songinfo();
					Songinfo DancingwithaStranger = new Songinfo();
					Songinfo Hello = new Songinfo();
					Songinfo Sucker = new Songinfo("Sucker", 3.01, 2019, "Pop", "Jonas Brothers");
					Songinfo GirlsLikeYou = new Songinfo("Girls Like You", 3.55, 2018, "Pop", "Adam Levine");
					PriorityQueue<Customer> SongQueue = new PriorityQueue<>();
					int rating = 0;
					int c;
					String filePath;
					Thankyounext.setGenre("Pop");
					Thankyounext.setRelaseYear(2018);
					Thankyounext.setSongtitle("Thank U, Next");
					Thankyounext.setSongWriter("Ariana Grande");
					Thankyounext.setLenght(3.27);

					DancingwithaStranger.setGenre("R&B");
					DancingwithaStranger.setLenght(2.5);
					DancingwithaStranger.setRelaseYear(2019);
					DancingwithaStranger.setSongtitle("Dancing with a Stranger");
					DancingwithaStranger.setSongWriter("Sam Smith");

					Hello.setGenre("Soul");
					Hello.setLenght(4.55);
					Hello.setRelaseYear(2015);
					Hello.setSongtitle("Hello");
					Hello.setSongWriter("Adele");

//					linkedlist.add(Thankyounext.getSongtitle());
//					linkedlist.add(DancingwithaStranger.getSongtitle());
//					linkedlist.add(Hello.getSongtitle());
//					linkedlist.add(Sucker.getSongtitle());
//					linkedlist.add(GirlsLikeYou.getSongtitle());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MusicDriver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMusicPlaylist = new JFrame();
		frmMusicPlaylist.setTitle("Music Playlist");
		frmMusicPlaylist.setBounds(100, 100, 491, 325);
		frmMusicPlaylist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicPlaylist.getContentPane().setLayout(null);
		
		JLabel ArtistLbl = new JLabel("Artist:");
		ArtistLbl.setBounds(316, 75, 46, 14);
		frmMusicPlaylist.getContentPane().add(ArtistLbl);
		
		JLabel ArtistInfolbl = new JLabel("Artist Info");
		ArtistInfolbl.setBounds(372, 75, 81, 14);
		frmMusicPlaylist.getContentPane().add(ArtistInfolbl);
		
		JLabel Genrelbl = new JLabel("Genre:");
		Genrelbl.setBounds(316, 100, 46, 14);
		frmMusicPlaylist.getContentPane().add(Genrelbl);
		
		JLabel GenreInfolbl = new JLabel("Genre Info");
		GenreInfolbl.setBounds(372, 100, 81, 14);
		frmMusicPlaylist.getContentPane().add(GenreInfolbl);
		
		JLabel ReleaseYearlbl = new JLabel("Release Year:");
		ReleaseYearlbl.setBounds(302, 125, 67, 14);
		frmMusicPlaylist.getContentPane().add(ReleaseYearlbl);
		
		JLabel ReleaseInfolbl = new JLabel("Release Info");
		ReleaseInfolbl.setBounds(372, 125, 67, 14);
		frmMusicPlaylist.getContentPane().add(ReleaseInfolbl);
		
		JLabel SongLenghtlbl = new JLabel("Song Lenght:");
		SongLenghtlbl.setBounds(302, 150, 81, 14);
		frmMusicPlaylist.getContentPane().add(SongLenghtlbl);
		
		JLabel Songlengthinfolbl = new JLabel("SongLengthInfo");
		Songlengthinfolbl.setBounds(372, 150, 93, 14);
		frmMusicPlaylist.getContentPane().add(Songlengthinfolbl);
		
		JLabel Titlelbl = new JLabel("Title");
		Titlelbl.setBounds(164, 19, 97, 32);
		frmMusicPlaylist.getContentPane().add(Titlelbl);
		
		String[] trywork = {"hello", "plz work" };
		//Songslist.add
		
		JButton Playbtn = new JButton("Play");
		Playbtn.addMouseListener(new MouseAdapter() {
			@Override
			// This is the play button that will take in the jlist for selection 
			public void mouseClicked(MouseEvent arg0) {
//				SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer(filePath);
//				play();
			}
		});
		Playbtn.setBounds(134, 213, 89, 23);
		frmMusicPlaylist.getContentPane().add(Playbtn);
		
		JButton Pausebtn = new JButton("Pause");
		Pausebtn.setBounds(39, 213, 89, 23);
		frmMusicPlaylist.getContentPane().add(Pausebtn);
		
		JButton Skipbtn = new JButton("Skip");
		Skipbtn.setBounds(233, 213, 89, 23);
		frmMusicPlaylist.getContentPane().add(Skipbtn);
		
		JTextPane SelectedList = new JTextPane();
		SelectedList.setEditable(false);
		SelectedList.setBounds(144, 60, 117, 104);
		
		
		frmMusicPlaylist.getContentPane().add(SelectedList);
		
		Ratingtxtfield = new JTextField();
		Ratingtxtfield.setBounds(120, 188, 86, 20);
		frmMusicPlaylist.getContentPane().add(Ratingtxtfield);
		Ratingtxtfield.setColumns(10);
		
		JLabel lblSelect = new JLabel("Please Rate:");
		lblSelect.setBounds(52, 191, 76, 14);
		frmMusicPlaylist.getContentPane().add(lblSelect);
		
		JButton ThankUNextbtn = new JButton("Thank U, Next");
		ThankUNextbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		ThankUNextbtn.setBounds(0, 26, 101, 18);
		frmMusicPlaylist.getContentPane().add(ThankUNextbtn);
		
		JButton Dancingwithastrangerbtn = new JButton("Dancing with a Stranger");
		Dancingwithastrangerbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Dancingwithastrangerbtn.setBounds(0, 60, 147, 14);
		frmMusicPlaylist.getContentPane().add(Dancingwithastrangerbtn);
		
		JButton Hellobtn = new JButton("Hello");
		Hellobtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Hellobtn.setBounds(0, 85, 67, 23);
		frmMusicPlaylist.getContentPane().add(Hellobtn);
		
		JButton Suckerbtn = new JButton("Sucker");
		Suckerbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Suckerbtn.setBounds(0, 119, 89, 23);
		frmMusicPlaylist.getContentPane().add(Suckerbtn);
		
		JButton GirlsLikeYoubtn = new JButton("Girls Like You");
		GirlsLikeYoubtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GirlsLikeYoubtn.setBounds(0, 153, 101, 23);
		frmMusicPlaylist.getContentPane().add(GirlsLikeYoubtn);
	}
}
