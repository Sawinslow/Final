import java.util.*;
import java.io.File;
import java.io.IOException;
// Samuel Winslow
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class MusicPlaylist {
	public static void main(String args[]) {
		// Creation of the Classes holding the song information
		Songinfo Thankyounext = new Songinfo();
		Songinfo DancingwithaStranger = new Songinfo();
		Songinfo Hello = new Songinfo();
		Songinfo Sucker = new Songinfo("Sucker", 3.01, 2019, "Pop", "Jonas Brothers");
		Songinfo GirlsLikeYou = new Songinfo("Girls Like You", 3.55, 2018, "Pop", "Adam Levine");
		// Creation of the Queue where all of the songs you choose will be placed
		PriorityQueue<Customer> SongQueue = new PriorityQueue<>();
		Scanner in = new Scanner(System.in);
		// int for the ratings and string for the file path to the songs
		int rating = 0;
		int c;
		String filePath;
		// Info for the songs
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

		// Creation of the linked list
		LinkedList<String> linkedlist = new LinkedList<String>();

		linkedlist.add(Thankyounext.getSongtitle());
		linkedlist.add(DancingwithaStranger.getSongtitle());
		linkedlist.add(Hello.getSongtitle());
		linkedlist.add(Sucker.getSongtitle());
		linkedlist.add(GirlsLikeYou.getSongtitle());

		int songchoice;
		// Loop for the playing the songs
		do {
			// make the selection of which songs you want to listen to.
			System.out.println(linkedlist);
			System.out.println("What Songs would you like to listin to?");
			songchoice = in.nextInt();
			songchoice = songchoice - 1;
			
			int i = songchoice;
			// Allows you to rate the songs for 1 through 5 and if you don't it will select it as 3
			System.out.println("Please Rate Song 1-5 if you don't want to select any other number");
			rating = in.nextInt();
			if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5)
				// adds the song to the queue and will sort it out based on the rating you gave it
				SongQueue.add(new Customer(linkedlist.get(i), rating));
			else {
				rating = 3;
				//If you dont rate it 1 - 5 it will give it a rating of three and add to queue
				SongQueue.add(new Customer(linkedlist.get(i), rating));
			}
			System.out.println("Done? 0 = yes 1 = no");
			// Allows you to say if you are done with the selection
			rating = in.nextInt();
		} while (rating != 0);
		System.out.println(SongQueue.size());
		while (!SongQueue.isEmpty()) {
			// removes from queue and will allow you to play the song and gather the information
			Customer file = SongQueue.remove();
			System.out.println(file);
			// if statements for the songs that you choose and the information followed by playing the song
			if (file.getCustomerID() == Thankyounext.getSongtitle()) {
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\ariana-grande-thank-u-next.wav";
				System.out.println("Songs: " + Thankyounext.getSongtitle());
				System.out.println("Artist: " + Thankyounext.getSongWriter());
				System.out.println("Relase Year: " + Thankyounext.getRelaseYear());
				System.out.println("Lenght of Song: " + Thankyounext.getLenght());
				System.out.println("Genre: " + Thankyounext.getGenre());
			} else if (file.getCustomerID() == DancingwithaStranger.getSongtitle()) {
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\sam-smith-normani-dancing-with-a-stranger.wav";
				System.out.println("Songs: " + DancingwithaStranger.getSongtitle());
				System.out.println("Artist: " + DancingwithaStranger.getSongWriter());
				System.out.println("Relase Year: " + DancingwithaStranger.getRelaseYear());
				System.out.println("Lenght of Song: " + DancingwithaStranger.getLenght());
				System.out.println("Genre: " + DancingwithaStranger.getGenre());
			} else if (file.getCustomerID() == Hello.getSongtitle()) {
				System.out.println("Songs: " + Hello.getSongtitle());
				System.out.println("Artist: " + Hello.getSongWriter());
				System.out.println("Relase Year: " + Hello.getRelaseYear());
				System.out.println("Lenght of Song: " + Hello.getLenght());
				System.out.println("Genre: " + Hello.getGenre());
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\adele-hello-original.wav";
			} else if (file.getCustomerID() == Sucker.getSongtitle()) {
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\jonas-brothers-sucker.wav";
				System.out.println("Songs: " + Sucker.getSongtitle());
				System.out.println("Artist: " + Sucker.getSongWriter());
				System.out.println("Relase Year: " + Sucker.getRelaseYear());
				System.out.println("Lenght of Song: " + Sucker.getLenght());
				System.out.println("Genre: " + Sucker.getGenre());
			} else if (file.getCustomerID() == GirlsLikeYou.getSongtitle()) {
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\maroon-5-girls-like-you-feat-cardi-b.wav";
				System.out.println("Songs: " + GirlsLikeYou.getSongtitle());
				System.out.println("Artist: " + GirlsLikeYou.getSongWriter());
				System.out.println("Relase Year: " + GirlsLikeYou.getRelaseYear());
				System.out.println("Lenght of Song: " + GirlsLikeYou.getLenght());
				System.out.println("Genre: " + GirlsLikeYou.getGenre());
			} else {
				filePath = null;
				System.out.println("Error");
			}

			try {
				//Creates the audioplayer and gives it the file path to play the song
				SongPlayer audioPlayer = new SongPlayer(filePath);

				audioPlayer.play();
				// Scanner sc = new Scanner(System.in);

				while (true) {
					System.out.println("1. pause");
					System.out.println("2. resume");
					System.out.println("3. restart");
					System.out.println("4. next song");
					System.out.println("5. Jump to certain time");
					c = in.nextInt();
					audioPlayer.gotoChoice(c, filePath);
					if (c == 4)
						break;
				}
			}

			catch (Exception ex) {
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
			}
		}
		System.out.println("Out of Songs!!");
	}

}

// SongPlayer Class
class SongPlayer {

	//for current position
	Long currentFrame;
	Clip clip;

	// current status of clip
	String status;

	AudioInputStream audioInputStream;

	String filePath;

	// constructor to initialize streams and clip
	public SongPlayer(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

		// create clip reference
		clip = AudioSystem.getClip();

		// open audioInputStream to the clip
		clip.open(audioInputStream);

		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	// Works as the user enters his choice

	void gotoChoice(int c, String filePath)
			throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		switch (c) {
		case 1:
			pause();
			break;
		case 2:
			resumeAudio(filePath);
			break;
		case 3:
			restart(filePath);
			break;
		case 4:
			stop();
			break;
		case 5:
			System.out.println("Enter time (" + 0 + ", " + clip.getMicrosecondLength() + ")");
			Scanner sc = new Scanner(System.in);
			long c1 = sc.nextLong();
			jump(c1);
			break;

		}

	}

	// Method to play the audio
	public void play() {
		// start the clip
		clip.start();

		status = "play";
	}

	// Method to pause the audio
	public void pause() {
		if (status.equals("paused")) {
			System.out.println("audio is already paused");
			return;
		}
		this.currentFrame = this.clip.getMicrosecondPosition();
		clip.stop();
		status = "paused";
	}

	// Method to resume the audio
	public void resumeAudio(String filePath)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (status.equals("play")) {
			System.out.println("Audio is already " + "being played");
			return;
		}
		clip.close();
		resetAudioStream(filePath);
		clip.setMicrosecondPosition(currentFrame);
		this.play();
	}

	// Method to restart the audio
	public void restart(String filePath) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		clip.stop();
		clip.close();
		resetAudioStream(filePath);
		currentFrame = 0L;
		clip.setMicrosecondPosition(0);
		this.play();
	}

	// Method to stop the audio
	public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		currentFrame = 0L;
		clip.stop();
		clip.close();
	}

	// Method to jump over a specific part
	public void jump(long c) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (c > 0 && c < clip.getMicrosecondLength()) {
			clip.stop();
			clip.close();
			resetAudioStream(filePath);
			currentFrame = c;
			clip.setMicrosecondPosition(c);
			this.play();
		}
	}

	// Method to reset audio stream
	public void resetAudioStream(String filePath)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

}
