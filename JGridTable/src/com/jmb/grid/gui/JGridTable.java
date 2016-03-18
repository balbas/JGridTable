package com.jmb.grid.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.jmb.grid.renderer.JGridTableCellRenderer;

public class JGridTable extends JTable {

	private static final long serialVersionUID = 1L;
	
	private JTextField cellEdit;
	private DefaultCellEditor cellEditor;
	private JLabel glass;
	
	public JGridTable(TableModel model) {
		super(model);
		init();
	}
	
	private void init() {
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setDefaultRenderer(String.class, new JGridTableCellRenderer());
		setFocusable(false);
		setShowGrid(false);
		setRowMargin(0);
		setIntercellSpacing(new Dimension(0, 0));
		setRowSelectionAllowed(false);
		
		// Cell edit
		cellEdit = new JTextField();
		cellEdit.setBackground(new Color(255, 245, 155));
		cellEdit.setBorder(null);
		
		// Renderer cell editor
		cellEditor = new DefaultCellEditor(cellEdit);
		
		// Glass
		glass = new JLabel();
		glass.setBackground(null);
		
		// Mouse listener
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				glass.setVisible(false);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// Mouse motion listener
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				glass.setBorder(BorderFactory.createLineBorder(new Color(255, 178, 49)));
				glass.setSize(getWidth(), 20);
				glass.setLocation(0, (arg0.getPoint().y - (arg0.getPoint().y % 20)));
				glass.setVisible(true);
				add(glass);
			}
			
		});
	}
	
	public void setColumnCellEditor(int col) {
		getColumnModel().getColumn(col).setCellEditor(cellEditor);
	}
	
	public boolean isColumnCellEditor(int col) {
		return (getColumnModel().getColumn(col).getCellEditor() != null) ? true : false;
	}
}
