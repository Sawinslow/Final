

public class Songinfo {
	String songtitle;
	double Lenght;
	int RelaseYear;
	String Genre;
	String SongWriter;
	
	
	public Songinfo() {
		super();
	}


	public String getSongtitle() {
		return songtitle;
	}


	public void setSongtitle(String songtitle) {
		this.songtitle = songtitle;
	}

	public double getLenght() {
		return Lenght;
	}


	public void setLenght(double lenght) {
		Lenght = lenght;
	}


	public int getRelaseYear() {
		return RelaseYear;
	}


	public void setRelaseYear(int relaseYear) {
		RelaseYear = relaseYear;
	}


	public String getGenre() {
		return Genre;
	}


	public void setGenre(String genre) {
		Genre = genre;
	}


	public String getSongWriter() {
		return SongWriter;
	}


	public void setSongWriter(String songWriter) {
		SongWriter = songWriter;
	}


	public Songinfo(String songtitle, double lenght, int relaseYear, String genre, String songWriter) {
		super();
		this.songtitle = songtitle;
		Lenght = lenght;
		RelaseYear = relaseYear;
		Genre = genre;
		SongWriter = songWriter;
	}


	
	
	
	
	
}
