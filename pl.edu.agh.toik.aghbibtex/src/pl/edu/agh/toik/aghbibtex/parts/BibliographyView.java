package pl.edu.agh.toik.aghbibtex.parts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.Key;
import org.jbibtex.Value;

public class BibliographyView {
	
	private Table table;
	
	@Inject
	@Optional
	private void onOpenFile(@UIEventTopic("OpenFile") String fileName) 
	{
	  try(Reader reader = new FileReader(fileName))
	  {
		  BibTeXParser bibtexParser = new BibTeXParser();
		  BibTeXDatabase database = bibtexParser.parse(reader);

		  Collection<BibTeXEntry> entries = database.getEntries().values();
		  List<Key> columnHeaders = new ArrayList<Key>();

		  for(BibTeXEntry entry : entries){
			  for(Key k : entry.getFields().keySet())
			  {
				  if(entry.getField(k) != null && !columnHeaders.contains(k))
				  {
					  columnHeaders.add(k);
					  
				  }
			  }
		  }
		  for(Key c : columnHeaders)
		  {
			  TableColumn column = new TableColumn(table, SWT.NULL);
	          column.setText(c.toString());
	          column.setMoveable(true);
		  }
		  for(BibTeXEntry entry : entries){
			  TableItem item = new TableItem(table, SWT.NULL);
			  if(entry.getField(BibTeXEntry.KEY_TITLE) != null) {
				  item.setText(entry.getField(BibTeXEntry.KEY_TITLE).toUserString());
			  }
			  for(int i=0;i<columnHeaders.size();i++)
			  {
				  if(entry.getField(columnHeaders.get(i)) != null) {
					  item.setText(i, entry.getField(columnHeaders.get(i)).toUserString());
				  }
			  }
		  }		  
		  for(int i=0;i<columnHeaders.size();i++)
		  {
			  table.getColumn(i).pack();		  
		  }
		  table.redraw();
		  table.layout();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	}
	
	@PostConstruct
	public void createControls(Composite parent) 
	{
		table = new Table(parent, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setHeaderVisible(true);
	}
}