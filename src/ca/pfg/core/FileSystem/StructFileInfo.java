
package ca.pfg.core.FileSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class StructFileInfo {
	
	private String fileName;
	private String fileLocation;
	private String fileExtension;
	private boolean isDirectory;
	private ArrayList<StructFileInfo> dirContent;
	
	/**
	 * @param fileName The name of the file without extension.
	 * @param fileLocation The location of the file without the fully file name.
	 * @param fileExtension The extension of the file without the '.'.
	 * @param isDirectory True if the file is a directory.
	 */
	public StructFileInfo( String fileName, String fileLocation,
			String fileExtension, boolean isDirectory ) {
		super();
		this.fileName = fileName;
		this.fileLocation = fileLocation;
		this.fileExtension = fileExtension;
		this.isDirectory = isDirectory;
		
		if( isDirectory == true ) {
			this.dirContent = new ArrayList<StructFileInfo>();
		}
	}

	/**
	 * @param f The Information of a file to add to a directory.
	 */
	public void addDirectoryContent( StructFileInfo f ) {
		this.dirContent.add(f);
	}
	
	public Iterator<StructFileInfo> getDirectoryIterator() {
		return this.dirContent.iterator();
	}
	
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileLocation
	 */
	public String getFileLocation() {
		return fileLocation;
	}

	/**
	 * @param fileLocation the fileLocation to set
	 */
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	/**
	 * @return the fileExtension
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	/**
	 * @param fileExtension the fileExtension to set
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	/**
	 * @return the isDirectory
	 */
	public boolean isDirectory() {
		return isDirectory;
	}

	/**
	 * @param isDirectory the isDirectory to set
	 */
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;

		if( isDirectory == true ) {
			this.dirContent = new ArrayList<StructFileInfo>();
		}
	}
	
}
