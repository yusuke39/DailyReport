package com.example.DailyReport.form;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class CsvFileForm {

   private MultipartFile file;

    public CsvFileForm(MultipartFile file) {
        this.file = file;
    }

    public CsvFileForm() {
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
