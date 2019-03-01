<%-- 
    Document   : consulta
    Created on : 13-feb-2019, 14:09:14
    Author     : gustavo-pc
--%>


<%@page import="java.util.List"%>
<%@page import="be.personabe"%>
<%@page import="br.personabr"%>
<%@page import="br.personabr"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
         
        <!--query/popper/bootstrap.js--> 

        <script src="js/jquery2.1.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/paginacion.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String funcionario=request.getParameter("funcionario"); 
            String date1=request.getParameter("date1"); 
            String date2=request.getParameter("date2"); 
            String estado=request.getParameter("selestado"); 
            
            personabr pbr= new  personabr();
            personabe pbe=new personabe();
            pbe.setFuncionario(funcionario);
            
//                    List<personabe> lista=new ArrayList();
            List<personabe> lis= new personabr().consultareclamo(pbe);
           
//if(!funcionario.equals("-1")){
//              
//                     
//              
//           }else if(!date1.equals("") && !date2.equals("")){
//             
//                 }else if(!estado.equals("-1") ){
//             
//               } 
//             
       %>
       <table>
     <%
                                   for(personabe  d : lis) {
                                           
                                      %>
                                       
                                      <tr><td>           <%=d.getIdpersona()%>   </td></tr>    <br>
                                      <tr><td><%=d.getFecha()%><br></td></tr>
                                      <tr><td><%=d.getNombre()%><br></td></tr>
                                       <%}%>
                                       
                                       </table>                      
    </body>
</html>
