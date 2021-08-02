package com.sh.dvdlibrary.dto;

public class DVD {
	
	// fields 
	private String title;
	private String releaseDate;
	private String mpaaRating;
	private String directorName;
	private String studio;
	private String userRating;
	
	// constructors
	// all args
	public DVD(String title, String releaseDate, String mpaaRating, 
			   String directorName, String studio, String userRating) {
		this.setTitle(title);
		this.setReleaseDate(releaseDate);
		this.setMpaaRating(mpaaRating);
		this.setDirectorName(directorName);
		this.setStudio(studio);
		this.setUserRating(userRating);
	}	
	
	//copy 
	public DVD(DVD another) {
		this.title = another.title;
		this.releaseDate = another.releaseDate;
		this.mpaaRating = another.mpaaRating;
		this.directorName = another.directorName;
		this.studio = another.studio;
		this.userRating = another.userRating;
	}
	
	public DVD(String title) {
		this.setTitle(title);
	}
	
	// getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMpaaRating() {
		return mpaaRating;
	}

	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
	
	// other methods
	public String toString() {
		return getTitle() + ", " +getReleaseDate() + ", " + getMpaaRating() + ", " + 
			   getDirectorName() + ", " + getStudio() + ", " + getUserRating();
	}

}
