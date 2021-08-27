package p588_DesignInMemoryFileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/8/24 13:56
 */
class FileSystem {

    public FileSystemNode root;

    public FileSystem() {
        root = new FileSystemNode();
    }

    public List<String> ls(String path) {
        ArrayList<String> res = new ArrayList<>();
        FileSystemNode node = root;
        if (path.equals("/")) {
            res.addAll(node.fileContent.keySet());
            res.addAll(node.directory.keySet());
            Collections.sort(res);
            return res;
        }
        String[] paths = path.split("/");
        for (int i = 0; i < paths.length - 1; i++) {
            if (paths[i].isEmpty()) {
                continue;
            }
            node = node.directory.get(paths[i]);
        }
        if (node.fileContent.containsKey(paths[paths.length - 1])) {
            res.add(paths[paths.length - 1]);
        } else {
            node = node.directory.get(paths[paths.length - 1]);
            res.addAll(node.fileContent.keySet());
            res.addAll(node.directory.keySet());
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        FileSystemNode node = root;
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.isEmpty()) {
                continue;
            }
            if (!node.directory.containsKey(p)) {
                node.directory.put(p, new FileSystemNode());
            }
            node = node.directory.get(p);
        }
    }

    public void addContentToFile(String filePath, String content) {
        FileSystemNode node = root;
        String[] paths = filePath.split("/");
        for (int i = 0; i < paths.length - 1; i++) {
            if (paths[i].isEmpty()) {
                continue;
            }
            node = node.directory.get(paths[i]);
        }
        node.fileContent.put(paths[paths.length - 1], node.fileContent.getOrDefault(paths[paths.length - 1], "") + content);
    }

    public String readContentFromFile(String filePath) {
        FileSystemNode node = root;
        String[] paths = filePath.split("/");
        for (int i = 0; i < paths.length - 1; i++) {
            if (paths[i].isEmpty()) {
                continue;
            }
            node = node.directory.get(paths[i]);
        }
        return node.fileContent.get(paths[paths.length - 1]);
    }

    public class FileSystemNode {
        LinkedHashMap<String, String> fileContent;
        LinkedHashMap<String, FileSystemNode> directory;

        public FileSystemNode() {
            fileContent = new LinkedHashMap<>();
            directory = new LinkedHashMap<>();
        }
    }
}
