package pl.wit.lab6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsTutorial {
	private Collection<String> collection = null;
	
	public CollectionsTutorial() {
		this.collection = new ArrayList<String>();
		
		for(int i=0;i<100000;i++) {
			collection.add("item_"+((i+1)%10000));
		}
	}
	
	public Set<String> getSet(){
		return collection.stream().distinct().collect(Collectors.toCollection(LinkedHashSet::new));
	}
	
	public List<String> getOnlyEvenItems(){
		return collection.stream()
				.filter(item -> {
					String[] parts = item.split("_");
					int number = Integer.parseInt(parts[1]);
					return number % 2 == 0;
				})
				.collect(Collectors.toList());
	}
	
	public Set<String> getSetWithOrderWithNoLessThan100(){
		return collection.stream()
				.filter(item -> {
					String[] parts = item.split("_");
					int number = Integer.parseInt(parts[1]);
					return number <= 100;
				})
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}
	
	public TreeSet<String> getEvery3ElementAsSortedSet(){
		List<String> lstTmp = new ArrayList<>(collection);
		TreeSet<String> t = IntStream.range(0, lstTmp.size())
				.filter(index -> index % 3 == 0)
				.mapToObj(lstTmp::get)
				.collect(Collectors.toCollection(TreeSet::new));

		return new TreeSet<>();
	}
}
