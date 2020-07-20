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
using System.Collections;

namespace UserForm
{
    public partial class UserForm : Form
    {
        DataTable dtAvailable = new DataTable();
        List<tempBook> listBorrowBook = new List<tempBook>();
        List<tempBook> selectedBook = null;
        string username = "vinhlp", fullname;
        public UserForm(string fullname, string username)
        {
            this.username = username;
            this.fullname = fullname;
            InitializeComponent();
        }
        public UserForm()
        {
            InitializeComponent();
        }
        private void UserForm_Load(object sender, EventArgs e)
        {
            loadData();
        }
        public void loadData()
        {
            lbUser.Text=this.fullname;
            BookForUserData dao = new BookForUserData();
            dtAvailable = dao.GetAllBook();
            dvgAvailableBook.DataSource = null;
            dvgAvailableBook.DataSource = dtAvailable;
            listBorrowBook = dao.GetBorrowBook(this.username);
            dvgBorrowing.DataSource = null;
            dvgBorrowing.DataSource = listBorrowBook;
            txtId.DataBindings.Clear();
            txtName.DataBindings.Clear();
            txtPrice.DataBindings.Clear();
            txtId.DataBindings.Add("Text", dtAvailable, "BookID");
            txtName.DataBindings.Add("Text", dtAvailable, "name");
            txtPrice.DataBindings.Add("Text", dtAvailable, "price");
        }

        private void btnSelect_Click(object sender, EventArgs e)
        {
            string bookId = txtId.Text;
            string bookName = txtName.Text;
            float price = float.Parse(txtPrice.Text);
            tempBook temp = new tempBook
            {
                bookID = bookId,
                bookName = bookName,
                price = price
            };
            if (selectedBook == null)
            {
                selectedBook = new List<tempBook>();
            }
            if (selectedBook.Exists(x=>x.bookID==bookId))
            {
                return;
            } else
            {
                if (listBorrowBook.Exists(x => x.bookID == bookId))
                {
                    MessageBox.Show("You have already borrow this book\n Please return it before selected again!");
                    return;
                }
                selectedBook.Add(temp);
                dvgSelected.DataSource = null;
                dvgSelected.DataSource = selectedBook;
            }
        }

        private void btnViewAllBook_Click(object sender, EventArgs e)
        {
            loadData();
        }

        private void btnUnselected_Click(object sender, EventArgs e)
        {
            string id = dvgSelected.CurrentRow.Cells[0].Value.ToString();
            tempBook removeBook = selectedBook.Single(b => b.bookID == id);
            selectedBook.Remove(removeBook);
            dvgSelected.DataSource = null;
            dvgSelected.DataSource = selectedBook;
        }

        private void btnUnselectedAll_Click(object sender, EventArgs e)
        {
            selectedBook = new List<tempBook>();
            dvgSelected.DataSource = selectedBook;
        }

        public List<tempBook> getTempBook { get { return this.selectedBook; } }

        private void btnBorrow_Click(object sender, EventArgs e)
        {
            List<tempBook> list = this.getTempBook;
            BookForUserData dao = new BookForUserData();
            foreach (tempBook item in list)
            {
                bool result = dao.isBorrowBook(item.bookID, this.username);
            }
            listBorrowBook = dao.GetBorrowBook(this.username);
            dvgBorrowing.DataSource = null;
            dvgBorrowing.DataSource = listBorrowBook;
            selectedBook = new List<tempBook>();
            dvgSelected.DataSource = null;
            dvgSelected.DataSource = selectedBook;
            dvgAvailableBook.DataSource = null;
            dvgAvailableBook.DataSource = dtAvailable;
        }
        private void btnSearchLikeName_Click(object sender, EventArgs e)
        {
            BookForUserData dao = new BookForUserData();
            if (txtSearchLikeName == null)
            {
                return;
            }
            else
            {
                dtAvailable = dao.searchByLikeName(txtSearchLikeName.Text);
                dvgAvailableBook.DataSource = null;
                dvgAvailableBook.DataSource = dtAvailable;
            }
        }

        private void btnSearchAuthor_Click(object sender, EventArgs e)
        {
            if (txtSearchAuthor == null)
            {
                return;
            }
            else
            {
                BookForUserData dao = new BookForUserData();
                dtAvailable = dao.searchByAuthor(txtSearchAuthor.Text);
                dvgAvailableBook.DataSource = null;
                dvgAvailableBook.DataSource = dtAvailable;
            }
        }

        private void btnReturnAll_Click(object sender, EventArgs e)
        {
            bool result = false;
            BookForUserData dao = new BookForUserData();
            foreach(tempBook book in listBorrowBook)
            {
                result = dao.returnBook(this.username, book.bookID);
            }
            if (result)
            {
                MessageBox.Show("Return All Success!");
                dvgAvailableBook.DataSource = null;
                dvgAvailableBook.DataSource = dtAvailable;
                listBorrowBook = dao.GetBorrowBook(this.username);
                dvgBorrowing.DataSource = null;
                dvgBorrowing.DataSource = listBorrowBook;
            }
            else
            {
                MessageBox.Show("Fail!");
            }
        }

        private void btnLogout_Click(object sender, EventArgs e)
        {
            this.Hide();
            LoginForm loginForm = new LoginForm();
            loginForm.ShowDialog();
            this.Close();
        }

        private void UserForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Close();
        }

        private void btnReturn_Click(object sender, EventArgs e)
        {
            string bookId = dvgBorrowing.CurrentRow.Cells[0].Value.ToString();
            BookForUserData dao = new BookForUserData();
            bool result = dao.returnBook(this.username, bookId);
            if (result)
            {
                MessageBox.Show("Return Succesful!");
                dtAvailable = dao.GetAllBook();
                dvgAvailableBook.DataSource = null;
                dvgAvailableBook.DataSource = dtAvailable;
                listBorrowBook = dao.GetBorrowBook(this.username);
                dvgBorrowing.DataSource = null;
                dvgBorrowing.DataSource = listBorrowBook;
            } else
            {
                MessageBox.Show("Fail!");
            }
        }

    }
}
