/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-03-10 08:29:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class roleManage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/common/Head.jsp", Long.valueOf(1499241501000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath ="";
	if(request.getServerPort()==80){
		basePath=request.getScheme()+"://"+request.getServerName()+path+"/";
	}else{
		basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	}
	pageContext.setAttribute("basePath", basePath);

      out.write('\r');
      out.write('\n');

	String themeName = "default";
	Cookie cookies[] = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(int i = 0; i < cookies.length; i++){
			if("themeName".equals(cookies[i].getName())){
				themeName = cookies[i].getValue();
				break;
			}
		}
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link class=\"uiTheme\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("jquery-easyui-1.3.3/themes/");
      out.print(themeName );
      out.write("/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("jquery-easyui-1.3.3/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("jquery-easyui-1.3.3/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("jquery-easyui-1.3.3/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("jquery-easyui-1.3.3/jquery.cookie.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\tvar url;\r\n");
      out.write("\t\r\n");
      out.write("\tfunction searchRole(){\r\n");
      out.write("\t\t$(\"#dg\").datagrid('load',{\r\n");
      out.write("\t\t\t\"rolename\":$(\"#s_rolename\").val()\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction resetSearch(){\r\n");
      out.write("\t\t$(\"#s_rolename\").val(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction deleteRole(){\r\n");
      out.write("\t\tvar selectedRows=$(\"#dg\").datagrid('getSelections');\r\n");
      out.write("\t\tif(selectedRows.length==0){\r\n");
      out.write("\t\t\t$.messager.alert(\"系统提示\",\"请选择要删除的数据！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar strIds=[];\r\n");
      out.write("\t\tfor(var i=0;i<selectedRows.length;i++){\r\n");
      out.write("\t\t\tstrIds.push(selectedRows[i].id);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar ids=strIds.join(\",\");\r\n");
      out.write("\t\t$.messager.confirm(\"系统提示\",\"您确认要删除这<font color=red>\"+selectedRows.length+\"</font>条数据吗？\",function(r){\r\n");
      out.write("\t\t\tif(r){\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("roledelete.do\",{ids:ids},function(result){\r\n");
      out.write("\t\t\t\t\tif(result.errres){\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"系统提示\",result.errmsg);\r\n");
      out.write("\t\t\t\t\t\t$(\"#dg\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"系统提示\",result.errmsg);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\"json\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction openRoleAddDialog(){\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"open\").dialog(\"setTitle\",\"添加角色信息\");\r\n");
      out.write("\t\turl=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("rolesave.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction openRoleModifyDialog(){\r\n");
      out.write("\t\tvar selectedRows=$(\"#dg\").datagrid('getSelections');\r\n");
      out.write("\t\tif(selectedRows.length!=1){\r\n");
      out.write("\t\t\t$.messager.alert(\"系统提示\",\"请选择一条要编辑的数据！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar row=selectedRows[0];\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"open\").dialog(\"setTitle\",\"编辑角色信息\");\r\n");
      out.write("\t\t$('#fm').form('load',row);\r\n");
      out.write("\t\turl=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("rolesave.do?id=\"+row.id;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction saveRole(){\r\n");
      out.write("\t\t$(\"#fm\").form(\"submit\",{\r\n");
      out.write("\t\t\turl:url,\r\n");
      out.write("\t\t\tonSubmit:function(){\r\n");
      out.write("\t\t\t\treturn $(this).form(\"validate\");\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess:function(result){\r\n");
      out.write("\t\t\t\tvar result=eval('('+result+')');\r\n");
      out.write("\t\t\t\tif(result.errres){\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\",result.errmsg);\r\n");
      out.write("\t\t\t\t\tresetValue();\r\n");
      out.write("\t\t\t\t\t$(\"#dlg\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t$(\"#dg\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\",result.errmsg);\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction resetValue(){\r\n");
      out.write("\t\t$(\"#rolename\").val(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction closeRoleDialog(){\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"close\");\r\n");
      out.write("\t\tresetValue();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"margin:1px;\">\r\n");
      out.write("\t<table id=\"dg\" title=\"角色管理\" class=\"easyui-datagrid\"\r\n");
      out.write("\t fitColumns=\"true\" pagination=\"true\" rownumbers=\"true\"\r\n");
      out.write("\t url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("rolelist.do\" fit=\"true\" toolbar=\"#tb\" remoteSort=\"false\" multiSort=\"true\">\r\n");
      out.write("\t <thead>\r\n");
      out.write("\t \t<tr>\r\n");
      out.write("\t \t\t<th field=\"cb\" checkbox=\"true\" align=\"center\"></th>\r\n");
      out.write("\t \t\t<th field=\"id\" width=\"50\" align=\"center\" sortable=\"true\">编号</th>\r\n");
      out.write("\t \t\t<th field=\"rolename\" width=\"100\" align=\"center\" sortable=\"true\">角色名称</th>\r\n");
      out.write("\t \t</tr>\r\n");
      out.write("\t </thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<div id=\"tb\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a href=\"javascript:openRoleAddDialog()\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\">添加</a>\r\n");
      out.write("\t\t\t<a href=\"javascript:openRoleModifyDialog()\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">修改</a>\r\n");
      out.write("\t\t\t<a href=\"javascript:deleteRole()\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\">删除</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t&nbsp;角色名称：&nbsp;<input type=\"text\" id=\"s_rolename\" size=\"15\" onkeydown=\"if(event.keyCode==13) searchRole()\"/>\r\n");
      out.write("\t\t\t<a href=\"javascript:searchRole()\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\">搜索</a>\r\n");
      out.write("\t\t\t<a href=\"javascript:resetSearch()\" class=\"easyui-linkbutton\" iconCls=\"icon-reset\" plain=\"true\">清空</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"dlg\" class=\"easyui-dialog\" style=\"width: 320px;height:150px;padding: 10px 20px\" closed=\"true\" buttons=\"#dlg-buttons\">\r\n");
      out.write("\t \t<form id=\"fm\" method=\"post\">\r\n");
      out.write("\t \t\t<table cellspacing=\"8px\">\r\n");
      out.write("\t \t\t\t<tr>\r\n");
      out.write("\t \t\t\t\t<td>角色名称：</td>\r\n");
      out.write("\t \t\t\t\t<td><input type=\"text\" id=\"rolename\" name=\"rolename\" class=\"easyui-validatebox easyui-textbox\" required=\"true\"/>&nbsp;<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t \t\t</table>\r\n");
      out.write("\t \t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"dlg-buttons\">\r\n");
      out.write("\t\t<a href=\"javascript:saveRole()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">保存</a>\r\n");
      out.write("\t\t<a href=\"javascript:closeRoleDialog()\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">关闭</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
