package pl.edu.agh.toik.aghbibtex.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class BibliographyView {
	
	
	private Table table;
	
	@Inject
	@Optional
	private void subscribeTopicTodoUpdated(@UIEventTopic("OpenFile") String fileName) {
	  System.out.println(fileName);
	}
	
	@PostConstruct
	public void createControls(Composite parent) 
	{
		table = new Table(parent, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
	    table.setHeaderVisible(true);
	    String[] titles = { "Col 1", "Col 2", "Col 3", "Col 4" };
	    for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
	        TableColumn column = new TableColumn(table, SWT.NULL);
	        column.setText(titles[loopIndex]);
	        column.setMoveable(true);
	    }
	    for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
	        TableItem item = new TableItem(table, SWT.NULL);
	        item.setText("Item " + loopIndex);
	        item.setText(0, "Item " + loopIndex);
	        item.setText(1, "Yes");
	        item.setText(2, "No");
	        item.setText(3, "A table item");
	      }

	    for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
	    	table.getColumn(loopIndex).pack();
	    }
	  
	    
	}
}