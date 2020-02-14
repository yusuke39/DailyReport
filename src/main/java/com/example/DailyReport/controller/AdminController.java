package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.Company;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.form.*;
import com.example.DailyReport.mapper.AdminMapper;
import com.example.DailyReport.security.Admin.LoginAdmin;
import com.example.DailyReport.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpSession session;



    /**
     * ログイン画面表示.
     *
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage(Model model, @RequestParam(required = false) String error) {

        if(error != null){
            model.addAttribute("パスワードかメールアドレスが不正です");
        }

        return "admin/admin_login";
    }



    /**
     * 運営管理者一覧表示.
     *
     * @return
     */
    @RequestMapping("/operationManager")
    public String operationManager(Model model, @AuthenticationPrincipal LoginAdmin loginUser) {

        List<Admin> adminList = adminService.findAllAdminsAndCompanies();

        model.addAttribute("adminList", adminList);

        return "admin/facility_manager_list";
    }


    /**
     * 運営管理者登録画面を表示する.
     *
     * @return
     */
    @RequestMapping("/registerAdmin")
    public String registerAdmin(Model model) {

        List<Company> companyList = adminService.findAllCompanies();

        model.addAttribute("companyList", companyList);

        return "admin/facility_manager_detail";
    }


    /**
     * 管理者情報を登録する.
     *
     * @param registerAdminForm
     * @return
     */
    @RequestMapping("/registerAdminDetail")
    public String registerAdminDetail(RegisterAdminForm registerAdminForm, Model model) {

//        if(!(registerAdminForm.getPassword() == registerAdminForm.getConfirmPassword())){
//            model.addAttribute("passwordMismatch","パスワードと確認用パスワードが一致しません");
//            return "admin/facility_manager_detail";
//        }

        adminService.registerAdminAndRelationCompanies(registerAdminForm);

        return "redirect:/admin/operationManager";
    }


    /**
     * 管理者編集画面に遷移する.
     *
     * @param model
     * @return
     */
    @RequestMapping("/editAdmin")
    public String editAdmin(Model model) {

        //リクエストパラメーターの値を受け取る
        String adminId = httpServletRequest.getParameter("adminId");

        //管理者と企業を１件探す
        Admin admin = adminService.findAdminAndCompanyByAdminId(adminId);

        //企業情報を全権取得する
        List<Company> companiesList = adminMapper.findAllCompanies();

        model.addAttribute("companiesList", companiesList);

        model.addAttribute("admin", admin);

        return "admin/admin_manager_detail_edit";
    }


    /**
     * 管理者情報を編集する.
     *
     * @param adminEditForm
     * @return
     */
    @RequestMapping("/editAdminDetail")
    public String editAdminDetail(AdminEditForm adminEditForm) {

        adminService.editAdminAndRelationCompanies(adminEditForm);

        return "redirect:/admin/operationManager";
    }


    /**
     * 受講者情報インポート画面表示.
     * @return
     */
    @RequestMapping("/registerStudent")
    public String registerStudent(){

        return "admin/admin_training_import_students";
    }

    /**
     * CSVファイルをインポートする
     * @param csvFileForm
     * @param model
     * @return
     */
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

            while ((currentContents = bufferedReader.readLine()) != null) {
                String[] arrayColumnData = currentContents.split(",");
                Student student = new Student();
                student.setName(arrayColumnData[0]);
                student.setKana(arrayColumnData[1]);
                student.setEmail(arrayColumnData[2]);
                student.setPassword(arrayColumnData[3]);
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

        return "redirect:/admin/registerStudent";
    }

    /**
     * 受講生登録機能
     * @return
     */
    @RequestMapping("/studentsRegister")
    public String studentsRegister(){

        Object studentList = session.getAttribute("studentList");

        adminService.insertStudent((List<Student>)studentList);

        return "redirect:/admin/operationManager";
    }

}