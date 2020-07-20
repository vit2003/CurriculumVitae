using System.Collections.Generic;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;
using System;

namespace BussinessObject
{
    public class DataProvider
    {
        public string GetConnectionString()
        {
            string connectionStr = ConfigurationManager.ConnectionStrings["LibraryManament"].ConnectionString;
            return connectionStr;
        }

        //Create a list which contains all data about Book
        private List<Book> bookList;

        //Create a property to get data from List
        public List<Book> GetBookList
        {
            get
            {
                return bookList;
            }
        }

        //Get All Book from DataBase
        public void GetAllBook()
        {
            SqlConnection con = new SqlConnection(GetConnectionString());
            try
            {
                if (con != null)
                {
                    string select = "select BookID, Name, Status, Price, Quantity, Author " +
                        "from tbl_Book";
                    SqlCommand cmd = new SqlCommand(select, con);
                    if (con.State == ConnectionState.Closed)
                    {
                        con.Open();
                    }
                    SqlDataReader dataReader = cmd.ExecuteReader();
                    if (dataReader.HasRows == true)
                    {
                        while (dataReader.Read() == true)
                        {
                            string id = dataReader.GetString(0).Trim();
                            string name = dataReader.GetString(1).Trim();
                            bool status = dataReader.GetBoolean(2);
                            double price = double.Parse(dataReader.GetDecimal(3).ToString());
                            int quantity = dataReader.GetInt32(4);
                            string authorName = dataReader.GetString(5).Trim();
                            Book book = new Book(id, name, status, price, quantity, authorName);
                            if (this.bookList == null)
                            {
                                this.bookList = new List<Book>();
                            }
                            this.bookList.Add(book);
                        }
                    }
                }
            }
            catch (SqlException ex)
            {
                /*throw new Exception(ex.Message);*/
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        //Create a list which contains all data about Book
        private List<Account> accountList;

        //Create a property to get data from List
        public List<Account> GetAccountList
        {
            get
            {
                return this.accountList;
            }
        }

        //Add new a book
        public bool AddNewBook(Book newBook)
        {
            SqlConnection con = new SqlConnection(GetConnectionString());
            try
            {
                if (con != null)
                {
                    //Create query string
                    string insert = "insert tbl_Book " +
                        "values (@ID, @bookName, @bookStatus, @bookPrice, @Quantity, @Author)";

                    SqlCommand cmd = new SqlCommand(insert, con);
                    cmd.Parameters.AddWithValue("@ID", newBook.ID);
                    cmd.Parameters.AddWithValue("@bookName", newBook.Name);
                    cmd.Parameters.AddWithValue("@bookStatus", newBook.Status);
                    cmd.Parameters.AddWithValue("@bookPrice", newBook.Price);
                    cmd.Parameters.AddWithValue("@Quantity", newBook.Quantity);
                    cmd.Parameters.AddWithValue("@Author", newBook.Author);
                    if (con.State == ConnectionState.Closed)
                    {
                        con.Open();
                    }//end if con is closed

                    int row = cmd.ExecuteNonQuery();
                    if (row > 0)
                    {
                        return true;
                    }//end if insert successful
                }
            }
            catch (SqlException ex)
            {
                /*throw new Exception(ex.Message);*/
                throw ex;
            }
            finally
            {
                con.Close();
            }
            return false;
        }

        //Update information of a book 
        public bool UpdateBook(Book book)
        {
            SqlConnection con = new SqlConnection(GetConnectionString());
            try
            {
                if (con != null)
                {
                    //create query string
                    string update = "update tbl_Book " +
                        "set Name = @Name, Status = @Status, Price = @Price, Quantity = @Quantity, Author = @Author " +
                        "where BookID = @ID";
                    SqlCommand cmd = new SqlCommand(update, con);
                    cmd.Parameters.AddWithValue("@ID", book.ID);
                    cmd.Parameters.AddWithValue("@Name", book.Name);
                    cmd.Parameters.AddWithValue("@Status", book.Status);
                    cmd.Parameters.AddWithValue("@Price", book.Price);
                    cmd.Parameters.AddWithValue("@Quantity", book.Quantity);
                    cmd.Parameters.AddWithValue("@Author", book.Author);
                    if (con.State == ConnectionState.Closed)
                    {
                        con.Open();
                    }
                    int row = cmd.ExecuteNonQuery();
                    if (row > 0)
                    {
                        return true;
                    }//end if update successful.
                }//end if con is existed.
            }
            catch (SqlException ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
            return false;
        }

        //Delete a book by Book ID
        public bool DeleteBook(string bookID)
        {
            SqlConnection con = new SqlConnection(GetConnectionString());
            try
            {
                if (con != null)
                {
                    //create delete string
                    string delete = "delete tbl_Book " +
                        "where BookID = @ID";
                    SqlCommand cmd = new SqlCommand(delete, con);
                    cmd.Parameters.AddWithValue("@ID", bookID);
                    if (con.State == ConnectionState.Closed)
                    {
                        con.Open();
                    }//end if con is closed.
                    int row = cmd.ExecuteNonQuery();
                    if (row > 0)
                    {
                        return true;
                    }//end if delete successful
                }//end if con is existed.

            }
            catch (SqlException ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
            return false;
        }

        //Search Books by Book Name
        public void SearchBookByName(string bookName)
        {
            SqlConnection con = new SqlConnection(GetConnectionString());
            try
            {
                if (con != null)
                {
                    string search = "select BookID, Name, Status, Price, Quantity, Author " +
                        "from tbl_Book " +
                        "where Name like @Name";
                    SqlCommand cmd = new SqlCommand(search, con);
                    cmd.Parameters.AddWithValue("@Name", "%" + bookName + "%");
                    if (con.State == ConnectionState.Closed)
                    {
                        con.Open();
                    }//end if con is closed.
                    SqlDataReader dataReader = cmd.ExecuteReader();
                    if (dataReader.HasRows == true)
                    {
                        while (dataReader.Read() == true)
                        {
                            string id = dataReader.GetString(0);
                            string name = dataReader.GetString(1);
                            bool status = dataReader.GetBoolean(2);
                            double price = double.Parse(dataReader.GetDecimal(3).ToString());
                            int quantity = dataReader.GetInt32(4);
                            string authorName = dataReader.GetString(5).Trim();
                            Book book = new Book(id, name, status, price, quantity, authorName);
                            if (this.bookList == null)
                            {
                                this.bookList = new List<Book>();
                            }
                            this.bookList.Add(book);
                        }
                    }
                }//end if con is existed.
            }
            catch (SqlException ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        public bool CheckLogin(string username, string password)
        {
            SqlConnection con = new SqlConnection(GetConnectionString());
            try
            {
                if (con != null)
                {
                    string select = "select Username, Password, Fullname, Role " +
                        "from tbl_Account " +
                        "where Username = @ID and Password = @Pass";
                    SqlCommand cmd = new SqlCommand(select, con);
                    cmd.Parameters.AddWithValue("@ID", username);
                    cmd.Parameters.AddWithValue("@Pass", password);
                    if (con.State == ConnectionState.Closed)
                    {
                        con.Open();
                    }
                    SqlDataReader dataReader = cmd.ExecuteReader();
                    if (dataReader.HasRows == true)
                    {

                        if (dataReader.Read() == true)
                        {
                            string accountID = dataReader.GetString(0).Trim();
                            string accountPassword = dataReader.GetString(1).Trim();
                            string accountFullName = dataReader.GetString(2).Trim();
                            bool accountRole = dataReader.GetBoolean(3);

                            Account account = new Account(accountID, accountPassword, accountFullName, accountRole);
                            this.accountList = new List<Account>();
                            this.accountList.Add(account);
                        }
                        return true;
                    }

                }
            }
            catch (SqlException ex)
            {
                /*throw new Exception(ex.Message);*/
                throw ex;
            }
            finally
            {
                con.Close();
            }
            return false;
        }
    }
}
