package pl.edu.agh.toik.aghbibtex.search;

import java.util.List;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public interface ISearchEntriesBy 
{
	String getSearchType();
	List<BibtexEntry> filterEntriesBy(List<BibtexEntry> entries, List<String> filters);
}
