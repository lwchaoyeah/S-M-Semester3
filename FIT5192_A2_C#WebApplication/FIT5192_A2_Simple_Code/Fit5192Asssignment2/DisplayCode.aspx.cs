using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;

namespace Fit5192Asssignment2
{
    public partial class DisplayCode : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string filePath =
                Server.MapPath(Request.QueryString["filename"]);
            FileName.Text = Request.QueryString["filename"];
            String filePath2 = "";
            String filePath3 = "";
            if (Request.QueryString["filename2"] != null)
                filePath2 = Server.MapPath(Request.QueryString["filename2"]);
            if (Request.QueryString["filename3"] != null)
                filePath3 = Server.MapPath(Request.QueryString["filename3"]);

            FileInfo file = new FileInfo(filePath);
            FileInfo file2 = null;
            FileInfo file3 = null;

            if (file.Extension == ".aspx"
              || file.Extension == ".xml"
              || file.Extension == ".sitemap"
              || file.Extension == ".skin"
              || file.Extension == ".css"
              || file.Extension == ".config"
              || file.Extension == ".master")
            {
                Code.Text = ReadFile(filePath);
            }
            else
            {
                Code.Text = "Sorry you can't read a file with an extension of " + file.Extension;
            }

            // file2
            if (filePath2!="")
            {
                file2 = new FileInfo(filePath2);

                if (file2.Extension == ".aspx"
                || file2.Extension == ".xml"
                || file2.Extension == ".sitemap"
                || file2.Extension == ".skin"
                || file2.Extension == ".css"
                || file2.Extension == ".config"
                || file2.Extension == ".master")
                {
                    FileName2.Text = Request.QueryString["filename2"];
                    pnlCode2.Visible=true;
                    Code2.Text = ReadFile(filePath2);
                }
                else
                {
                    Code2.Text = "Sorry you can't read a file with an extension of " + file2.Extension;
                }
            }

            // file3
            if (filePath3!="")
            {           
                file3 = new FileInfo(filePath3);
                if (file3.Extension == ".aspx"
                || file3.Extension == ".xml"
                || file3.Extension == ".sitemap"
                || file3.Extension == ".skin"
                || file3.Extension == ".css"
                || file3.Extension == ".config"
                || file3.Extension == ".master")
                {
                    FileName3.Text = Request.QueryString["filename3"];
                    pnlCode3.Visible = true;
                    Code3.Text = ReadFile(filePath3);
                }
                else
                {
                    Code3.Text = "Sorry you can't read a file with an extension of " + file3.Extension;
                }
                
            }

        }


        private string ReadFile(string filepath)
        {
            string fileOutput = "";
            try
            {
                StreamReader FileReader = new StreamReader(filepath);
                //The returned value is -1 if no more characters are 
                //currently available.
                while (FileReader.Peek() > -1)
                {
                    //ReadLine() Reads a line of characters from the 
                    //current stream and returns the data as a string.
                    fileOutput += FileReader.ReadLine().Replace("<", "&lt;").
                    Replace("  ", "&nbsp;&nbsp;&nbsp;&nbsp;")
                                          + "<br />";
                }
                FileReader.Close();
            }
            catch (FileNotFoundException e)
            {
                fileOutput = e.Message;
            }
            return fileOutput;
        }
    }
}