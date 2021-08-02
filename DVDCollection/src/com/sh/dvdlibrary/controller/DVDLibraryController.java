package com.sh.dvdlibrary.controller;

import java.util.List;

import com.sh.dvdlibrary.dao.DVDLibraryDao;
import com.sh.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sh.dvdlibrary.dto.DVD;
import com.sh.dvdlibrary.ui.DVDLibraryView;
import com.sh.dvdlibrary.ui.UserIO;
import com.sh.dvdlibrary.ui.UserIOConsoleImpl;

/**
 * In this assessment, you will create a program that stores information about a DVD collection. 
 * The program must do the following:
 * Allow the user to add a DVD to the collection
 * Allow the user to remove a DVD from the collection
 * Allow the user to edit the information for an existing DVD in the collection
 * Allow the user to list the DVDs in the collection
 * Allow the user to display the information for a particular DVD
 * Allow the user to search for a DVD by title
 * Load the DVD library from a file
 * Save the DVD library back to the file when the program completes
 * Allow the user to add, edit, or delete many DVDs in one session
 * @author sarahhansen
 */

public class DVDLibraryController {
	
	private DVDLibraryView view = new DVDLibraryView();
	private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
	private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
        	
        	menuSelection = getMenuSelection();
 
            switch (menuSelection) {
                case 1:
                    listDVDs();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    editMenu();                 
                    break;
                case 4:
                    removeDVD();
                    break;
                case 5:
                	viewDVD();
                	break;
                case 6:
                	searchDVD();
                	break;
                case 7:
                	loadDVDs();
                	break;
                case 8:
                	saveDVDs();
                	break;
                case 9:
                    keepGoing = false;
                    break;
                default:
                    view.displayUnknownCommand();
            }

        }
        io.print("GOOD BYE");
    }
    
    private void editMenu() {
    	int editMenuSelection = 0;
    	view.displayEditDVDBanner();
    	boolean stillEditing = true;
        while (stillEditing) {
        	editMenuSelection = getEditMenuSelection();
        	
        	String title = "";
        	if (editMenuSelection < 7) {
        		title = view.getDVDTitleChoice();
        	}
        	
        	DVD editMe = dao.getDVD(title);
      
        	if (editMe == null && editMenuSelection < 7) {
        		view.displayCannotEdit();
        		stillEditing = false;
        		break;
        	}
        	
        	switch (editMenuSelection) {
        	case 1:
        		editTitle(editMe);
        		break;
        	case 2:
        		editReleaseDate(editMe);
        		break;
        	case 3:
        		editMpaaRating(editMe);
        		break;
        	case 4:
        		editDirectorName(editMe);
        	case 5:
        		editStudio(editMe);
        	case 6:
        		editUserRating(editMe);
        	case 7:
        		stillEditing = false;
        		break;
        	default:
        		view.displayUnknownCommand();
        	}
        }
    }

	private int getEditMenuSelection() {
		return view.printEditMenuAndGetSelection();
	}

	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}
	
	private void createDVD() {
		view.displayAddDVDBanner();
		DVD newDVD = view.getNewDVDInfo();
		dao.addDVD(newDVD.getTitle(), newDVD);
		view.displayAddSuccessBanner();
	}
	
	private void listDVDs() {
		view.displayDisplayAllBanner();
		List<DVD> dvdList = dao.getAllDVDs();
		view.displayDVDTitles(dvdList);
	}
	
	private void viewDVD() {
		view.displayDisplayDVDBanner();
		String dvdTitle = view.getDVDTitleChoice();
		DVD dvd = dao.getDVD(dvdTitle);
		view.displayDVD(dvd);
	}
	
	private void removeDVD() {
		view.displayRemoveDVDBanner();
		String dvdTitle = view.getDVDTitleChoice();
		DVD removedDVD = dao.removeDVD(dvdTitle);
		view.displayRemoveResult(removedDVD);
	}
	
	private void searchDVD() {
		view.displaySearchDVDBanner();
		String dvdTitle = view.getDVDTitleChoice();
		boolean searchResult = dao.searchCollection(dvdTitle);
		view.displaySearchResult(searchResult);
	}
	
	// edit functions
	private void editTitle(DVD updateMe) {
		view.displayEditTitleBanner();
		String newTitle = view.getNewTitle();
		String oldTitle = updateMe.getTitle();
		updateMe.setTitle(newTitle);
		dao.removeDVD(oldTitle);
		dao.addDVD(newTitle, updateMe);
		view.updateSuccess();
	}
	
	private void editReleaseDate(DVD updateMe) {
		view.displayEditRDBanner();
		String newRD = view.getNewReleaseDate();
		String title = updateMe.getTitle();
		// use copy constructor
		DVD newContent = new DVD(updateMe);
		// update relevant info
		newContent.setReleaseDate(newRD);
		// replace
		dao.updateDVD(title, updateMe, newContent);
		view.updateSuccess();
	}
	
	private void editMpaaRating(DVD updateMe) {
		view.displayEditMpaaBanner();
		String newMpaaRating = view.getNewMpaaRating();
		String title = updateMe.getTitle();
		// use copy constructor
		DVD newContent = new DVD(updateMe);
		// update relevant info
		newContent.setMpaaRating(newMpaaRating);
		// replace
		dao.updateDVD(title, updateMe, newContent);
		view.updateSuccess();
	}
	
	private void editDirectorName(DVD updateMe) {
		view.displayEditDirectorBanner();
		String newDirector = view.getNewDirectorName();
		String title = updateMe.getTitle();
		// use copy constructor
		DVD newContent = new DVD(updateMe);
		// update relevant info
		newContent.setDirectorName(newDirector);
		// replace
		dao.updateDVD(title, updateMe, newContent);
		view.updateSuccess();
	}
	
	private void editStudio(DVD updateMe) {
		view.displayEditStudioBanner();
		String newStudio = view.getNewStudio();
		String title = updateMe.getTitle();
		// use copy constructor
		DVD newContent = new DVD(updateMe);
		// update relevant info
		newContent.setStudio(newStudio);
		// replace
		dao.updateDVD(title, updateMe, newContent);
		view.updateSuccess();
	}
	
	private void editUserRating(DVD updateMe) {
		view.displayEditUserRatingBanner();
		String newUserRating = view.getNewUserRating();
		String title = updateMe.getTitle();
		// use copy constructor
		DVD newContent = new DVD(updateMe);
		// update relevant info
		newContent.setUserRating(newUserRating);
		// replace
		dao.updateDVD(title, updateMe, newContent);
		view.updateSuccess();
	}
	
	private void saveDVDs() {
		view.displaySaveDVDs();
		dao.saveDVDs();
		view.displaySaveComplete();
	}
	
	private void loadDVDs() {
		view.displayLoadDVDs();
		dao.loadDVDs();
		view.displayLoadComplete();
	}
}
