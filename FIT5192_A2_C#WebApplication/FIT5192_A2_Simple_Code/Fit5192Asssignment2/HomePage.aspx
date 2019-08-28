<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeBehind="HomePage.aspx.cs" Inherits="Fit5192Asssignment2.HomePage" %>



<asp:Content ID="mainContent" ContentPlaceHolderID="ContentPlaceHolder1" 
      Runat="Server">
<!--Li Wenchao-->        
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
    <asp:UpdatePanel ID="UpdatePanel1" UpdateMode="Conditional" runat="server">
	    <ContentTemplate>
                <asp:Timer ID="Timer1" runat="server" Interval="5000">
                </asp:Timer>

                <div id=adRotator style="overflow:hidden; align-content:center">
                <p>
                <asp:XmlDataSource ID="Ads" 
                    Runat="server" 
                    DataFile="~/AdRotator.xml">
                    </asp:XmlDataSource>
                <asp:AdRotator ID="AdRotator1" runat="server" DataSourceID="Ads"
                target="_blank"/>

                <%--<asp:XmlDataSource ID="XmlDataSource1" 
                Runat="server" 
                DataFile="~/advertisement1.xml">
                </asp:XmlDataSource>
                <asp:XmlDataSource ID="XmlDataSource2" 
                Runat="server" 
                DataFile="~/advertisement2.xml">
                </asp:XmlDataSource>
                <asp:XmlDataSource ID="XmlDataSource3" 
                Runat="server" 
                DataFile="~/advertisement3.xml">
                </asp:XmlDataSource>

                <asp:AdRotator ID="AdRotator1" runat="server" DataSourceID="XmlDataSource1"
                        target="_blank"/>
                <asp:AdRotator ID="AdRotator2" runat="server" DataSourceID="XmlDataSource2"
                    target="_blank"/>
                <asp:AdRotator ID="AdRotator3" runat="server" DataSourceID="XmlDataSource3"
                    target="_blank"/>--%>
                </p>
            </div>
	    </ContentTemplate>
    </asp:UpdatePanel>
    <br><br>

        <div style="text-align:center;width:390px;margin:0 auto;">
            <table>
                <tr>
                    <td>
                        <asp:HyperLink runat="server" ImageUrl="~/Images/adRotator.jpg"  Target="_blank" NavigateUrl="~/DisplayCode.aspx?filename=/HomePage.aspx&filename2=/AdRotator.xml" />
                    </td>
                    <td>
                        <asp:HyperLink runat="server" ImageUrl="~/Images/masterPage.jpg"  Target="_blank" NavigateUrl="~/DisplayCode.aspx?filename=/MasterPage.master" />
                    </td>
                </tr>
            </table>            
        </div>

    </asp:Content>