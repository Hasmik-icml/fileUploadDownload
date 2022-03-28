package com.example.fileuploaddownloadapi.response;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FileUploadResponse {
    private String fileName;
    private String downloadUri;
    private long size;


}
