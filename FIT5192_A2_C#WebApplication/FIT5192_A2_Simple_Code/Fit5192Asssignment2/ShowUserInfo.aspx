<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ShowUserInfo.aspx.cs" Inherits="Fit5192Asssignment2.ShowUserInfo" %>
<!--Zeng Jiaxin-->
<!DOCTYPE html>

<asp:AccessDataSource runat="server" 
    ID ="dsAccess" DataFile="~/App_Data/assignment2.accdb"
    SelectCommand=""
    />
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="~/TableSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
         <asp:ListView runat="server" ID="userInfoView">
             
             <ItemTemplate>
                 <div class="tableCSSView">
                    <table width="60%">
                        <tr>
                            <td colspan="2">
                                User Infomation
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Login username:
                            </td>
                            <td>
                                <%# Eval("Username") %>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                FullName:
                            </td>
                            <td>
                                 <%# Eval("FullName") %>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                email:
                            </td>
                            <td>
                                 <%# Eval("email") %>   
                            </td>
                        </tr>
                        <tr>
                            <td>
                                gender:
                            </td>
                            <td>
                                 <%# Eval("gender") %>   
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Phone Number:
                            </td>
                            <td>
                                <%# Eval("phoneNumber") %>      
                            </td>
                        </tr>
                    
                        <tr>
                            <td>
                                Career:
                            </td>
                            <td>
                                <%# Eval("career") %>       
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Address:
                            </td>
                            <td>
                                <%# Eval("address") %>          
                            </td>
                        </tr>
                        <tr>
                            <td>Age:</td>
                            <td>
                                <%# Eval("age") %>     
                            </td>
                        </tr>
                        <tr>
                            <td>Photo:</td>
                            <td>
                                <asp:Image ID="UserImage"
                                 runat="server" 
                                 ImageUrl='<%# Eval("userImage", "~/Images/{0}") %>'/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                            <hr />
                        </td>
                        </tr>
                    </table>
                    </div>
              </ItemTemplate>
         </asp:ListView>
    </form>
</body>
</html>
