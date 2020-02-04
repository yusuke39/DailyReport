package com.example.DailyReport.service;

import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.StudentCsv;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.io.Writer;
import java.util.List;

@Service
public class StudentFile {

    public void write(Writer writer, List<StudentCsv> beans) throws CsvException {
        StatefulBeanToCsv<StudentCsv> beanToCsv = new StatefulBeanToCsvBuilder<StudentCsv>(writer).build();
        beanToCsv.write(beans);
    }

    public List<StudentCsv> read(Reader reader) throws CsvException {
        CsvToBean<StudentCsv> csvToBean = new CsvToBeanBuilder<StudentCsv>(reader).withType(StudentCsv.class).build();
        return csvToBean.parse();
    }
}