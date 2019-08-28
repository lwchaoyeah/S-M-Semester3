<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/MasterPage.master" CodeBehind="SiteMap.aspx.cs" Inherits="Fit5192Asssignment2.SiteMap" %>


<asp:Content ID="mainContent" ContentPlaceHolderID="ContentPlaceHolder1" 
      Runat="Server">
<!--Li Wenchao-->
        <div id=treeView style="overflow:hidden; width:250px;margin:0 auto;">
            <p>
                <asp:SiteMapDataSource ID="SiteMapDataSource1" runat="server" />

                <asp:TreeView ID="TreeView" runat="server" 
                    DataSourceID="SiteMapDataSource1" ShowLines="True" />

            </p>
        </div>
        
        <br><br><br><br>
        <br><br><br><br>
        <br><br><br>

        <div style="text-align:center;height:92px; width:400px;margin:0 auto;">
            <p align="center">
                <asp:HyperLink runat="server" ImageUrl="~/Images/siteMap.jpg"  Target="_blank" NavigateUrl="~/DisplayCode.aspx?filename=/ass2/locked/SiteMap.aspx&filename2=/Web.sitemap" />
            </p>
        </div>
</asp:Content>
