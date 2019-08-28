using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fit5192Asssignment2
{
    public partial class RecordsDisplay : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void DisplayData(object sender, GridViewCommandEventArgs e)
        {
            try
            {
                lblDisplayUserInfo.Text = "<table><tr>" +
                " <td>Selected ID:</td>"+
                "<td> " +
                    gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[1].Text +
                "</td>" +
                "</tr>"+
                //"<tr>" +
                //    "<td>login UserName:</td>" +
                //    "<td>" +
                        //gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[2].Text +
                //    "</td>" +
                //"</tr>" +
                "<tr>" +
                    "<td>Full Name:</td>" +
                    "<td>" +
                        gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[3].Text +
                    "</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>Email:</td>" +
                    "<td>" +
                        gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[4].Text +
                    "</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>Gender:</td>" +
                    "<td>" +
                        gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[5].Text +
                    "</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>Phone Number:</td>" +
                    "<td>" +
                        gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[6].Text +
                    "</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>Career:</td>" +
                    "<td>" +
                        gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[7].Text +
                    "</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>Address:</td>" +
                    "<td>" +
                        gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[8].Text +
                    "</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>Age:</td>" +
                    "<td>" +
                        gvUserInfo.Rows[Convert.ToInt32(e.CommandArgument)].Cells[9].Text +
                    "</td>" +
                "</tr>" +
                "</table>";
            }
            catch { lblDisplayUserInfo.Text = ""; }
        }
    }
}