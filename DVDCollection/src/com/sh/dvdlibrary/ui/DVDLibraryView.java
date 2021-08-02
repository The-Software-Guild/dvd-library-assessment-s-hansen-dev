package com.sh.dvdlibrary.ui;

import java.util.List;

import com.sh.dvdlibrary.dto.DVD;

public class DVDLibraryView {

	private UserIO io = new UserIOConsoleImpl();
	
	public int printMenuAndGetSelection() {
		io.print("Main Menu");
		io.print("1. List DVDs");
		io.print("2. Add DVDs");
		io.print("3. Edit DVDs");
		io.print("4. Remove DVDs");
		io.print("5. View Info for Specific DVD");
		io.print("6. Search for DVD by Title");
		io.print("7. Load DVDs from File");
		io.print("8. Save DVD Collection to File");
		io.print("9. Exit");

		return io.readInt("Please select from the"
				+ " above choices.", 1, 9);
	}
	
	public int printEditMenuAndGetSelection() {
		io.print("Edit Menu");
		io.print("1. Change Title");
		io.print("2. Change Release Date");
		io.print("3. Change MPAA Rating");
		io.print("4. Change Director's Name");
		io.print("5. Change Studio");
		io.print("6. Change User Rating");
		io.print("7. Exit");

		return io.readInt("Please select from the"
				+ " above choices.", 1, 7);
	}
	
	public DVD getNewDVDInfo() {
		String title = io.readString("Please enter DVD Title");
	    String releaseDate = io.readString("Please enter Release Date");
	    String mpaaRating = io.readString("Please enter MPAA Rating");
	    String directorName = io.readString("Please enter Director's Name");
	    String studio = io.readString("Please enter Studio Name");
	    String userRating = io.readString("Please enter User Rating or Note");
	   
	    DVD currentDVD = new DVD(title, releaseDate, mpaaRating, 
	    						 directorName, studio, userRating);
	    
	    return currentDVD;
	}
	
	public void displayAddDVDBanner() {
	    io.print("=== Add DVD ===");
	}
	
	public void displayAddSuccessBanner() {
	    io.readString(
	            "DVD successfully added.  Please hit enter to continue");
	}

//	public void displayDVDList(List<DVD> collection) {
//		for (DVD currentDVD: collection) {
//			String dvdInfo = String.format("%s : Released in %s, Rated %s, "
//					+ "Director(s) %s, Studio %s, %s",
//					currentDVD.getTitle(),
//					currentDVD.getReleaseDate(),
//					currentDVD.getMpaaRating(),
//					currentDVD.getDirectorName(),
//					currentDVD.getStudio(),
//					currentDVD.getUserRating());
//			io.print(dvdInfo);
//		}
//		io.readString("Please hit enter to continue.");
//	}
	
	public void displayDVDTitles(List<DVD> collection) {
		for (DVD currentDVD: collection) {
			String dvdInfo = currentDVD.getTitle();
			io.print(dvdInfo);
		}
		io.readString("Please hit enter to continue.");
		
	}
	
	public String getDVDTitleChoice() {
	    return io.readString("Please enter the DVD title.");
	}
	
	// display
	public void displayDisplayAllBanner() {
	    io.print("=== Display All DVDs ===");
	}
	
	public void displayDisplayDVDBanner () {
	    io.print("=== Display DVD ===");
	}
	
	public void displayDVD(DVD dvd) {
	    if (dvd != null) {
	        io.print(dvd.getTitle());
	        io.print("Released in " + dvd.getReleaseDate());
	        io.print("Rated " + dvd.getMpaaRating());
	        io.print("Directors are " + dvd.getDirectorName());
	        io.print("Produced by " + dvd.getStudio());
	        io.print("Notes: " + dvd.getUserRating());
	        io.print("");
	    } else {
	        io.print("No such DVD.");
	    }
	    io.readString("Please hit enter to continue.");
	}
	
	// remove
	public void displayRemoveDVDBanner () {
	    io.print("=== Remove DVD ===");
	}
	
	public void displayRemoveResult(DVD dvdRecord) {
	    if(dvdRecord != null){
	      io.print("DVD successfully removed.");
	    } else {
	      io.print("No such DVD.");
	    }
	    io.readString("Please hit enter to continue.");
	}
	
	// search
	public void displaySearchDVDBanner() {
		io.print("=== Seach DVD Collection ===");
	}

	public void displaySearchResult(boolean dvdFound) {
		if (dvdFound) {
			io.print("This DVD exists in the collection.");
		} else {
			io.print("This DVD does not exist in the collection.");
		}
		io.readString("Please hit enter to continue.");
	}
	
	// edit
	public void displayEditDVDBanner() {
		 io.print("=== Edit DVD ===");
	}
	
	public void displayCannotEdit() {
		io.print("A DVD by this name does not exist in the collection.");
	}
	
	public void updateSuccess() {
		io.print("DVD update successful.");
	}
	
	public void displayEditTitleBanner() {
		 io.print("=== Edit DVD Title ===");
	}
	
	public String getNewTitle() {
		return io.readString("Please enter the new DVD title.");
	}
	
	public void displayEditRDBanner() {
		 io.print("=== Edit Release Date ===");
	}
	
	public String getNewReleaseDate() {
		return io.readString("Please enter the new release date.");
	}
	
	public void displayEditMpaaBanner() {
		io.print("=== Edit MPAA Rating ===");
	}
	
	public String getNewMpaaRating() {
		return io.readString("Please enter the new MPAA rating.");
	}
	
	public void displayEditDirectorBanner() {
		io.print("=== Edit Director Name ===");
	}
	
	public String getNewDirectorName() {
		return io.readString("Please enter the new director.");
	}
	
	public void displayEditStudioBanner() {
		io.print("=== Edit Studio ===");
	}
	
	public String getNewStudio() {
		return io.readString("Please enter the new studio.");
	}
	
	public void displayEditUserRatingBanner() {
		io.print("=== Edit User Rating ===");
	}
	
	public String getNewUserRating() {
		return io.readString("Please enter the new user rating.");
	}
	
	public void displayUnknownCommand() {
		io.print("Sorry, I don't recognize that command.");
	}
	
	// file io
	public void displaySaveDVDs() {
		io.print("=== Saving DVD Collection ===");
	}
	
	public void displayLoadDVDs() {
		io.print("=== Loading DVD Collection ===");
	}
	
	public void displaySaveComplete() {
		io.print("Your DVD library has been saved!");
	}
	
	public void displayLoadComplete() {
		io.print("Your DVD library has been loaded!");
	}
	
	
}
