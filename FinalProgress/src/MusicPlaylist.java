import java.util.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class MusicPlaylist {
	public static void main(String args[]) {
		Songinfo Thankyounext = new Songinfo();
		Songinfo DancingwithaStranger = new Songinfo();
		Songinfo Hello = new Songinfo();
		Songinfo Sucker = new Songinfo("Sucker", 3.01, 2019, "Pop", "Jonas Brothers");
		Songinfo GirlsLikeYou = new Songinfo("Girls Like You", 3.55, 2018, "Pop", "Adam Levine");
		PriorityQueue<Customer> SongQueue = new PriorityQueue<>();
		Scanner in = new Scanner(System.in);
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

		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add(Thankyounext.getSongtitle());
		linkedlist.add(DancingwithaStranger.getSongtitle());
		linkedlist.add(Hello.getSongtitle());
		linkedlist.add(Sucker.getSongtitle());
		linkedlist.add(GirlsLikeYou.getSongtitle());
		System.out.println(linkedlist);
		
		int songchoice;
		do {
			System.out.println("What Songs would you like to listin to?");
			songchoice = in.nextInt();
			songchoice = songchoice - 1;
			int i = songchoice;
			System.out.println("Please Rate Song 1-5 if you don't want to select any other number");
			rating = in.nextInt();
			if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5)
				SongQueue.add(new Customer(linkedlist.get(i), rating));
			else {
				rating = 3;
				SongQueue.add(new Customer(linkedlist.get(i), rating));
			}
			System.out.println("Done? 0 = yes 1 = no");
			rating = in.nextInt();
		} while (rating != 0);
		// }
		// }
		System.out.println(SongQueue.size());
		while (!SongQueue.isEmpty()) {
			Customer file = SongQueue.remove();
			System.out.println(file);
			if (file.getCustomerID() == Thankyounext.getSongtitle()) {
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\ariana-grande-thank-u-next.wav";
				System.out.println("Songs: "+Thankyounext.getSongtitle());
				System.out.println("Artist: "+ Thankyounext.getSongWriter());
				System.out.println("Relase Year: "+ Thankyounext.getRelaseYear());
				System.out.println("Lenght of Song: "+ Thankyounext.getLenght());
				System.out.println("Genre: " + Thankyounext.getGenre());
			} else if (file.getCustomerID() == DancingwithaStranger.getSongtitle()) {
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\sam-smith-normani-dancing-with-a-stranger.wav";
				System.out.println("Songs: "+DancingwithaStranger.getSongtitle());
				System.out.println("Artist: "+ DancingwithaStranger.getSongWriter());
				System.out.println("Relase Year: "+ DancingwithaStranger.getRelaseYear());
				System.out.println("Lenght of Song: "+ DancingwithaStranger.getLenght());
				System.out.println("Genre: " + DancingwithaStranger.getGenre());
			} else if (file.getCustomerID() == Hello.getSongtitle()) {
				System.out.println("Songs: "+Hello.getSongtitle());
				System.out.println("Artist: "+ Hello.getSongWriter());
				System.out.println("Relase Year: "+ Hello.getRelaseYear());
				System.out.println("Lenght of Song: "+ Hello.getLenght());
				System.out.println("Genre: " + Hello.getGenre());
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\adele-hello-original.wav";
			} else if (file.getCustomerID() == Sucker.getSongtitle()) {
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\jonas-brothers-sucker.wav";
				System.out.println("Songs: "+Sucker.getSongtitle());
				System.out.println("Artist: "+ Sucker.getSongWriter());
				System.out.println("Relase Year: "+ Sucker.getRelaseYear());
				System.out.println("Lenght of Song: "+ Sucker.getLenght());
				System.out.println("Genre: " + Sucker.getGenre());
			} else if (file.getCustomerID() == GirlsLikeYou.getSongtitle()) {
				filePath = "A:\\Eclipse\\FinalProgress\\src\\Songs\\maroon-5-girls-like-you-feat-cardi-b.wav";
				System.out.println("Songs: "+GirlsLikeYou.getSongtitle());
				System.out.println("Artist: "+ GirlsLikeYou.getSongWriter());
				System.out.println("Relase Year: "+ GirlsLikeYou.getRelaseYear());
				System.out.println("Lenght of Song: "+ GirlsLikeYou.getLenght());
				System.out.println("Genre: " + GirlsLikeYou.getGenre());
			} else {
				filePath = null;
				System.out.println("Error");
			}

			try {

				SongPlayer audioPlayer = new SongPlayer(filePath);

				audioPlayer.play();
				// Scanner sc = new Scanner(System.in);

				while (true) {
					System.out.println("1. pause");
					System.out.println("2. resume");
					System.out.println("3. restart");
					System.out.println("4. next song");
					System.out.println("5. Jump to specific time");
					c = in.nextInt();
					audioPlayer.gotoChoice(c,filePath);
					if (c == 4) 
						break;
				}
				 //in.close();
				// break;
			}

			catch (Exception ex) {
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
				// break;

			}
		}
		System.out.println("Out of Songs!!");

//	public LinkedList<String> getlinkinfo(){
//		
//	return linkedlist.this;
//}


	}

	
}


// Start of Next Class

//Java program to play an Audio 
//file using Clip Object 

class SongPlayer {

	// to store current position
	Long currentFrame;
	Clip clip;

	// current status of clip
	String status;

	AudioInputStream audioInputStream;

	String filePath;

	// constructor to initialize streams and clip
	public SongPlayer(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// create AudioInputStream object
		//Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

		// create clip reference
		clip = AudioSystem.getClip();

		// open audioInputStream to the clip
		clip.open(audioInputStream);

		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	// Work as the user enters his choice

	void gotoChoice(int c,String filePath) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
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
	public void resumeAudio(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
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
	public void resetAudioStream(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

}
