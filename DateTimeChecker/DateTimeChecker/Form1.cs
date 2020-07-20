using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DateTimeChecker
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            label1.Font = new Font(Font.FontFamily, 25);
            label2.Font = new Font(Font.FontFamily, 15);
            label3.Font = new Font(Font.FontFamily, 15);
            label4.Font = new Font(Font.FontFamily, 15);
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            txtDay.Text = "";
            txtMonth.Text = "";
            txtYear.Text = "";
        }
        public int getDateInMonth(int month, int year)
        {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            {
                return 13;
            } else if (month == 4 || month == 6 || month == 9 || month == 11)
            {
                return 30;
            } else if (month == 2)
            {
                if (year%4 == 0)
                {
                    return 29;
                }else if (year%100 == 0)
                {
                    return 28;
                }else if (year%4 == 0)
                {
                    return 29;
                } else
                {
                    return 28;
                }
            }
            return 0;
        }
        public bool isValidDate(int day, int month, int year)
        {
            if (month >= 1 && month <= 12)
            {
                if (day >= 1)
                {
                    if (day <= getDateInMonth(month, year))
                    {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        private void btnCheck_Click(object sender, EventArgs e)
        {
            try
            {
                int day = int.Parse(txtDay.Text);
                if (day >= 1 && day <= 31)
                {
                    try
                    {
                        int month = int.Parse(txtMonth.Text);
                        if (month >= 1 && month <= 12)
                        {
                            try
                            {
                                int year = int.Parse(txtYear.Text);
                                if (year >= 1000 && year <= 3000)
                                {
                                    bool result = isValidDate(day, month, year);
                                    if (result)
                                    {
                                        MessageBox.Show(day + "/" + month + "/" + year + " is correct date time");
                                    }
                                    else
                                    {
                                        MessageBox.Show(day + "/" + month + "/" + year + " is NOT correct date time");
                                    }
                                }
                                else
                                {
                                    MessageBox.Show("Input data for Year is out of range");
                                }
                            }
                            catch
                            {
                                MessageBox.Show("Input data for year is incorrect format!");
                            }
                        }
                        else
                        {
                            MessageBox.Show("Input data for Month is out of range");
                        }
                    }
                    catch
                    {
                        MessageBox.Show("Input data for month is incorrect format!");
                    }
                } else
                {
                    MessageBox.Show("Input data for Day is out of range");
                }
            } catch
            {
                MessageBox.Show("Input data for date is incorrect format!");
            }
        }
    }
}
