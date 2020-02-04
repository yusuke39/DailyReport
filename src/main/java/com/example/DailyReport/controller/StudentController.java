package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.StudentCsv;
import com.example.DailyReport.form.CsvFileForm;
import com.example.DailyReport.form.StudentLoginForm;
import com.example.DailyReport.service.StudentFile;
import com.example.DailyReport.service.StudentService;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentFile studentFile;

    @Autowired
    private HttpSession session;


    /**
     * 受講生用のログインフォーム表示.
     * @return
     */
    @RequestMapping("/loginForm")
    public String studentLoginFrom(){
        return"student/student_login";
    }

    /**
     * 受講生用のログインフォーム
     * @return
     */
    @RequestMapping("/login")
    public String login(StudentLoginForm studentLoginForm, Model model){


        List<Student> studentList = studentService.findStudentByEmailAndPassword(studentLoginForm);

        if(studentList == null){
            model.addAttribute("nullStudent", "メールアドレスかパスワードが一致しません");
        }

        return"student/student_training_list";
    }

    /**
     * 受講者情報インポート画面表示.
     * @return
     */
    @RequestMapping("/registerStudent")
    public String registerStudent(){

        return "admin/admin_training_import_students";
    }



    @RequestMapping("/csvOutput")
    public String csvOutput(CsvFileForm csvFileForm, Model model) {

        String fileName = csvFileForm.getFile().getOriginalFilename();

        //受け取ったファイルをそのままサーバーに配置(/Users/hiranoyuusuke/IdeaProjects/DailyReport/ファイル名　→直下に置く）
        Path paths = Paths.get("/Users/hiranoyuusuke/IdeaProjects/DailyReport/" + fileName);

        try(OutputStream outputStream = Files.newOutputStream(paths, StandardOpenOption.CREATE)) {
            byte[] bytes = csvFileForm.getFile().getBytes();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Users/hiranoyuusuke/IdeaProjects/DailyReport/ファイル名においたファイルを読み込みインサートする
        BufferedReader bufferedReader = null;

        try{
            //CSVファイルの中身を読み込み
            FileInputStream fileInputStream = new FileInputStream("/Users/hiranoyuusuke/IdeaProjects/DailyReport/" + fileName);
            //バイトストリームをテキスト形式に変換
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            //テキスト形式のファイル読み込み
            bufferedReader = new BufferedReader(inputStreamReader);

            String currentContents;
            List<Student> studentList = new ArrayList<>();
            int row = 0;
            String[] arrayColumnName = null;


            System.out.println(bufferedReader.readLine());


            while ((currentContents = bufferedReader.readLine()) != null) {
                System.out.println("aaaaaaaaaa" + currentContents);

                int arrayNumber = 0;
                String[] arrayColumnData = currentContents.split(",");
                Student student = new Student();
                student.setName(arrayColumnData[0]);
                student.setEmail(arrayColumnData[1]);
                studentList.add(student);
                session.setAttribute("studentList", studentList);
                row++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //CSVファイルを消す
        File filedelete = new File("/Users/hiranoyuusuke/IdeaProjects/DailyReport/" + fileName);
        filedelete.delete();

        return "redirect:/student/registerStudent";
    }

}
