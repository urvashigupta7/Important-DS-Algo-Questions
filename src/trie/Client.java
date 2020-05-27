package trie;

public class Client {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("amit");
        t.add("see");
        t.add("sea");
        t.add("shell");
        t.add("book");
        t.add("buy");
        t.add("art");
        t.add("arts");
        System.out.println(t.getNumWords());
        t.displayWords();
        t.remove("amit");
        t.displayWords();
        System.out.println(t.searchWord("art"));
        t.displayStartsWith("ar");
    }
}
