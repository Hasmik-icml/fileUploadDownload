package com.example.fileuploaddownloadapi.response;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    public static String saveFile(String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadDirectory = Paths.get("Files-Upload");

        String fileCodе = RandomStringUtils.randomAlphabetic(8);

        try (InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadDirectory.resolve(fileCodе + "-" +fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException(" Error saving upload file" + fileName, e);
        }
        return fileCodе;
    }

}
