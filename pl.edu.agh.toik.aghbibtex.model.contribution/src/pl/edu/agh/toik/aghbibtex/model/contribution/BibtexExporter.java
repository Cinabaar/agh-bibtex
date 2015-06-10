package pl.edu.agh.toik.aghbibtex.model.contribution;

import java.io.FileWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXFormatter;
import org.jbibtex.BibTeXParser;

import pl.edu.agh.toik.aghbibtex.model.IBibtexExporter;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public class BibtexExporter implements IBibtexExporter{


	@Override
	public void exportToFile(List<BibtexEntry> entries, String filePath) {

		List<BibTeXEntry> resultEntries = new ArrayList<BibTeXEntry>();
		for(BibtexEntry entry : entries)
		{
			try
			{
				StringReader reader = new StringReader(entry.getText());
				BibTeXParser bibtexParser;
				bibtexParser = new BibTeXParser();
				BibTeXDatabase database = bibtexParser.parseFully(reader);
				Collection<BibTeXEntry> es = database.getEntries().values();	
				BibTeXEntry e = es.iterator().next();
				resultEntries.add(e);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		BibTeXDatabase dat = new BibTeXDatabase();
		for(BibTeXEntry be : resultEntries)
		{
			dat.addObject(be);
		}
		BibTeXFormatter f = new BibTeXFormatter();
		try
		{
		    Writer w = new FileWriter(filePath);
		    f.format(dat, w);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
