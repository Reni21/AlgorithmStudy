package tree;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFileOnComputer {
    public static void main(String[] args) {
//        List<File> jpg = new ArrayList<>();
//        findAllJpgInDirectoryAndSubDir(new File("/home/reni/StudyR/html_css"), jpg);
//        jpg.stream()
//                .map(File::getName)
//                .forEach(System.out::println);

        findAllJpgInDirectoryAndSubDir2(new File("/home/reni/StudyR/html_css"))
                .stream()
                .map(File::toString)
                .forEach(System.out::println);
    }

    public static void findAllJpgInDirectoryAndSubDir(File rootDir, List<File> accJpg) {
        if (rootDir == null || rootDir.isFile() || !rootDir.exists()) {
            return;
        }
        Arrays.stream(rootDir.listFiles()).forEach(file -> {
            if (file.getName().endsWith(".jpg")) {
                accJpg.add(file);
            } else if (file.isDirectory()) {
                findAllJpgInDirectoryAndSubDir(file, accJpg);
            }
        });
    }

    public static List<File> findAllJpgInDirectoryAndSubDir2(File rootDir) {
        if (rootDir == null || rootDir.isFile() || !rootDir.exists()) {
            return new ArrayList<>();
        }

        return Arrays.stream(rootDir.listFiles())
                .collect(ArrayList::new, (accArrayList, streamEl) -> {
                    if (streamEl.getName().endsWith(".jpg")) {
                        accArrayList.add(streamEl);
                    } else if (streamEl.isDirectory()) {
                        accArrayList.addAll(findAllJpgInDirectoryAndSubDir2(streamEl));
                    }
                }, ArrayList::addAll);
    }
}
