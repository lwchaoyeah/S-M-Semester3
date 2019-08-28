using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.OleDb;
using System.Data;
using System.Drawing;
namespace Fit5192Asssignment2.ass2.locked
{
    public partial class Activity : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Calendar1.SelectedDate = Calendar1.TodaysDate;
            Calendar1_Init(sender,e);
        }


        protected void GetEventDates()
        {

            string strConnection = dsEvent.ConnectionString;

            using (OleDbConnection objConnection = new OleDbConnection(strConnection))
            {
                objConnection.Open();
                OleDbCommand sqlcmd = new OleDbCommand(@"select EventDate from Events", objConnection);
                OleDbDataReader reader = sqlcmd.ExecuteReader();
                LinkedList<DateTime> selday = new LinkedList<DateTime>();
                while (reader.Read())
                {
                    string time = reader["EventDate"].ToString();
                    DateTime current = Convert.ToDateTime(time);
                    selday.AddFirst(current);
                    Calendar1.SelectedDates.Add(current);
                }
                Session.Add("eventdate", selday);
                reader.Close();
            }
        }

        protected string GetEventDetails(EventArgs e)
        {
            string eventDetails = "";
            string nextDay = Calendar1.SelectedDate.AddDays(1).ToShortDateString();
            string selectedDay = Calendar1.SelectedDate.ToShortDateString();
            dsEvent.SelectCommand =
              "SELECT [EventDate] ,[EventTime],[EventDescription]FROM [Events] WHERE ([EventDate]< #" +
              nextDay + "# and [EventDate]>= #" + selectedDay + "#)";
            DataView dv = (DataView)dsEvent.Select(DataSourceSelectArguments.Empty);
            if (dsEvent.Select(DataSourceSelectArguments.Empty).GetEnumerator().MoveNext())
            {
                string eventDaystr = dv.Table.Rows[0][1].ToString();
                DateTime eventDay = Convert.ToDateTime(eventDaystr);
                eventDaystr = eventDay.ToShortTimeString();
                eventDetails = "At " + eventDaystr + ", " + dv.Table.Rows[0][2].ToString();
                Calendar1.SelectedDayStyle.BackColor = Color.LightGreen;
            }
            else
            {
                eventDetails = "NO event for today!";
                Calendar1.SelectedDayStyle.BackColor = Color.LightSkyBlue;
            }
            return eventDetails;
        }

        protected void Calendar1_SelectionChanged(object sender, EventArgs e)
        {
            displayEvent.Text = GetEventDetails(e);
        }

        protected void Calendar1_DayRender(object sender, DayRenderEventArgs e)
        {
            LinkedList<DateTime> displaydate = (LinkedList<DateTime>)Session["eventdate"];
            try
            {
                for (int i = displaydate.Count; i > 0; i--)
                {
                    Calendar1.SelectedDates.Add(displaydate.First.Value);
                    displaydate.RemoveFirst();
                }
            }
            catch (System.NullReferenceException ex)
            {
                displayEvent.Text = ex.Message;
            }
        }

        protected void Calendar1_Init(object sender, EventArgs e)
        {
            displayEvent.Text = GetEventDetails(e);
        }
    }
}