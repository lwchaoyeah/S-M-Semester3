<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/MasterPage.master" CodeBehind="Documentation.aspx.cs" Inherits="Fit5192Asssignment2.Documentation" %>


<asp:Content ID="documentationContent" ContentPlaceHolderID="ContentPlaceHolder1" 
      Runat="Server">
    <!--Li Wenchao-->
        <div class="tableCSSView" id=document style="overflow:hidden; align-content:center">
            <table border="1" style="align-content:center">
                <tr>
                    <th>Author</th>
                    <td>Wenchao Li</td>
                    <td>Jiaxin Zeng</td>
                </tr>
                <tr>
                    <th>StudentID</th>
                    <td>30074444</td>
                    <td>30074355</td>
                </tr>
                <tr>
                    <th>Student Email</th>
                    <td>wlii0054@student.monash.edu</td>
                    <td>jzen0012@student.monash.edu</td>
                </tr>
                <tr>
                    <th>Unit Name</th>
                    <td colspan="2">FIT5192 Enterprise and internet applications development</td>                    
                </tr>
                <tr>
                    <th>Unit Provider</th>
                    <td colspan="2">Monash University, Faculty of Information Technology </td>                    
                </tr>
                <tr>
                    <th>Assignment Number</th>
                    <td colspan="2">2</td>                    
                </tr>
                <tr>
                    <th>Date of Submission</th>
                    <td colspan="2">27/8/2019</td>                    
                </tr>
                <tr>
                    <th>Lecture's Name</th>
                    <td colspan="2">Murray Mount</td>                    
                </tr>
                <tr>
                    <th>Assignment specification</th>
                    <td colspan="2">
                        <a href="https://lms.monash.edu/pluginfile.php/8918172/mod_resource/content/14/Assignments/FIT5192-A2-2019_Specification.pdf"  target="_blank" style="color:blue">
                            FIT5192-A2-2019_Specification.pdf</a>
                    </td>                    
                </tr>

                <tr>
                    <th>Task Allocation</th>
                    <td >
                        <p>Master Page</p>
                        <p>Home Page</p>
                        <p>About Us Page</p>
                        <p>Our history Page</p>
                        <p>SiteMap Page</p>
                        <p>Documentation Page</p>
                        <p>Email Page</p>
                    </td>
                    <td >
                        <p>Registration Page</p>
                        <p>Display Records Page</p>
                        <p>Search Records Page</p>
                        <p>Single Record Page</p>
                        <p>Activity Page</p>
                        <p>Login Page</p>
                        <p>FAQ Page</p>
                    </td>                    
                </tr>
                    
            </table>
        </div>
        
        <div style="text-align:center;width:300px;margin:0 auto;">
            <table>
                <tr>
                    <td>
                        <asp:HyperLink runat="server" ImageUrl="~/Images/css.jpg"  Target="_blank" NavigateUrl="/DisplayCode.aspx?filename=/StyleSheetsimple.css&filename2=/TableSheet.css" />
                    </td>
                    <td>
                        <asp:HyperLink runat="server" ImageUrl="~/Images/skin.jpg"  Target="_blank" NavigateUrl="/DisplayCode.aspx?filename=/App_Themes/SkinDefault/SkinDefault.skin" />
                    </td>
                </tr>
            </table>            
        </div>

    </asp:Content>
