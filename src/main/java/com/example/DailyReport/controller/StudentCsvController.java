//package com.example.DailyReport.controller;
//
//import com.example.DailyReport.domain.StudentCsv;
//import com.example.DailyReport.form.CsvFileForm;
//import com.example.DailyReport.service.StudentFile;
//import com.opencsv.exceptions.CsvException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.io.Writer;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//@Controller
//public class StudentCsvController {
//
//    @Autowired
//    private StudentFile studentFile;
//
//    @RequestMapping("/csvOutput")
//    public String csvOutput(CsvFileForm csvFileForm) {
//
//        if(csvFileForm != null){
//            System.out.println("ありがとう成功です");
//            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa" + csvFileForm.getFile().getOriginalFilename());
//        }
//
//
//        String java = csvFileForm.getFile().getOriginalFilename();
//
//        try (Reader reader = Files.newBufferedReader(Paths.get("/Users/hiranoyuusuke/desktop/" + java));
//             Writer writer = Files.newBufferedWriter(Paths.get("/Users/hiranoyuusuke/desktop/" + java));) {
//            List<StudentCsv> items = studentFile.read(reader);
//            items.forEach(System.out::println);
//            studentFile.write(writer, items);
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        } catch (
//                CsvException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }
//}
//
//
//
