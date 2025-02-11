package Amazon;

public class FileSystem {
    /**
     * leetcode 1166
     * 这部分要求实现一个FileSystem，包含两个方法，
     * 1. 一个是createPath，如果这个路径不存在，并且path存在，就创建这个路径并且返回value；成功返回false，失败返回false。
     * 2. 第二个要求是实现一个get。retrieve 这个路径存储的value，如果路径不存在就返回-1.
     * 这道题有两种方法可以选择。一种是Trie，一种是Hash table，选哪个？
     * 如果纯按照理论的时间复杂度来说hash table是更好的方法。createPath和get都是O(1)的时间复杂度。Trie的时间复杂度是层深。但Trie是面试官更prefer的解法。
     *
     * "I would choose Trie because it matches the file system's structure. While a Hash Table has O(1) lookup,
     * it doesn’t handle hierarchy well. Trie, with O(d) complexity, is more flexible and better for future features
     * like listing directories."
     */


}
