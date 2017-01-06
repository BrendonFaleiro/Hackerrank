import java.util.*;

public class HackerrankTries {

	public static class TrieNode {
		TrieNode[] children;
		char val;
		int count;

		// default root node
		public TrieNode() {
			children = new TrieNode[26];
			count = 0;
		}

		// intermediate nodes
		public TrieNode(char c) {
			this();
			val = c;
			count = 1;
		}

		// Add new contact string
		public void Add(String contact) {
			int pos = contact.charAt(0) - 'a';

			if (children[pos] == null) {
				children[pos] = new TrieNode(contact.charAt(0));
			} else {
				children[pos].count++;
			}

			if (contact.length() > 1) {
				children[pos].Add(contact.substring(1));
			}
		}

		// Query for existing contact string
		public int Find(String contact) {
			int pos = contact.charAt(0) - 'a';

			if (children[pos] == null) {
				return 0;
			} else if (contact.length() == 1) {
				return children[pos].count;
			} else {
				return children[pos].Find(contact.substring(1));
			}

		}
	}

	public static void main(String[] args) {
		TrieNode ContactTrie = new TrieNode();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			// System.out.println(op);

			if (op.equals("add")) {
				// System.out.println("reached add");
				ContactTrie.Add(contact);
			} else if (op.equals("find")) {
				// System.out.println("reached find");
				System.out.println(ContactTrie.Find(contact));
			}
		}

		in.close();
	}
}
