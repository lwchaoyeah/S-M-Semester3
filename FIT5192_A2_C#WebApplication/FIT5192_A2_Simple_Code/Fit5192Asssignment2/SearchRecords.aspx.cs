using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fit5192Asssignment2
{
    public partial class SearchRecords : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void findCustomer(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            switch (btn.CommandName)
            {
                case "Email":
                    dsAccess.SelectCommand = "SELECT * FROM userInfo WHERE email LIKE '%" +
                    textEmail.Text.Trim(' ') + "%'";
                    break;
                case "FullName":
                    dsAccess.SelectCommand = "SELECT * FROM userInfo WHERE FullName LIKE '%" +
                    txtFullName.Text.Trim(' ') + "%'";
                    break;
            }
            userInfoView.DataSource = dsAccess;
            userInfoView.DataBind();
        }
    }
}