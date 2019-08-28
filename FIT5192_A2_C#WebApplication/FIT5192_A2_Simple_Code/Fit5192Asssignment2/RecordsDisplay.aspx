<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RecordsDisplay.aspx.cs" Inherits="Fit5192Asssignment2.RecordsDisplay" %>
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
        
        <div class="tableCSSView">
            <asp:GridView ID="gvUserInfo" runat="server"
                DataSourceID="dsAccess"
                AutoGenerateColumns="False"
                OnRowCommand="DisplayData" 
                DataKeyNames="ID"
                AllowPaging="True" 
                AllowSorting="True">
                <Columns>
                    <asp:ButtonField ButtonType="Button" Text="Display"/>
                    <asp:BoundField DataField="ID"
                        HeaderText="ID" ReadOnly="True"
                        InsertVisible="False" SortExpression="ID" />
                     <asp:HyperLinkField DataTextField="UserName"
                        HeaderText="UserName"
                        DataNavigateUrlFields="ID"
                        DataNavigateUrlFormatString="~/ShowUserInfo.aspx?ID={0}"
                        SortExpression="UserName"/>
                    <asp:BoundField DataField="FullName"
                        HeaderText="FullName" ReadOnly="True"
                        InsertVisible="False" SortExpression="FullName" />
                    <asp:BoundField DataField="email"
                        HeaderText="email" ReadOnly="True"
                        InsertVisible="False" SortExpression="email" />
                    <asp:BoundField DataField="gender"
                        HeaderText="Gender" ReadOnly="True"
                        InsertVisible="False" SortExpression="gender" />
                    <asp:BoundField DataField="phoneNumber"
                        HeaderText="Phone Number" ReadOnly="True"
                        InsertVisible="False" SortExpression="phoneNumber" />
                    <asp:BoundField DataField="career"
                        HeaderText="Career" ReadOnly="True"
                        InsertVisible="False" SortExpression="career" />
                    <asp:BoundField DataField="address"
                        HeaderText="Address" ReadOnly="True"
                        InsertVisible="False" SortExpression="address" />
                    <asp:BoundField DataField="age"
                        HeaderText="Age" ReadOnly="True"
                        InsertVisible="False" SortExpression="age" />
                    <asp:ImageField AlternateText="~/Images/user_1.jpg" 
                         DataImageUrlField="userImage"
                         DataImageUrlFormatString="~/Images/{0}"
                         HeaderText="Photo" />
                </Columns>

            </asp:GridView>
            
        </div>
    </form>
    <div class="tableCSSView">
            <asp:Label ID="lblDisplayUserInfo" runat="server"/>
    </div>
    <div>
        <p align="center">
            <asp:HyperLink runat="server" ImageUrl="~/Images/displayRecords.jpg"  Target="_blank" NavigateUrl="~/DisplayCode.aspx?filename=RecordsDisplay.aspx&filename2=SearchRecords.aspx" />
        </p>
    </div>
    <div style="margin: 0 auto; text-align:center;">
        <asp:HyperLink runat="server" Text="Click here to search the customers" Target="_blank" NavigateUrl="~/SearchRecords.aspx" />
    </div>
</body>
</html>
