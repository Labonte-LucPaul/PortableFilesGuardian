package ca.pfg.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import ca.pfg.core.FileSystem.*;

public class PFGUI {

	private JFrame frmPortableFilesGuardian;
	private JDesktopPane desktopPane;
	private JToolBar toolBar;
	private JPanel windowPanel;
	private JPanel toolBarPanel;
	private JComboBox comboBox;
	private JToolBar toolBar_1;
	private JButton btnGo;
	private Component horizontalGlue_1;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PFGUI window = new PFGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PFGUI() {
		initialize();
	}
	
	public void SetVisible( boolean v ) {
		this.frmPortableFilesGuardian.setVisible(v);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPortableFilesGuardian = new JFrame();
		frmPortableFilesGuardian.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				int frmWidth = frmPortableFilesGuardian.getWidth();
				int frmHeight = frmPortableFilesGuardian.getHeight();
				toolBarPanel.setBounds(0, 0, frmWidth, 40);
				windowPanel.setBounds(0, 40, frmWidth - 16, frmHeight - 61);
				desktopPane.setBounds(0, 40, frmWidth - 16, frmHeight - 61);
				toolBar.setBounds(0, 0, frmWidth, 40);
			}
		});
		frmPortableFilesGuardian.setTitle("Portable Files Guardian");
		frmPortableFilesGuardian.setBounds(100, 100, 865, 632);
		frmPortableFilesGuardian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmPortableFilesGuardian.setJMenuBar(menuBar);
		
		JMenu mnfile = new JMenu("File");
		menuBar.add(mnfile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit( 0 );
			}
		});
		mnfile.add(mntmExit);
		
		//this.toolBar = new JToolBar("Dragg me!");
		//toolBar.setBounds(0, 0, 865, 30);
		
		//frmPortableFilesGuardian.getContentPane().add(toolBar);
		
		frmPortableFilesGuardian.getContentPane().setLayout(null);
		
		InternalWindow w = new InternalWindow();
		//InternalWindow w2 = new InternalWindow();
		w.populateTree();
		
		windowPanel = new JPanel();
		windowPanel.setBounds(0, 40, 849, 532);
		frmPortableFilesGuardian.getContentPane().add(windowPanel);
		windowPanel.setLayout(new CardLayout(0, 0));
		
		//JDesktopPane desktopPane = new JDesktopPane();
		desktopPane = new JDesktopPane();
		windowPanel.add(desktopPane, "name_215719848755788");
		desktopPane.add(w.getWindow());
		
		toolBarPanel = new JPanel();
		toolBarPanel.setBounds(0, 0, 849, 40);
		frmPortableFilesGuardian.getContentPane().add(toolBarPanel);
		toolBarPanel.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 849, 40);
		toolBarPanel.add(toolBar);
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_1);
		
		toolBar_1 = new JToolBar();
		toolBar.add(toolBar_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A:\\", "B:\\", "C:\\", "D:\\", "E:\\"}));
		comboBox.setSelectedIndex(2);
		comboBox.setEditable(true);
		toolBar_1.add(comboBox);
		
		btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					@SuppressWarnings("unused")
					ReadFileSystem rfs = new ReadFileSystem("C:\\");
				} catch( Exception ex ) {
					JOptionPane.showMessageDialog(null, ex.getMessage() );
				}
			}
		});
		toolBar_1.add(btnGo);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		//desktopPane.add(w2.getWindow());


//		
//		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
//		internalFrame.setResizable(true);
//		internalFrame.setMaximizable(true);
//		internalFrame.setClosable(true);
//		internalFrame.setBounds(68, 12, 592, 503);
//		desktopPane.add(internalFrame);
//		internalFrame.getContentPane().setLayout(null);
//		
//		JSplitPane splitPane = new JSplitPane();
//		splitPane.setContinuousLayout(true);
//		splitPane.setBounds(0, 0, 582, 470);
//		internalFrame.getContentPane().add(splitPane);
//		
//		JTree tree = new JTree();
//		tree.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("JTree") {
//				{
//					DefaultMutableTreeNode node_1;
//					node_1 = new DefaultMutableTreeNode("colors");
//						node_1.add(new DefaultMutableTreeNode("blue"));
//						node_1.add(new DefaultMutableTreeNode("violet"));
//						node_1.add(new DefaultMutableTreeNode("red"));
//						node_1.add(new DefaultMutableTreeNode("yellow"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("sports");
//						node_1.add(new DefaultMutableTreeNode("basketball"));
//						node_1.add(new DefaultMutableTreeNode("soccer"));
//						node_1.add(new DefaultMutableTreeNode("football"));
//						node_1.add(new DefaultMutableTreeNode("hockey xxx"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("food");
//						node_1.add(new DefaultMutableTreeNode("hot dogs"));
//						node_1.add(new DefaultMutableTreeNode("pizza"));
//						node_1.add(new DefaultMutableTreeNode("ravioli"));
//						node_1.add(new DefaultMutableTreeNode("bananas"));
//					add(node_1);
//				}
//			}
//		));
//		splitPane.setLeftComponent(tree);
//		
//		JList list = new JList();
//		splitPane.setRightComponent(list);
//		internalFrame.setVisible(true);
	}
}


class InternalWindow {
	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private JInternalFrame internalFrame;
	private JSplitPane splitPane;
	private JTree tree;
	private JList<?> list;
	
	InternalWindow() {
		internalFrame = new JInternalFrame("New JInternalFrame");
		this.internalFrame.addComponentListener( new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				splitPane.setBounds(0, 0, internalFrame.getWidth(), internalFrame.getHeight());
			}
		});
		internalFrame.setResizable(true);
		internalFrame.setMaximizable(true);
		internalFrame.setClosable(true);
		internalFrame.setBounds(68, 12, 592, 503);
		internalFrame.getContentPane().setLayout(null);


		splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setBounds(0, 0, 582, 470);
		internalFrame.getContentPane().add(splitPane);
		
		tree = new JTree();
		splitPane.setLeftComponent(tree);

		list = new JList<Object>();
		splitPane.setRightComponent(list);
		internalFrame.setVisible(true);
	}
	
	public JInternalFrame getWindow() {
		return this.internalFrame;
	}
	
	public void populateTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
		root.add(new DefaultMutableTreeNode("spam"));
		tree.setModel( new DefaultTreeModel(root) );
		//DefaultTreeModel model = (DefaultTreeModel)tree.getModel(); 
		//model.reload(new DefaultMutableTreeNode(root));
		//tree.setModel(model);
	}
}