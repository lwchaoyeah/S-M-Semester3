<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/MasterPage.master" CodeBehind="Registration.aspx.cs" Inherits="Fit5192Asssignment2.Registration" %>
<asp:Content ID="RegistrationContent" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<!--Zeng Jiaxin-->

<script  runat="server">
    protected void checkCheckBox(object source,ServerValidateEventArgs args)
　　{
　　　　args.IsValid = CheckAggrement.Checked;
　　}
</script>

     <asp:accessdatasource runat="server" 
                ID ="dsAccess" DataFile="~/App_Data/assignment2.accdb"
                InsertCommand="INSERT INTO [userInfo] ( [Username], [Password], [FullName],[email],[gender],[phoneNumber],[age],[career],[address]) VALUES ( ?, ?, ?,?, ?, ?, ?,?, ? )"
                />
    <div class ="tableCSSView">
         <asp:FormView ID="RegistionFormView"  
            runat="server" 
            HeaderText="Registion Form"
            HeaderStyle-HorizontalAlign="Center" HeaderStyle-Font-Bold="true"
            DataKeyNames="ID"
            DataSourceID="dsAccess" 
            DefaultMode="Insert" >
            <InsertItemTemplate>
                <table border="0" width="100%">
                        <tr>
                            <td>
                                Login username:
                            </td>
                            <td>
                                <asp:TextBox ID="pusername" runat="server" Text='<%# Bind("Username") %>' />
                                <asp:RequiredFieldValidator  runat="server" ErrorMessage="Please enter a Login username"
                                    ControlToValidate="pusername" Display="Dynamic" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Password:
                            </td>
                            <td>
                                <asp:TextBox ID="pPassword" runat="server" Text='<%# Bind("Password") %>' />
                                <asp:RequiredFieldValidator  runat="server" ErrorMessage="Please enter a Password"
                                    ControlToValidate="pPassword" Display="Dynamic" />
                                <asp:RegularExpressionValidator  runat="server" ControlToValidate="pPassword"
                                    ErrorMessage="Please entre a valid password" ValidationExpression="^[a-zA-Z0-9\W]{8,20}$"
                                    Display="Dynamic" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                 Confirm   Password:
                            </td>
                            <td>
                                <asp:TextBox ID="ConfirmPassword" runat="server"/>
                                <asp:RequiredFieldValidator  runat="server" ErrorMessage="Please enter a Password"
                                    ControlToValidate="ConfirmPassword" Display="Dynamic" />
                                <asp:CompareValidator ID="passwordVal" runat="server"
                                    ControlToValidate="ConfirmPassword"
                                    ControlToCompare="pPassword"
                                    ErrorMessage="Please enter same vale for password" 
                                    EnableClientScript="false"/>

                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                FullName:
                            </td>
                            <td>
                                <asp:TextBox ID="pFullName" runat="server" Text='<%# Bind("FullName") %>' />
                                <asp:RequiredFieldValidator  runat="server" ErrorMessage="Please enter a FullName"
                                    ControlToValidate="pFullName" Display="Dynamic" />
                              
                            </td>
                        </tr>
                        <tr>
                            <td>
                                email:
                            </td>
                            <td>
                                <asp:TextBox ID="pemail" runat="server" Text='<%# Bind("email") %>' />
                                <asp:RequiredFieldValidator  runat="server" ErrorMessage="Please enter a Email address"
                                    ControlToValidate="pemail" Display="Dynamic" />
                                 <%--<asp:RegularExpressionValidator  runat="server" ControlToValidate="pemail"
                                    ErrorMessage="Please entre a valid Email address" ValidationExpression=".*@.*\..*"
                                    Display="Dynamic" />--%>
                                <asp:RegularExpressionValidator  runat="server" ControlToValidate="pemail"
                                    ErrorMessage="Please entre a valid Email address" ValidationExpression="^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$"
                                    Display="Dynamic" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                gender:
                            </td>
                            <td>
                                <asp:RadioButtonList id="pgender" Text='<%# Bind("gender") %>' RepeatDirection="Horizontal" runat="server">
                                    <asp:ListItem selected="true">male</asp:ListItem>
                                    <asp:ListItem >female</asp:ListItem>
                                </asp:RadioButtonList>
                                <asp:RequiredFieldValidator  runat="server" ErrorMessage="Please enter a gender"
                                    ControlToValidate="pgender" Display="Dynamic" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Phone Number:
                            </td>
                            <td>
                                <asp:TextBox ID="pphoneNumber" runat="server" Text='<%# Bind("phoneNumber") %>' />
                                <asp:RequiredFieldValidator runat="server" ErrorMessage="Please enter a phoneNumber"
                                    ControlToValidate="pphoneNumber" Display="Dynamic" />
                                <asp:RegularExpressionValidator  runat="server" ControlToValidate="pphoneNumber"
                                    ErrorMessage="Please Enter Only Numbers" ValidationExpression="\d*" Display="Dynamic" />
                            </td>
                        </tr>
                        <tr>
                            <td>Age:</td>
                            <td>
                                <asp:TextBox ID="age" runat="server" Text='<%# Bind("age") %>' />
                                <asp:RequiredFieldValidator runat="server" ErrorMessage="Please enter a age"
                                    ControlToValidate="age" Display="Dynamic" />
                                <asp:RangeValidator
                                    ControlToValidate="age"
                                    MinimumValue="0"
                                    MaximumValue="100"
                                    Type="Integer"
                                    EnableClientScript="false"
                                    Display="Dynamic"
                                    Text="age should between 0 to 100"
                                    runat="server" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Career:
                            </td>
                            <td>
                                <asp:ListBox id="pCareer" rows="3" Text='<%# Bind("career") %>' runat="server">
                                    <asp:ListItem selected="true">Student</asp:ListItem>
                                    <asp:ListItem>Teacher</asp:ListItem>
                                    <asp:ListItem>Engineer</asp:ListItem>
                                    <asp:ListItem>Others</asp:ListItem>
                                </asp:ListBox>
                                <asp:RequiredFieldValidator  runat="server" ErrorMessage="Please enter a Career"
                                    ControlToValidate="pCareer" Display="Dynamic" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Address:
                            </td>
                            <td>
                                <asp:DropDownList ID="pAddress" runat="server" Text='<%# Bind("address") %>'>
                                    <asp:ListItem Selected="True">China</asp:ListItem>
                                    <asp:ListItem>Australia</asp:ListItem>
                                    <asp:ListItem>Others</asp:ListItem>
                                </asp:DropDownList>
                                <asp:RequiredFieldValidator  runat="server" ErrorMessage="Please enter a Address"
                                    ControlToValidate="pAddress" Display="Dynamic" />
                            </td>
                        </tr>
                    <tr>
                        <td>
                            thumbnail image:
                        </td>
                        <td >
                            <asp:FileUpload ID="fileUpload" runat="server" Width="430" />
                        </td>
                    </tr>
                    
                    </table>
                    <div>
                        <asp:Button ID="btnInsert" runat="server" CausesValidation="True" CommandName="Insert"
                            Text="Add"/>
                        <asp:Button ID="btnCancel" runat="server" CausesValidation="False" CommandName="Cancel"
                            Text="Cancel" />
                    </div>
             </InsertItemTemplate>
        </asp:FormView>
        <p align="center">
            <asp:CheckBox ID="CheckAggrement" Text="I aggree with the aggrement." runat="server"/>   
        </p>
        <asp:CustomValidator OnServerValidate="checkCheckBox" 
                        Text="please check the aggrement" runat="server"/>  
    </div>
    <div style="margin: 0 auto; text-align:center;">
        <asp:HyperLink runat="server" Text="login" NavigateUrl="~/login.aspx" />
    </div>
    
    <div style="margin: 0 auto; text-align:center;">
        <asp:HyperLink runat="server" Text="Click here to see all the volunteers" Target="_blank" NavigateUrl="~/RecordsDisplay.aspx" />
    </div>
    <div>
        <p align="center">
            <asp:HyperLink runat="server" ImageUrl="~/Images/addRecords.jpg"  Target="_blank" NavigateUrl="~/DisplayCode.aspx?filename=Registration.aspx" />
        </p>
    </div>
</asp:Content>