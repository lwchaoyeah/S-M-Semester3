<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="SearchRecords.aspx.cs" Inherits="Fit5192Asssignment2.SearchRecords" %>
<!--Zeng Jiaxin-->
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="~/TableSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
         <asp:accessdatasource runat="server" 
                ID ="dsAccess" DataFile="~/App_Data/assignment2.accdb"
                SelectCommand="SELECT * FROM [userInfo]"
                />
    <form id="form1" runat="server">
        <div class ="tableCSSView">
            <center><h2>Find Customers</h2></center>
            <table >
                <tr>
                    <td >
                        <asp:TextBox ID="txtFullName" runat="server"
                          Width="100"></asp:TextBox>
                    </td>
                    <td>
                        <asp:Button ID="btnFullName" OnClick="findCustomer"
                          runat="server"
                             Width="200"
                          Text="find customers by fullName"
                          CommandName="FullName" />
                    </td>
                </tr>
                <tr>
                    <td >
                        <asp:TextBox ID="textEmail" runat="server"
                          Width="100"></asp:TextBox>
                    </td>
                    <td>
                        <asp:Button ID="btnEmail" OnClick="findCustomer"
                          runat="server"
                            Width="200"
                          Text="find customers by email"
                           CommandName="Email" />
                    </td>
                </tr>
            </table>
        </div>
        <div class ="tableCSSView">
            <asp:ListView runat="server" ID="userInfoView" >
             <ItemTemplate>
                <table width ="40%" >
                    <tr>
                        <td >
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
              </ItemTemplate>
         </asp:ListView>
        </div>
    </form>
    <div>
        <p align="center">
            <asp:HyperLink runat="server" ImageUrl="~/Images/SearchRecords.jpg"  Target="_blank" NavigateUrl="~/DisplayCode.aspx?filename=SearchRecords.aspx" />
        </p>
    </div>
</body>
</html>
