package pl.edu.agh.toik.aghbibtex.search.contribution;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.search.ISearchEntriesBy;

public class SearchEntriesByName implements ISearchEntriesBy {

	@Override
	public String getSearchType() {
		return "Title";
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
				if(e.getTitle().toLowerCase().contains(f.toLowerCase()))
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
