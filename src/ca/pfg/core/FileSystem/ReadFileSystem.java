package ca.pfg.core.FileSystem;

import java.io.*;
import java.util.StringTokenizer;

public class ReadFileSystem {

	private String path;
	private File dir;
	private StructFileInfo files;
	private StringTokenizer strTok;

	/**
	 * @param path
	 */
	public ReadFileSystem(String p) {
		super();
		this.path = p;
		String fileName = "";
		String fileExtension = "";
		
		this.dir = new File( p );
		
		this.strTok = new StringTokenizer(p,"\\");

		while( this.strTok.hasMoreElements() ) {
			fileName = this.strTok.nextElement().toString();
		}
		
		this.strTok = new StringTokenizer(fileName, ".");
		
		while( this.strTok.hasMoreElements() ) {
			fileExtension = this.strTok.nextElement().toString();
		}
		
		boolean isDirectory = this.dir.isDirectory();
		this.files = new StructFileInfo(fileName, p, fileExtension, isDirectory );
		
		if( isDirectory == true ) {
			//while( this.dir.)
			//this.files.addDirectoryContent( new )
		}
	}
	
}
