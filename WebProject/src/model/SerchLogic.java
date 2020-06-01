package model;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//リストの検索のためのロジック
public class SerchLogic {
	public static <T> T search(List<T> list, Function<T,Boolean> p){

		List<T> foundItem =  list.stream()
				.filter(item -> p.apply(item))
				.collect(Collectors.toList());

		return foundItem.isEmpty() ? null : foundItem.get(0);
	}

	public static <T> List<T> delete(List<T> list, Function<T,Boolean> p) {
		return list.stream()
				.filter(item -> ! p.apply(item))
				.collect(Collectors.toList());
	}
}
