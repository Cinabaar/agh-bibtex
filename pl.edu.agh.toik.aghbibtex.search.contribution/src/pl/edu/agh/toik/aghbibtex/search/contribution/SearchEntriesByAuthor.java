package pl.edu.agh.toik.aghbibtex.search.contribution;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.search.ISearchEntriesBy;

public class SearchEntriesByAuthor implements ISearchEntriesBy {

	@Override
	public String getSearchType() {
		return "Author";
	}

	@Override
	public List<BibtexEntry> filterEntriesBy(List<BibtexEntry> entries,	List<String> filters) {
		if(filters.size() == 0)
			return entries;
		List<BibtexEntry> result = new ArrayList<BibtexEntry>();
		for(BibtexEntry e : entries)
		{
			for(String f : filters)
			{
				if(e.getAuthor().toLowerCase().contains(f.toLowerCase()))
				{
					result.add(e);
					break;
				}
			}
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		return getSearchType();
	}

}
