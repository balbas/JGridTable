package com.jmb.grid.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("unused")
public class JGridTableTest {
	
	private static final long serialVersionUID = 1L;

	public JGridTableTest() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
					
				}
				DefaultTableModel model = new DefaultTableModel(COLUMN_NAMES, 10);
				JGridTable grid = new JGridTable(model);
				
				for (int i = 0; i < grid.getModel().getRowCount(); i++) {
					for (int j = 0; j < grid.getModel().getColumnCount(); j++) {
						String s = new Random().nextBoolean() ? "red" : "yellow";
						grid.getModel().setValueAt(s, i, j);
					}
				}
				
				grid.setColumnCellEditor(1);				
				
				JFrame frame = new JFrame("JGridTable");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());				
				frame.add(new JScrollPane(grid));
				//frame.add(grid);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		new JGridTableTest();
	}
	
	private static final String[] COLUMN_NAMES = {"Columna 1", "Columna 2"};
}
