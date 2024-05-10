package HomeWorkFinal;

import java.util.*;

public class PhoneBook {
	public static void main(String[] args) {
		HashMap<String, TreeSet<String>> phoneBook = new HashMap<>();

		String[][] contacts = {
				{ "Анна", "123-456" },
				{ "Петр", "789-012" },
				{ "Мария", "345-678" },
				{ "Анна", "901-234" },
				{ "Мария", "567-890" },
				{ "Анна", "123-456" },
		};

		for (String[] contact : contacts) {
			String name = contact[0];
			String phone = contact[1];

			if (phoneBook.containsKey(name)) {
				phoneBook.get(name).add(phone);
			} else {
				TreeSet<String> phoneSet = new TreeSet<>();
				phoneSet.add(phone);
				phoneBook.put(name, phoneSet);
			}
		}

		List<Map.Entry<String, TreeSet<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());

		sortedContacts.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

		for (Map.Entry<String, TreeSet<String>> entry : sortedContacts) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}