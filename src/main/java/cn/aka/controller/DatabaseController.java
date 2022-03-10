//package cn.aka.controller;
//
//import cn.aka.pojo.*;
//import cn.aka.service.DatabaseService;
//import cn.aka.util.CurrentConn;
//import cn.aka.util.DateUtil;
//import cn.aka.util.ResponseUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.*;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//@Controller
//public class DatabaseController {
//    @Autowired
//    private DatabaseService databaseService;
//    private static String username;
//    private static String password;
//
//    static{
//        Properties prop = new Properties();
//        try {
//            InputStream is = CurrentConn.class.getResourceAsStream("/jdbc.properties");
//            prop.load(is);
//            username = CurrentConn.getDecryptString(prop.getProperty("username"));
//            password = CurrentConn.getDecryptString(prop.getProperty("password"));
//            is.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//    @RequestMapping("/databackManage.do")
//    public String databackManage() {
//        return "databackManage";
//    }
//
//    /**
//     * 数据库恢复管理页面
//     */
//    @RequestMapping("/datarecoverManage.do")
//    public String datarecoverManage() {
//        return "datarecoverManage";
//    }
//
//    /**
//     * 数据库整理管理页面
//     */
//    @RequestMapping("/dataorderManage.do")
//    public String dataorderManage() {
//        return "dataorderManage";
//    }
//
//    /**
//     * 数据库初始化管理页面
//     */
//    @RequestMapping("/datainitManage.do")
//    public String datainitManage() {
//        return "datainitManage";
//    }
//
//
//    private Boolean save(Database database) throws Exception {
//        int resultTotal = 0;
//        resultTotal = databaseService.addDatabase(database);
//        boolean result = false;
//        if (resultTotal > 0) { // 执行成功
//            result = true;
//        }
//        return result;
//    }
//    @RequestMapping("/databasedelete.do")
//    public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
//        Result result = new Result();
//        String[] idsStr = ids.split(",");
//        for (int i = 0; i < idsStr.length; i++) {
//            databaseService.deleteDatabase(Integer.parseInt(idsStr[i]));
//        }
//        result.setErrres(200);
//        result.setErrmsg("记录删除成功！");
//        ResponseUtil.write(response, result);
//        return null;
//    }
//
//    /**
//     * 查询数据库备份集合
//     *
//     * @param page
//     * @param rows
//     * @param s_databack
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/databaselist.do")
//    public ResultBean<Database> list(@RequestParam(value = "dataid", required = true) Integer dataid,
//                       @RequestParam(value = "page", required = false) String page,
//                       @RequestParam(value = "rows", required = false) String rows, Database s_databack, HttpServletResponse response)
//            throws Exception {
//        PageBean pageBean = new PageBean((Integer.parseInt(page)-1)*Integer.parseInt(rows), Integer.parseInt(rows));
//        ModelAndView mv = new ModelAndView();
//        ResultBean<Database> resultBean = new ResultBean<>();
//        mv.addObject("username", s_databack.getUsername());
//        mv.addObject("starttime", s_databack.getStarttime());
//        mv.addObject("endtime", s_databack.getEndtime());
//        mv.addObject("dataid", dataid);
//        mv.addObject("start", pageBean.getStart());
//        mv.addObject("size", pageBean.getPageSize());
//        List<Database> databacklist = databaseService.findDataBack(s_databack);
//        Long total = databaseService.getDataBackTotal(s_databack);
//        Result result = new Result();
//        resultBean.setTotal(total);
//        resultBean.setRows(databacklist);
//        ResponseUtil.write(response, result);
//        return resultBean;
//    }
//
//    /**
//     * 数据备份执行
//     * 前台传入location以及userid
//     * @param databack
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/databack.do")
//    public String databack(@RequestParam(value = "location", required = true) String basepath,
//                           @RequestParam(value = "userid", required = true) Integer userid,
//                           Database databack, HttpServletResponse response, HttpSession session) {
//        Result result = new Result();
//        try{
//            Runtime rt = Runtime.getRuntime();
//            Process child = rt.exec("mysqldump -u" + username + " -p" + password + " ffms t_datadic t_income t_pay t_role t_security t_shares t_trade t_user t_user_role ");// 设置导出编码为utf8。这里必须是utf8
//            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
//
//            InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码
//
//            String inStr;
//            StringBuffer sb = new StringBuffer("");
//            String outStr;
//            BufferedReader br = new BufferedReader(xx);
//            while ((inStr = br.readLine()) != null) {
//                sb.append(inStr + "\r\n");
//            }
//            outStr = sb.toString();
//            String regex = "^[A-z]:\\\\(.+?)";
//            String regex1 = "^[A-z]:\\\\";
//
//            if(basepath.equals("")){
//                result.setErrres(101);
//                result.setErrmsg("备份路径不能为空！");
//            }else if(!basepath.matches(regex)&&!basepath.matches(regex1)) {
//                result.setErrres(101);
//                result.setErrmsg( "备份路径不正确！");
//            }else{
//                File file = new File(basepath);
//                if(file.exists()==false){
//                    file.mkdir();
//                }
//
//                String filepath = basepath + "\\" + DateUtil.getCurrentDateCustomFormat("yyyyMMddHHmmss") + ".sql";
//                File files = new File(filepath);
//                if(files.exists()==false){
//                    file.createNewFile();
//                }
//                FileOutputStream fout = new FileOutputStream(filepath);
//
//                OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
//                writer.write(outStr);
//                writer.flush();
//                in.close();
//                xx.close();
//                br.close();
//                writer.close();
//                fout.close();
//
//                databack.setUserid(userid);
//                databack.setFilename(DateUtil.getCurrentDateCustomFormat("yyyyMMddHHmmss")+".sql");
//                databack.setTime(DateUtil.getCurrentDateCustomFormat("yyyy-MM-dd HH:mm:ss"));
//                databack.setLocation(filepath);
//                databack.setDataid(1);
//
//                if (save(databack)) {
//                    result.setErrres(200);
//                    result.setErrmsg("数据备份成功！");
//                }else{
//                    result.setErrres(101);
//                    result.setErrmsg("数据备份失败");
//                }
//
//            }
//        }catch(Exception e){
//            System.out.println("异常");
//            e.printStackTrace();
//            result.setErrres(101);
//            result.setErrmsg("数据备份失败");
//        }
//        ResponseUtil.write(response, result);
//        return null;
//    }
//
//    /**
//     * 数据恢复
//     * 前台传入userid，filename，location
//     * @param datarecover
//     * @param response
//     * @param session
//     * @return
//     */
//    @RequestMapping("/datarecover.do")
//    public String datarecover(@RequestParam(value = "location", required = true) String location,
//                              @RequestParam(value = "filename", required = true) String filename,
//                              @RequestParam(value = "userid", required = true) Integer userid,
//                              Database datarecover, HttpServletResponse response, HttpSession session) {
//        Result result = new Result();
//        try{
//            Runtime rt = Runtime.getRuntime();
//            Process child = rt.exec("mysql -u"+username+" -p"+password+" ffms");
//
//            OutputStream out = child.getOutputStream();// 控制台的输入信息作为输出流
//            String inStr;
//            StringBuffer sb = new StringBuffer("");
//            String outStr;
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(location), "utf-8"));
//            while ((inStr = br.readLine()) != null) {
//                sb.append(inStr + "\r\n");
//            }
//            outStr = sb.toString();
//            OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
//            writer.write(outStr);
//            writer.flush();
//            out.close();
//            br.close();
//            writer.close();
//
//            datarecover.setUserid(userid);
//            datarecover.setFilename(filename);
//            datarecover.setTime(DateUtil.getCurrentDateCustomFormat("yyyy-MM-dd HH:mm:ss"));
//            datarecover.setLocation(location);
//            datarecover.setDataid(2);
//
//            if (save(datarecover)) {
//                result.setErrres(200);
//                result.setErrmsg("数据恢复成功！");
//            }else{
//                result.setErrres(101);
//                result.setErrmsg("数据恢复失败");
//            }
//
//        }catch(Exception e){
//            System.out.println("异常");
//            e.printStackTrace();
//            result.setErrres(101);
//            result.setErrmsg("数据恢复失败");
//        }
//        ResponseUtil.write(response, result);
//        return null;
//    }
//
//    /**
//     * 清空数据库操作记录
//
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/datainit.do")
//    public String datainit(@RequestParam(value = "userid") Integer userid, Database datainit, HttpServletResponse response) throws Exception {
//        Result result = new Result();
//        String[] tables = {"t_income","t_pay","t_security","t_shares","t_trade"};
//        for (int i = 0; i < tables.length; i++) {
//            databaseService.truncateTable(tables[i]);
//        }
//
//        datainit.setUserid(userid);
//        datainit.setTime(DateUtil.getCurrentDateCustomFormat("yyyy-MM-dd HH:mm:ss"));
//        datainit.setDataid(3);
//
//        if (save(datainit)) {
//            result.setErrres(200);
//            result.setErrmsg("数据库初始化成功！");
//        }else{
//            result.setErrres(101);
//            result.setErrmsg("数据库初始化失败");
//        }
//        ResponseUtil.write(response, result);
//        return null;
//    }
//
//    /**
//     * 清空数据库操作记录
//
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/dataorder.do")
//    public String dataorder(@RequestParam(value = "userid") Integer userid,
//                            @RequestParam(value = "tablename") String tablename,
//                            @RequestParam(value = "startid") Integer startid,
//                            @RequestParam(value = "endid") Integer endid,
//                            Database dataorder, HttpServletResponse response) throws Exception {
//        int resultTotal = 0;
//        Result result = new Result();
//        resultTotal = databaseService.deleteOrderdata(tablename,startid,endid);
//        if (resultTotal>0) {
//            dataorder.setUserid(userid);
//            dataorder.setTime(DateUtil.getCurrentDateCustomFormat("yyyy-MM-dd HH:mm:ss"));
//            dataorder.setDataid(4);
//            dataorder.setLocation("删除【"+tablename+"】表中第" + startid + "条到第" + endid + "条数据");
//            if (save(dataorder)) {
//                result.setErrres(200);
//                result.setErrmsg("数据整理完成！");
//            }else{
//                result.setErrres(101);
//                result.setErrmsg("数据整理失败");
//            }
//        }else{
//            result.setErrres(404);
//            result.setErrmsg("所选数据不存在！");
//        }
//        ResponseUtil.write(response, result);
//        return null;
//    }
//
//    /**
//     * 打开文件资源管理器
//     * @param response
//     * @return
//     */
//    @RequestMapping("/openFileDialog.do")
//    public String openFileDialog(HttpServletResponse response){
//        Result result = new Result();
//        try {
//            java.awt.Desktop.getDesktop().open(new java.io.File("D:\\360Downloads\\apache-tomcat-8.0.44\\DBback"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        result.setErrres(200);
//        result.setErrmsg("文件资源管理器打开成功！");
//        ResponseUtil.write(response, result);
//        return null;
//    }
//
//}
