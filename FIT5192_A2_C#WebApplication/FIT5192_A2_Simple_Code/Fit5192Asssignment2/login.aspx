<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" StylesheetTheme="SkinDefault" Inherits="Fit5192Asssignment2.login" %>

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
                SelectCommand="SELECT [Username], [Password] FROM [userInfo]"
                OnSelected="CheckLogin"/>
    <div>
        <table>
            <tr><td width ="62%"></td>
                <td>
                    <form id="form1" runat="server">
                    <%-- asp login component --%>
                    <asp:Login  ID="Login1"
                        runat="server" 
                        OnAuthenticate="Login_Authenticate"
                        TitleText="<br />Please enter your details below to login for this site.<br /><br />"
                        UserNameLabelText="Username:"
                        PasswordLabelText="Password:"
                        UserNameRequiredErrorMessage="Username required<p />"
                        PasswordRequiredErrorMessage="Password required"
                        LoginButtonText="Click to login"
                        DisplayRememberMe="False">
                                
                    </asp:Login>
                        <p />
                    <%-- the error message --%>
                    <asp:ValidationSummary ID="vlSummary1" 
                        Visible="true" CssClass="vldSummary"
                        runat="server" ValidationGroup="Login1"
                        HeaderText="Please correct the following errors:" />
                </form>    

                </td>
                
            </tr>
        </table>
       
    </div>
     <div>
         <p align="center">
            <asp:HyperLink runat="server" ImageUrl="~/Images/login.jpg"  Target="_blank" NavigateUrl="~/DisplayCode.aspx?filename=login.aspx" />
         </p>
    </div>
</body>
</html>
