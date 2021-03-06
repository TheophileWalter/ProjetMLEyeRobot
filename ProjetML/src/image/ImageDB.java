/**
 * Class ImageDB
 * 
 * Represents a standardized set of Images.
 * Iteratable.
 * 
 * @author Jules Pénuchot, Théophile Walter
 */

package image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import image.Image;

public class ImageDB implements Iterable<Image>, Iterator<Image> {

	private ArrayList<Image> imDB;
	private int count = -1;

	/**
	 * Create the database from an ArrayList
	 */
	public ImageDB(ArrayList<Image> db) {
		// Copy the value, not only the pointers
		imDB = new ArrayList<Image>(db);
	}

	/**
	 * Create a void database
	 */
	public ImageDB() {
		imDB = new ArrayList<Image>();
	}

	/**
	 * Add an image to the database
	 */
	public void add(Image img) {
		imDB.add(img);
	}

	/**
	 * Remove an image from the database
	 */
	public Image remove(int index) {
		return imDB.remove(index);
	}

	/**
	 * Return the size of the database
	 */
	public int size() {
		return imDB.size();
	}
	
	/**
	 * Return the image at index position
	 */
	public Image get(int index) {
		return imDB.get(index);
	}

	/**
	 * Methods for iteration
	 */
	@Override
	public boolean hasNext() {
		return count < imDB.size() - 1;
	}

	@Override
	public Image next() {
		if (count == imDB.size() - 1)
			throw new NoSuchElementException();
		count++;
		return imDB.get(count);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<Image> iterator() {
		count = -1; // Reset the counter
		return this;
	}

}
