package ca.pfg.core;

import java.awt.EventQueue;
import ca.pfg.core.FileSystem.*;
import ca.pfg.ui.*;

public class PortableFilesGuardian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PFGUI window = new PFGUI();
					window.SetVisible( true );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
