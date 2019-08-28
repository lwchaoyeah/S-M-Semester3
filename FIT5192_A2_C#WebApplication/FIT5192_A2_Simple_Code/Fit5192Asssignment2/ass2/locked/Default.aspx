<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Fit5192Asssignment2.ass2.locked.Default" %>
<!--Zeng Jiaxin-->

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
      <form id="form1" runat="server">
    <div class="heading3">
        Welcome 
        <asp:Label ID="lblUser" runat="server"/>
        , to the Secret Chamber
        <p />
        you have used 
        <asp:Label ID="lblType" runat="server"/>
        authentication to log on.
        <p />
        <asp:Button ID="Button1" Text="Logout" OnClick="Logout_Click" 
          runat="server" />
    </div>
    </form>
</body>
</html>
