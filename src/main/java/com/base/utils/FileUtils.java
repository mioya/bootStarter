package com.base.utils;


import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public void download(String filePathName) throws IOException {
        Path path = Paths.get(filePathName);
        Files.createFile(path);
    }

    public static void checkIllegalFilePath(Path path) {
        if (path != null) {
            File file = path.toFile();
            try {
                if (!StringUtils.equals(file.getAbsolutePath(), file.getCanonicalPath()))
                    throw new RuntimeException(String.format("AbsolutePath-->%s,CanonicalPath-->%s", file.getAbsolutePath(), file.getCanonicalPath()));
            } catch (IOException e) {
                throw new RuntimeException(String.format("AbsolutePath-->%s", file.getAbsolutePath()));
            }
        }
    }

    public void checkFileExtension(String fileName, String... enableFileExtensions) {
        boolean rightExtension = false;

        if (enableFileExtensions != null) {
            for (String extension : enableFileExtensions) {
                if (StringUtils.equals(FilenameUtils.getExtension(fileName), extension)) {
                    rightExtension = true;
                    break;
                }
            }
            if (enableFileExtensions != null && !rightExtension)
                throw new RuntimeException(
                        String.format("Can not allow the file extension.(FileName: %s) ", fileName));
        }
    }

}

