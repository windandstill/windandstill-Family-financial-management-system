/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-03-10 13:15:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class sharesManage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/common/Head.jsp", Long.valueOf(1499241501000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar url;\r\n");
      out.write("\r\n");
      out.write("\tfunction searchShares() {\r\n");
      out.write("\t\t$(\"#dg\").datagrid('load',{\r\n");
      out.write("\t\t\t\"sharesname\" : $(\"#s_sharesname\").val(),\r\n");
      out.write("\t\t\t\"holder\" : $(\"#s_holder\").combobox(\"getValue\"),\r\n");
      out.write("\t\t\t\"securityname\" : $(\"#s_securityname\").combobox(\"getValue\")\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction resetSearch() {\r\n");
      out.write("\t\t$(\"#s_sharesname\").val(\"\");\r\n");
      out.write("\t\t$(\"#s_holder\").combobox(\"setValue\", \"\");\r\n");
      out.write("\t\t$(\"#s_securityname\").combobox(\"setValue\", \"\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction deleteShares() {\r\n");
      out.write("\t\tvar selectedRows = $(\"#dg\").datagrid('getSelections');\r\n");
      out.write("\t\tif (selectedRows.length == 0) {\r\n");
      out.write("\t\t\t$.messager.alert(\"系统提示\", \"请选择要删除的数据！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar strIds = [];\r\n");
      out.write("\t\tfor (var i = 0; i < selectedRows.length; i++) {\r\n");
      out.write("\t\t\tstrIds.push(selectedRows[i].id);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar ids = strIds.join(\",\");\r\n");
      out.write("\t\t$.messager.confirm(\"系统提示\", \"您确认要删除这<font color=red>\"\r\n");
      out.write("\t\t\t\t+ selectedRows.length + \"</font>条数据吗？\", function(r) {\r\n");
      out.write("\t\t\tif (r) {\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("sharesdelete.do\", {\r\n");
      out.write("\t\t\t\t\tids : ids\r\n");
      out.write("\t\t\t\t}, function(result) {\r\n");
      out.write("\t\t\t\t\tif (result.errres) {\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"系统提示\", result.errmsg);\r\n");
      out.write("\t\t\t\t\t\t$(\"#dg\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"系统提示\", \"数据删除失败！\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}, \"json\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction openSharesAddDialog() {\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"open\").dialog(\"setTitle\", \"添加股票信息\");\r\n");
      out.write("\t\turl = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("sharessave.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction openSharesModifyDialog() {\r\n");
      out.write("\t\tvar selectedRows = $(\"#dg\").datagrid('getSelections');\r\n");
      out.write("\t\tif (selectedRows.length != 1) {\r\n");
      out.write("\t\t\t$.messager.alert(\"系统提示\", \"请选择一条要编辑的数据！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar row = selectedRows[0];\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"open\").dialog(\"setTitle\", \"编辑股票信息\");\r\n");
      out.write("\t\t$('#fm').form('load', row);\r\n");
      out.write("\t\turl = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("sharessave.do?id=\" + row.id;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction saveShares() {\r\n");
      out.write("\t\t$(\"#fm\").form(\"submit\",{\r\n");
      out.write("\t\t\turl : url,\r\n");
      out.write("\t\t\tonSubmit : function() {\r\n");
      out.write("\t\t\t\treturn $(this).form(\"validate\");\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\tvar result = eval('(' + result + ')');\r\n");
      out.write("\t\t\t\tif (result.errres) {\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\", result.errmsg);\r\n");
      out.write("\t\t\t\t\tresetValue();\r\n");
      out.write("\t\t\t\t\t$(\"#dlg\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t$(\"#dg\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\", result.errmsg);\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction resetValue() {\r\n");
      out.write("\t\t$(\"#holder\").combobox(\"setValue\", \"\");\r\n");
      out.write("\t\t$(\"#securityname\").combobox(\"setValue\", \"\");\r\n");
      out.write("\t\t$(\"#sharesname\").val(\"\");\r\n");
      out.write("\t\t$(\"#price\").numberbox(\"setValue\", \"\");\r\n");
      out.write("\t\t$(\"#number\").numberbox(\"setValue\", \"\");\r\n");
      out.write("\t\t$(\"#sharestime\").datetimebox(\"setValue\", \"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction closeSharesDialog() {\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"close\");\r\n");
      out.write("\t\tresetValue();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"margin: 1px;\">\r\n");
      out.write("\t<table id=\"dg\" title=\"持股管理\" class=\"easyui-datagrid\" fitColumns=\"true\"\r\n");
      out.write("\t\tpagination=\"true\" rownumbers=\"true\" url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("shareslist.do?roleid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.roleid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&userid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\tfit=\"true\" toolbar=\"#tb\" remoteSort=\"false\" multiSort=\"true\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th field=\"cb\" checkbox=\"true\" align=\"center\"></th>\r\n");
      out.write("\t\t\t\t<th field=\"id\" width=\"50\" align=\"center\" sortable=\"true\">编号</th>\r\n");
      out.write("\t\t\t\t<th field=\"username\" width=\"100\" align=\"center\" sortable=\"true\">记录人</th>\r\n");
      out.write("\t\t\t\t<th field=\"sharesname\" width=\"100\" align=\"center\" sortable=\"true\">股票名称</th>\r\n");
      out.write("\t\t\t\t<th field=\"holder\" width=\"100\" align=\"center\" sortable=\"true\">持股人</th>\r\n");
      out.write("\t\t\t\t<th field=\"securityname\" width=\"100\" align=\"center\" sortable=\"true\">证券账号</th>\r\n");
      out.write("\t\t\t\t<th field=\"createtime\" width=\"100\" align=\"center\" sortable=\"true\">创建时间</th>\r\n");
      out.write("\t\t\t\t<th field=\"updatetime\" width=\"100\" align=\"center\" sortable=\"true\">修改时间</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<div id=\"tb\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a href=\"javascript:openSharesAddDialog()\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\t\ticonCls=\"icon-add\" plain=\"true\">添加</a> <a\r\n");
      out.write("\t\t\t\thref=\"javascript:openSharesModifyDialog()\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\t\ticonCls=\"icon-edit\" plain=\"true\">修改</a> <a\r\n");
      out.write("\t\t\t\thref=\"javascript:deleteShares()\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\t\ticonCls=\"icon-remove\" plain=\"true\">删除</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t&nbsp;股票名称：&nbsp;<input type=\"text\" id=\"s_sharesname\" size=\"15\" onkeydown=\"if(event.keyCode==13) searchShares()\" />\r\n");
      out.write("\t\t\t&nbsp;持股人：&nbsp;<select class=\"easyui-combobox\" id=\"s_holder\" editable=\"true\" style=\"width: 140px;\" onkeydown=\"if(event.keyCode==13) searchShares()\">\r\n");
      out.write("\t\t\t\t<option value=\"\">请选择...</option>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t&nbsp;证券账号：&nbsp;<select class=\"easyui-combobox\" id=\"s_securityname\" editable=\"true\" style=\"width: 140px;\" onkeydown=\"if(event.keyCode==13) searchShares()\">\r\n");
      out.write("\t\t\t\t<option value=\"\">请选择类型...</option>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<a href=\"javascript:searchShares()\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\">搜索</a> \r\n");
      out.write("\t\t\t<a href=\"javascript:resetSearch()\" class=\"easyui-linkbutton\" iconCls=\"icon-reset\" plain=\"true\">清空</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"dlg\" class=\"easyui-dialog\" style=\"width: 670px; height: 200px; padding: 10px 20px\" closed=\"true\" buttons=\"#dlg-buttons\">\r\n");
      out.write("\t\t<form id=\"fm\" method=\"post\">\r\n");
      out.write("\t\t\t<table cellspacing=\"8px\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>股票名称：</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"sharesname\" name=\"sharesname\" class=\"easyui-validatebox easyui-textbox\" required=\"true\" />&nbsp;<font\r\n");
      out.write("\t\t\t\t\t\tcolor=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>持股人：</td>\r\n");
      out.write("\t\t\t\t\t<td><select class=\"easyui-combobox\" id=\"holder\" name=\"holder\" editable=\"true\" style=\"width: 175px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">请选择...</option>\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>&nbsp;<font color=\"red\">*</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>证券账号：</td>\r\n");
      out.write("\t\t\t\t\t<td><select class=\"easyui-combobox\" id=\"securityid\" name=\"securityid\" editable=\"false\" style=\"width: 175px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">请选择类型...</option>\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>&nbsp;<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"hidden\" id=\"userid\" name=\"userid\" class=\"easyui-validatebox easyui-textbox\" required=\"true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"dlg-buttons\">\r\n");
      out.write("\t\t<a href=\"javascript:saveShares()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">保存</a> \r\n");
      out.write("\t\t<a href=\"javascript:closeSharesDialog()\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">关闭</a>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/pages/sharesManage.jsp(144,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/sharesManage.jsp(144,4) '${allUsers }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allUsers }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/pages/sharesManage.jsp(144,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("alluser");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${alluser.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${alluser.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/pages/sharesManage.jsp(150,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/sharesManage.jsp(150,4) '${allSecuritys }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allSecuritys }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/pages/sharesManage.jsp(150,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("allSecurity");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allSecurity.securityname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allSecurity.securityname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent(null);
    // /WEB-INF/pages/sharesManage.jsp(170,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/sharesManage.jsp(170,7) '${allUsers }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allUsers }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/pages/sharesManage.jsp(170,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("alluser");
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${alluser.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${alluser.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f3.setParent(null);
    // /WEB-INF/pages/sharesManage.jsp(180,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/sharesManage.jsp(180,7) '${allSecuritys }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allSecuritys }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/pages/sharesManage.jsp(180,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setVar("allSecurity");
    int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
      if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allSecurity.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allSecurity.securityname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f3.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
    }
    return false;
  }
}
