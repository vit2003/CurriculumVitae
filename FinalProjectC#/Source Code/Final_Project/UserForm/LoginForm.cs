using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using BussinessObject;
using System.Data.SqlClient;

namespace UserForm
{
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }

        private void BtnReset_Click(object sender, EventArgs e)
        {
            TxtUsername.Clear();
            TxtPassword.Clear();
        }

        private bool CheckValidData(string username, string password)
        {
            if (!username.Equals(""))
            {
                if (!password.Equals(""))
                {
                    return true;
                }
            }
            return false;
        }


        private void BtnLogIn_Click(object sender, EventArgs e)
        {
            
            try
            {
                string username = TxtUsername.Text.Trim();
                string password = TxtPassword.Text.Trim();

                bool valid = this.CheckValidData(username, password);
                if (valid == true)
                {
                    DataProvider dataProvider = new DataProvider();
                    bool result = dataProvider.CheckLogin(username, password);
                    if (result == true)
                    {
                        List<Account> accountList = dataProvider.GetAccountList;
                        if (accountList != null)
                        {
                            foreach (Account account in accountList)
                            {
                                if (account.AccoutnRole == true)
                                {
                                    this.Hide();
                                    FrmAdmin adminForm = new FrmAdmin(account.AccountFullName);
                                    adminForm.ShowDialog();
                                    this.Close();
                                }
                                else
                                {
                                    this.Hide();
                                    UserForm userForm = new UserForm(account.AccountFullName, account.AccountUserName);
                                    userForm.ShowDialog();
                                    this.Close();
                                }
                            }

                        }
                    }
                    else
                    {
                        MessageBox.Show("Failed.");
                    }
                }
                else
                {
                    MessageBox.Show("Invalid");
                }

            }
            catch (FormatException ex)
            {
                MessageBox.Show(ex.Message);
            }
            catch (SqlException ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void LoginForm_FormClosing(object sender, FormClosingEventArgs e)
        {
        }
    }
}
