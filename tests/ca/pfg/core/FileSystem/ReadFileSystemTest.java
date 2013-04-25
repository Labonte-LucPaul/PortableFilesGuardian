package ca.pfg.core.FileSystem;

import static org.junit.Assert.*;
import org.junit.Test;

import ca.pfg.core.FileSystem.ReadFileSystem;

public class ReadFileSystemTest {

	private String Windows_path_1 = "C:\\";
	private String Windows_path_2 = "C:\\apps";
	private String Windows_path_3 = "C:\\apps\\t.txt";
	private String Windows_path_4 = "C:\\Android";
	
	@Test
	public void testReadFileSystem() {
		ReadFileSystem rfs1 = new ReadFileSystem(Windows_path_1);
		ReadFileSystem rfs2 = new ReadFileSystem(Windows_path_2);
		ReadFileSystem rfs3 = new ReadFileSystem(Windows_path_3);
		ReadFileSystem rfs4 = new ReadFileSystem(Windows_path_4);
	}

}
