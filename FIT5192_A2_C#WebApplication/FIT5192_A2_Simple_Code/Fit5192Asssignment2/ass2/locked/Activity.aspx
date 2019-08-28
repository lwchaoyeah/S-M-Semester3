<%@ Page Language="C#" AutoEventWireup="true" StylesheetTheme="SkinDefault" MasterPageFile="~/MasterPage.master" CodeBehind="Activity.aspx.cs" Inherits="Fit5192Asssignment2.ass2.locked.Activity" %>


<asp:Content ID="activityContent" ContentPlaceHolderID="ContentPlaceHolder1" 
      Runat="Server">
    <!--Zeng Jiaxin-->
    <asp:accessdatasource runat="server" 
        ID ="dsEvent" DataFile="~/App_Data/assignment2.accdb"
        />
    
    <div style="margin: 0 auto;">
        <table width ="100%">
            <tr>
                <td width ="36%">

                </td>
                <td>
                    <asp:Calendar ID="Calendar1" DayNameFormat="Full" runat="server"
                        SkinID="Calendar1"
                        OnSelectionChanged="Calendar1_SelectionChanged"
                        Caption="Activity Schedule"
                        CaptionAlign="top" Height="400px" Width="500px" 
                        >
                        <DayHeaderStyle BackColor="#0066FF" Font-Bold="True" ForeColor="Black" />
                    <TitleStyle Font-Bold="True" Font-Size="10pt" BackColor="#3737FF" ForeColor="Black" />
                    </asp:Calendar>
                </td>
                 
            </tr>
        </table>
    </div>
    <div style="margin: 0 auto; text-align:center;">
        </br>
        <asp:Label ID="displayEvent" runat="server"/>
        </br></br></br></br></br></br></br>
        </br>
        
    </div>
</asp:Content>