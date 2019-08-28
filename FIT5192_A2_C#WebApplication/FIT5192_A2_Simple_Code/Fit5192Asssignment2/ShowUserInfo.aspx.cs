using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fit5192Asssignment2
{
    public partial class ShowUserInfo : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            dsAccess.SelectCommand = "SELECT * FROM [userInfo] WHERE ID = "
        + Request.QueryString["ID"];
            userInfoView.DataSource = dsAccess;
            userInfoView.DataBind();
        }
    }
}