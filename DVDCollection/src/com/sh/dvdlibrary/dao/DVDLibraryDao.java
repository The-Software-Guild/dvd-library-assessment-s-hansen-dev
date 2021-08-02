package com.sh.dvdlibrary.dao;

import java.util.List;

import com.sh.dvdlibrary.dto.DVD;

public interface DVDLibraryDao {
	
	/**
	 * Adds the given DVD to the collection associated with the given title.
	 * If a DVD with that title already exists, it will return that DVD, otherwise
	 * it will return null.
	 *
	 * @param dvdTitle name of the DVD to be added.
	 * @param dvd DVD to be added to the collection
	 * @return the DVD object previously associated with the given 
	 * title if it exists, null otherwise
	 */
	DVD addDVD(String dvdTitle, DVD dvd);
	
	/**
	 * Returns a list of all DVDs in the collection.
	 * @return List containing all DVDs in the collection.
	 */
	List<DVD> getAllDVDs();
	
	/**
	 * Returns the DVD associated with the given title.
	 * Returns null if the specified DVD does not exist.
	 * 
	 * @param dvdTitle title of DVD to retrieve
	 * @return the DVD associated with the given title,
	 * null if no such DVD exists.
	 */
	DVD getDVD(String dvdTitle);
	
	/**
	 * Remove from the collection the DVD associated 
	 * with the given title. 
	 * Returns the DVD being removed or null if there is 
	 * no DVD associated with the given title.
	 * 
	 * @param dvdTitle title of the DVD to be removed
	 * @return DVD object that was removed or null if no
	 * DVD was associated with the given title.
	 */
	DVD removeDVD(String dvdTitle);
	
	/**
	 * Returns the result of a search for the DVD with a 
	 * given title. 
	 * Returns true if the title exists in the collection, 
	 * otherwise returns false.
	 * 
	 * @param dvdTitle the title of the DVD to search for
	 * @return true if the title exists in the collection, 
	 * otherwise return false
	 */
	boolean searchCollection(String dvdTitle);
	
	/**
	 * Updates the given DVD in the collection associated with the given title.
	 * Return true on a successful update, false otherwise.
	 *
	 * @param dvdTitle name of the DVD to be updated
	 * @param oldDVD DVD to be updated
	 * @param newDVD DVD with new values
	 * @return true on a successful update, false otherwise.
	 */
	boolean updateDVD(String dvdTitle, DVD oldDVD, DVD newDVD);
	
	void loadDVDs();
	
	void saveDVDs();
}
