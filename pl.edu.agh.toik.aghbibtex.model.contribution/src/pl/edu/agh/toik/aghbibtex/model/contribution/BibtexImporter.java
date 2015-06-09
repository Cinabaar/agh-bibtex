package pl.edu.agh.toik.aghbibtex.model.contribution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXFormatter;
import org.jbibtex.BibTeXParser;
import org.jbibtex.Key;
import org.jbibtex.ParseException;
import org.jbibtex.TokenMgrException;
import org.jbibtex.Value;

import pl.edu.agh.toik.aghbibtex.model.IBibtexImporter;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexFactory;

public class BibtexImporter implements IBibtexImporter {

	@Override
	public List<BibtexEntry> importFromFile(String fileName) {
		List<BibtexEntry> es = new ArrayList<BibtexEntry>();

		try(Reader reader = new FileReader(fileName))
		{
			org.jbibtex.LaTeXPrinter latexPrinter = new org.jbibtex.LaTeXPrinter();
			org.jbibtex.LaTeXParser latexParser = new org.jbibtex.LaTeXParser();
			BibTeXParser bibtexParser = new BibTeXParser();
			BibTeXDatabase database = bibtexParser.parseFully(reader);
			BibTeXFormatter formatter;
			BibTeXDatabase dat;
			  Collection<BibTeXEntry> entries = database.getEntries().values();
			  List<Key> columnHeaders = new ArrayList<Key>();
			  
			  for(BibTeXEntry entry : entries){
				  es.add(convertFromJbibtex(entry));
			  }
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return es;
	}
	
	private String fromLatexString(Value value) throws TokenMgrException, ParseException
	{
		if(value == null) return "";
		String string = value.toUserString();
		if(string.indexOf('\\') > -1 || string.indexOf('{') > -1){
			try{
			org.jbibtex.LaTeXParser latexParser = new org.jbibtex.LaTeXParser();
			List<org.jbibtex.LaTeXObject> latexObjects = latexParser.parse(string);
			org.jbibtex.LaTeXPrinter latexPrinter = new org.jbibtex.LaTeXPrinter();
			String plainTextString = latexPrinter.print(latexObjects);
			
			return plainTextString;
			}
			catch(Exception e) {
				return string;
			}
		} else {
		    return string;
		}
	}

	@Override
	public BibtexEntry readEntry(String entry) {

		try {
			StringReader reader = new StringReader(entry);
			BibTeXParser bibtexParser;
			bibtexParser = new BibTeXParser();
			BibTeXDatabase database = bibtexParser.parseFully(reader);
			Collection<BibTeXEntry> entries = database.getEntries().values();
			BibtexEntry en = null;
			for(BibTeXEntry e : entries){
				en = convertFromJbibtex(e);
			}
			return en;
		} catch (Exception e)
		{
			return null;
		}

	}
	
	public BibtexEntry convertFromJbibtex(BibTeXEntry entry)
	{
		try
		{
		BibtexEntry e = BibtexFactory.eINSTANCE.createBibtexEntry();
		
		BibTeXDatabase  dat = new BibTeXDatabase();
		dat.addObject(entry);
		BibTeXFormatter  formatter = new BibTeXFormatter();
	    StringWriter w = new StringWriter();
		formatter.format(dat, w);
		e.setText(w.toString());
		e.setAuthor(fromLatexString(entry.getField(BibTeXEntry.KEY_AUTHOR)));
		e.setJournal(fromLatexString(entry.getField(BibTeXEntry.KEY_JOURNAL)));
		e.setPages(fromLatexString(entry.getField(BibTeXEntry.KEY_PAGES)));
		e.setTitle(fromLatexString(entry.getField(BibTeXEntry.KEY_TITLE)));
		e.setVolume(fromLatexString(entry.getField(BibTeXEntry.KEY_VOLUME)));
		e.setYear(fromLatexString(entry.getField(BibTeXEntry.KEY_YEAR)));
		return e;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
