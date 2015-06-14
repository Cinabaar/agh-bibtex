package pl.edu.agh.toik.aghbibtex.search.contribution;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;
import pl.edu.agh.toik.aghbibtex.search.ISearchEntriesBy;

public class SearchEntriesByTag implements ISearchEntriesBy
{	
	@Override
	public String getSearchType() {
		return "Tag";
	}

	@Override
	public List<BibtexEntry> filterEntriesBy(List<BibtexEntry> entries, List<String> filters) {
		if(filters.size() == 0)
			return entries;
		List<BibtexEntry> result = new ArrayList<BibtexEntry>();
		boolean found = false;
		for(BibtexEntry be : entries)
		{
			found = false;
			List<String> tagNames = getTagNames(be.getTags());
			for(String f : filters)
			{
				for(String tag : tagNames)
				{
					if(tag.toLowerCase().contains(f.toLowerCase()))
					{	
						result.add(be);
						found = true;
						break;
					}
				}
				if(found) break;
			}
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		return getSearchType();
	}
	
	private List<String> getTagNames(List<Tag> tags)
	{
		List<String> result = new ArrayList<String>();
		for(Tag t : tags)
		{
			result.add(t.getName());
		}
		return result;
	}

}
