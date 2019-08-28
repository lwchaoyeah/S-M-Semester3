<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DisplayCode.aspx.cs" Inherits="Fit5192Asssignment2.DisplayCode" %>

<!--Li Wenchao-->
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
  <title>Display Code</title>
  <link rel="stylesheet" href="StyleSheetsimple.css" type="text/css" />
</head>
<body>
  <form id="form1" runat="server">
    <div>
      
        <h1 class="pageHeader">Source Code</h1>
      
        <asp:Label ID="FileName"
        CssClass="codeHeader" runat="server" />
      <asp:Panel ID="pnlCode" CssClass="code"
        runat="server" Width="80%">
        <asp:Label ID="Code" runat="server" />
      </asp:Panel>

        
      <asp:Label ID="FileName2"
        CssClass="codeHeader" runat="server" />
      <asp:Panel ID="pnlCode2" CssClass="code"
        runat="server" Width="80%" Visible="False">
          <asp:Label ID="Code2" runat="server" />
       </asp:Panel>
         
      <asp:Label ID="FileName3"
        CssClass="codeHeader" runat="server"/>
      <asp:Panel ID="pnlCode3" CssClass="code"
        runat="server" Width="80%" Visible="False">
          <asp:Label ID="Code3" runat="server" />
       </asp:Panel>
        

    </div>
  </form>
</body>
</html>