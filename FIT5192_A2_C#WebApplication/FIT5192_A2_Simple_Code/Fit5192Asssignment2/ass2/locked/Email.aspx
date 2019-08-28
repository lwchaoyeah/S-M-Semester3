<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeBehind="Email.aspx.cs" Inherits="Fit5192Asssignment2.ass2.locked.Email" %>


<asp:Content ID="emailContent" ContentPlaceHolderID="ContentPlaceHolder1" 
      Runat="Server">
<!--Li Wenchao-->        
    <asp:AccessDataSource ID="AccessDataSource1" runat="server"
    DataFile="~/App_Data/assignment2.accdb"
    SelectCommand="SELECT ID, Username, email, 
        userImage FROM userInfo"></asp:AccessDataSource>
  
    <div class="tableCSSView">
      <asp:Label ID="lblMail" CssClass="error" runat="server" />
      <p />
      <asp:GridView ID="gvCustomers" runat="server" DataSourceID="AccessDataSource1" DataKeyNames="ID"
        AutoGenerateColumns="false" RowStyle-CssClass="customerRow" AlternatingRowStyle-CssClass="customerAlternate"
        HeaderStyle-CssClass="customerHeader" CssClass="customerGrid" CellPadding="5"
           AllowPaging="True"
           AllowSorting="True">
        <Columns>
          <asp:BoundField DataField="ID" Visible="false" />
          <asp:BoundField DataField="Username" HeaderText="Full Name" />
          <asp:BoundField DataField="email" HeaderText="Email" ReadOnly="True"  SortExpression="email" />
          <asp:ImageField AlternateText="~/Images/user_1.jpg" 
             DataImageUrlField="userImage"
            DataImageUrlFormatString="~/Images/{0}"
            HeaderText="Photo" />
          <asp:TemplateField HeaderText="Select">
            <ItemTemplate>
              <asp:CheckBox runat="server" ID="chkEmail" />
            </ItemTemplate>
          </asp:TemplateField>
        </Columns>
      </asp:GridView>
      <table class="emailTable">
        <tr>
          <td class="emailHeader" width="15%">From
          </td>
          <td class="emailRow">admin
          </td>
        </tr>
        <tr>
          <td class="emailHeader" width="15%">Subject
          </td>
          <td class="emailRow">
            <asp:TextBox ID="txtSubject" Width="350" runat="server" />
          </td>
        </tr>
        <tr>
          <td class="emailHeader" width="15%">Attachment
          </td>
          <td class="emailRow">
            <asp:FileUpload ID="fileUpload" runat="server" Width="430" />
          </td>
        </tr>
        <tr>
          <td class="emailHeader">Message
          </td>
          <td class="emailRow">
            <asp:TextBox runat="server" ID="txtMsg" TextMode="MultiLine" Columns="55" Rows="15" />
          </td>
        </tr>

          <tr>
          <td class="emailHeader" width="15%">
          </td>
          <td class="emailRow">
            <asp:Button ID="Button1" runat="server" OnClick="SendingEmail" Text="Send Email" />
          </td>
          </tr>
      </table>
    </div>
    <div style="text-align:center;width:400px;margin:0 auto;">
        <p align="center">
            <asp:HyperLink runat="server" ImageUrl="~/Images/email.jpg"  Target="_blank" NavigateUrl="~/DisplayCode.aspx?filename=/ass2/locked/Email.aspx" />
        </p>
    </div>
    </asp:Content>
