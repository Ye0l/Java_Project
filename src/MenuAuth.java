import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAuth extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lb_auth;
	private DefaultListModel<Object> menulist, acclist;
	private int[] auth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAuth frame = new MenuAuth();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuAuth() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		JSlider slider = new JSlider();
		
		menulist = new DefaultListModel<Object>();
		JList list = new JList(menulist);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				textField.setText(menulist.getElementAt(list.getSelectedIndex()).toString());
				slider.setValue(auth[list.getSelectedIndex()]);
				acclist.removeAllElements();
				db.dbConnect("account");
				try {
					while(db.rs.next()) {
						if(Integer.parseInt(db.rs.getString("authorization")) <= slider.getValue())
							acclist.addElement(db.rs.getString("name"));
					}
				} catch (Exception e) {
					 e.printStackTrace();
				}
				db.dbDis();
			}
		});
		scrollPane.setViewportView(list);
		
		db.dbConnect("menuauth");
		try {
			int rownum = 1;
			while(db.rs.next()) {
				rownum++;
			}
			while(db.rs.previous());
			auth = new int[rownum];
			rownum = 0;
			while(db.rs.next()) {
				menulist.addElement(db.rs.getString("menuname"));
				auth[rownum] = Integer.parseInt(db.rs.getString("auth"));
				rownum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.dbDis();
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{61, 0, 50, 0};
		gbl_panel.rowHeights = new int[]{21, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("MenuName");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Authority");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lb_auth = new JLabel("0");
		lb_auth.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lb_auth.setHorizontalAlignment(SwingConstants.CENTER);
		
		slider.setValue(9);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider.getValue() == 0)					
					lb_auth.setText("Admin");
				else
					lb_auth.setText(Integer.toString(slider.getValue()));
			}
		});
		slider.setMaximum(9);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.fill = GridBagConstraints.BOTH;
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 1;
		panel.add(slider, gbc_slider);
		
		GridBagConstraints gbc_lb_auth = new GridBagConstraints();
		gbc_lb_auth.fill = GridBagConstraints.BOTH;
		gbc_lb_auth.insets = new Insets(0, 0, 5, 0);
		gbc_lb_auth.gridx = 2;
		gbc_lb_auth.gridy = 1;
		panel.add(lb_auth, gbc_lb_auth);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db.dbConnect("menuauth");
				try {
					db.query("update", "update menuauth set auth = '" + slider.getValue() + "' where menuname = '" + textField.getText() + "'");
					db.query("select", "select * from menuauth");
					int rownum = 0;
					while(db.rs.next()) {
						auth[rownum] = Integer.parseInt(db.rs.getString("auth"));
						rownum ++;
					}
				} catch (Exception e) {
					 e.printStackTrace();
				}
				db.dbDis();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Account with privileges");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		acclist = new DefaultListModel<Object>();
		
		JList accountlist = new JList(acclist);
		accountlist.setEnabled(false);
		scrollPane_1.setViewportView(accountlist);
	}

}
