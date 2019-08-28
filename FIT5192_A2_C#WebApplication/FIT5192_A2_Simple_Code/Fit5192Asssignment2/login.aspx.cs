using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Security;

namespace Fit5192Asssignment2
{
    public partial class login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Login_Authenticate(object sender, AuthenticateEventArgs e)
        {
            dsAccess.SelectCommand = "SELECT * FROM userInfo WHERE Username = '" + Login1.UserName +
             "' AND Password = '" + Login1.Password + "'";
            if (dsAccess.Select(DataSourceSelectArguments.Empty).GetEnumerator().MoveNext())
            {
                System.Web.Security.FormsAuthentication.RedirectFromLoginPage(Login1.UserName, false);
            }
            else
            {
                Login1.FailureText = "Invalid Login";
            }
        }
        protected void CheckLogin(object sender, SqlDataSourceStatusEventArgs e)
        {
            if (e.AffectedRows > 0)
            {
                FormsAuthentication.RedirectFromLoginPage(Login1.UserName, false);
            }
            else
            {
                Login1.FailureText = "Invalid Login";
            }
        }
    }
}