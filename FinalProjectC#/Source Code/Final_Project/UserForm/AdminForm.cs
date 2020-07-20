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
    public partial class FrmAdmin : Form
    {
        public FrmAdmin()
        {
            InitializeComponent();
        }

        public FrmAdmin(string fullName)
        {
            InitializeComponent();
            this.welcomeAdmin = fullName;

        }

        private string welcomeAdmin;
        private bool isUpdate = false;
        private bool isNew = false;

        public void PreventEditData()
        {
            if (isNew == false && isUpdate == false)
            {
                TxtBookID.Enabled = false;
                TxtBookName.Enabled = false;
                TxtBookPrice.Enabled = false;
                TxtBookStatus.Enabled = false;
                TxtBookQuantity.Enabled = false;
                TxtAuthorName.Enabled = false;
            }
        }

        public void AllowToEditData()
        {
            if (isUpdate == true && isNew == false)
            {
                TxtBookName.Enabled = true;
                TxtBookPrice.Enabled = true;
                TxtBookStatus.Enabled = true;
                TxtBookQuantity.Enabled = true;
                TxtAuthorName.Enabled = true;
            }
            else if (isUpdate == false && isNew == true)
            {
                TxtBookID.Enabled = true;
                TxtBookName.Enabled = true;
                TxtBookPrice.Enabled = true;
                TxtBookStatus.Enabled = true;
                TxtBookQuantity.Enabled = true;
                TxtAuthorName.Enabled = true;
            }
        }

        private void LoadData()
        {
            ClearData();

            DataProvider dataProvider = new DataProvider();
            dataProvider.GetAllBook();
            List<Book> bookList = dataProvider.GetBookList;
            DgvShowBook.DataSource = bookList;

            TxtBookID.DataBindings.Add("Text", bookList, "ID");
            TxtBookName.DataBindings.Add("Text", bookList, "Name");
            TxtBookStatus.DataBindings.Add("Text", bookList, "Status");
            TxtBookPrice.DataBindings.Add("Text", bookList, "Price");
            TxtBookQuantity.DataBindings.Add("Text", bookList, "Quantity");
            TxtAuthorName.DataBindings.Add("Text", bookList, "Author");
        }

        private bool CheckValidData(string id, string name, bool status, double price, int quantity, string authorName)
        {
            if (!id.Equals(""))
            {
                if (!name.Equals(""))
                {
                    if (!status.Equals(""))
                    {
                        if (price > 0)
                        {
                            if (quantity > 0)
                            {
                                if (!authorName.Equals(""))
                                {
                                    return true;
                                }

                            }
                        }
                    }
                }
            }
            return false;
        }

        private void ClearData()
        {
            if (isNew == false && isUpdate == false)
            {
                TxtBookID.DataBindings.Clear();
                TxtBookName.DataBindings.Clear();
                TxtBookStatus.DataBindings.Clear();
                TxtBookPrice.DataBindings.Clear();
                TxtBookQuantity.DataBindings.Clear();
                TxtAuthorName.DataBindings.Clear();

                TxtBookID.Clear();
                TxtBookName.Clear();
                TxtBookStatus.Clear();
                TxtBookPrice.Clear();
                TxtBookQuantity.Clear();
                TxtAuthorName.Clear();
            }
            //else if (isUpdate == true && isNew == false)
            else if (isUpdate == true)
            {
                TxtBookName.DataBindings.Clear();
                TxtBookStatus.DataBindings.Clear();
                TxtBookPrice.DataBindings.Clear();
                TxtBookQuantity.DataBindings.Clear();
                TxtAuthorName.DataBindings.Clear();

                TxtBookName.Clear();
                TxtBookStatus.Clear();
                TxtBookPrice.Clear();
                TxtBookQuantity.Clear();
                TxtAuthorName.Clear();
            }
            //else if (isUpdate == false && isNew == true)
            else if (isNew == true)
            {
                TxtBookID.DataBindings.Clear();
                TxtBookName.DataBindings.Clear();
                TxtBookStatus.DataBindings.Clear();
                TxtBookPrice.DataBindings.Clear();
                TxtBookQuantity.DataBindings.Clear();
                TxtAuthorName.DataBindings.Clear();

                TxtBookID.Clear();
                TxtBookName.Clear();
                TxtBookStatus.Clear();
                TxtBookPrice.Clear();
                TxtBookQuantity.Clear();
                TxtAuthorName.Clear();
            }
        }


        private void FrmAdmin_Load(object sender, EventArgs e)
        {
            lblWelcomeAdmin.Text = "Welcome, " + this.welcomeAdmin;
            this.PreventEditData();
            LoadData();
        }

        private void BtnNew_Click(object sender, EventArgs e)
        {
            try
            {
                if (isNew == false)
                {
                    isNew = true;
                    isUpdate = false;
                    this.AllowToEditData();
                    this.ClearData();
                }
                else if (isNew == true)
                {
                    string id = TxtBookID.Text.Trim();
                    string name = TxtBookName.Text.Trim();
                    bool status = bool.Parse(TxtBookStatus.Text.Trim());
                    double price = double.Parse(TxtBookPrice.Text.Trim());
                    int quantity = int.Parse(TxtBookQuantity.Text.Trim());
                    string author = TxtAuthorName.Text.Trim();
                    bool valid = this.CheckValidData(id, name, status, price, quantity, author);
                    if (valid == true)
                    {
                        Book newBook = new Book(id, name, status, price, quantity, author);
                        DataProvider dataProvider = new DataProvider();
                        bool result = dataProvider.AddNewBook(newBook);
                        if (result == true)
                        {
                            MessageBox.Show("Successfully.");
                            isNew = false;
                            this.PreventEditData();
                            this.LoadData();
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
            }
            catch (FormatException ex)
            {

                MessageBox.Show(ex.Message);
            }
            catch (SqlException ex)
            {
                if (ex.Message.Contains("PRIMARY KEY") == true)
                {
                    MessageBox.Show("This book is existed.");
                }
                else
                {
                    MessageBox.Show(ex.Message);
                }

            }
        }


        private void BtnLogout_Click(object sender, EventArgs e)
        {
            this.Hide();
            LoginForm login = new LoginForm();
            login.ShowDialog();
            this.Close();
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {

            try
            {
                if (isUpdate == false)
                {
                    isUpdate = true;
                    isNew = false;
                    this.ClearData();
                    this.AllowToEditData();
                }
                else if (isUpdate == true)
                {
                    string id = TxtBookID.Text.Trim();
                    string name = TxtBookName.Text.Trim();
                    bool status = bool.Parse(TxtBookStatus.Text.Trim());
                    double price = double.Parse(TxtBookPrice.Text.Trim());
                    int quantity = int.Parse(TxtBookQuantity.Text.Trim());
                    string author = TxtAuthorName.Text.Trim();
                    bool valid = this.CheckValidData(id, name, status, price, quantity, author);
                    if (valid == true)
                    {
                        Book book = new Book(id, name, status, price, quantity, author);
                        DataProvider dataProvider = new DataProvider();
                        bool result = dataProvider.UpdateBook(book);
                        if (result == true)
                        {
                            MessageBox.Show("Successfully");
                            isUpdate = false;
                            this.PreventEditData();
                            this.LoadData();

                        }
                        else
                        {
                            MessageBox.Show("Failed");
                        }
                    }
                    else
                    {
                        MessageBox.Show("Invalid");
                    }
                }
            }
            catch (SqlException ex)
            {
                MessageBox.Show(ex.Message);
            }
            catch (FormatException ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            try
            {
                string id = TxtBookID.Text.Trim();
                DataProvider dataProvider = new DataProvider();
                bool result = dataProvider.DeleteBook(id);
                if (result == true)
                {
                    MessageBox.Show("Successfully.");
                    this.LoadData();
                }
                else
                {
                    MessageBox.Show("Failed.");
                }
            }
            catch (SqlException ex)
            {
                MessageBox.Show(ex.Message);
            }
            catch (FormatException ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void TxtSearchValue_TextChanged(object sender, EventArgs e)
        {
            string searchValue = TxtSearchValue.Text.Trim();
            try
            {
                isUpdate = false;
                isNew = false;
                this.PreventEditData();
                this.LoadData();
                if (!searchValue.Equals(""))
                {
                    DataProvider dataProvider = new DataProvider();
                    dataProvider.SearchBookByName(searchValue);
                    //this.ClearData();
                    //this.PreventEditData();
                    this.ClearData();
                    List<Book> list = dataProvider.GetBookList;
                    if (list != null)
                    {
                        DgvShowBook.DataSource = list;
                        TxtBookID.DataBindings.Add("Text", list, "ID");
                        TxtBookName.DataBindings.Add("Text", list, "Name");
                        TxtBookStatus.DataBindings.Add("Text", list, "Status");
                        TxtBookPrice.DataBindings.Add("Text", list, "Price");
                        TxtBookQuantity.DataBindings.Add("Text", list, "Quantity");
                        TxtAuthorName.DataBindings.Add("Text", list, "Author");

                    }
                    else
                    {
                        MessageBox.Show("Not Found.");
                    }
                }
                else
                {

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

        private void BtnRefresh_Click(object sender, EventArgs e)
        {
            isUpdate = false;
            isNew = false;
            this.PreventEditData();
            this.LoadData();
        }
    }
}
