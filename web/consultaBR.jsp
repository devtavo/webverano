<%-- 
    Document   : consulta
    Created on : 13-feb-2019, 14:09:14
    Author     : gustavo-pc
--%>


<%@page import="java.util.ArrayList"%>
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
        <script>
            function buscar1(){
                var idpersona = document.getElementById("idpersona").value;
                $.ajax({
                    data:{codigo:idpersona},
                    type: 'POST',
                    url: "consultabrmodal.jsp",
                    success: function (response) {
                        document.getElementById("divbuscabr").innerHTML=response;
                    }
                });
            }
            
            </script>
    </head>
    <body>
        <% 
            String funcionario=request.getParameter("funcionario"); 
//            String date1=request.getParameter("date1"); 
//            String date2=request.getParameter("date2"); 
//            String estado=request.getParameter("selestado"); 
            
            personabe p=new personabe();
       
       
        personabr pbr=new personabr();
        personabe pbe= new personabe();
        
        
        List<personabe> los= pbr.consultareclamo(funcionario);
           
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
      
       <div class="panel text-uppercase" >
        
                       <table class="table table-hover" id="myTable">
                           <thead class="black white-text ">
                               <tr><th>#</th>
                                   <th >Ticket</th>
                                   <th >Fecha</th>
                                   <th >Apellido y nombres</th>
                                   <th >Estados</th>
                               </tr>  
                           </thead>
                           <tbody> 
                               <tr><%
                                   for(personabe  d : los) {
                                           
                                      %>
                                      <td><%=los.indexOf(d) %> </td>
                                      <td ><input type="hidden"  name="idpersona" id="idpersona" value="<%=d.getIdpersona()%>"><%=d.getIdpersona()%> </td>
                                       <td><%=d.getFecha()%> </td>
                                       <td><%=d.getNombre()%> </td>
                                     
                                       <td>
                                           <button type="button" onclick ="buscar1()" class="btn btn-success" data-toggle="modal" data-target="#myModal" >ver</button>
                                           <button type="button" class="disabled btn btn-info ">editar</button>
                                           <button type="button" class="disabled btn btn-toolbar">seguimiento</button>
                                           
                                       </td>
                                      
                               </tr>
                                <%}%>
                           </tbody>
                       </table>
                           <div class="modal fade" tabindex="-1" id="myModal" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <!--aqui va el titulo-->
       
      </div>
      <div class="modal-body">
       <!--aqui todo el cuerpo del modal-->
       <div id="divbuscabr">
           
       </div>
       </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
            
      </div>
               
    </body>
</html>
