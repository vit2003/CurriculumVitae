using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using System.Data.SqlClient;
using System.Data;

namespace BussinessObject
{
    public class BookForUserData
    {
        string connectionString = ConfigurationManager.ConnectionStrings["LibraryManament"].ConnectionString;
        public DataTable GetAllBook()
        {
            DataTable result = new DataTable();
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Select * from tbl_Book where status = @status";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@status", true);
            SqlDataAdapter dtBook = new SqlDataAdapter(cmd);
            try
            {
                if (con.State != ConnectionState.Open)
                {
                    con.Open();
                }
                dtBook.Fill(result);
            }
            catch (SqlException ex)
            {
                throw new Exception(ex.Message);
            }
            return result;
        }
        public List<tempBook> GetBorrowBook(string username)
        {
            List<tempBook> result = new List<tempBook>();
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Select BookID From tbl_Borrow Where Username = @name";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@name", username);
            //if (con.State != ConnectionState.Open)
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }
            SqlDataReader reader = cmd.ExecuteReader();
            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    String book = reader.GetString(0).Trim();
                    result = getBookFollowName(book, result);
                }
            }
            return result;
        }
        private List<tempBook> getBookFollowName(String bookname, List<tempBook> alist)
        {
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Select * From tbl_Book where BookID=@ID";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@ID", bookname);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }
            SqlDataReader reader = cmd.ExecuteReader();
            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    tempBook book = new tempBook
                    {
                        bookID = reader.GetString(0).Trim(),
                        bookName = reader.GetString(1).Trim(),
                        price = (float)reader.GetDecimal(3)
                    };
                    alist.Add(book);
                }
            }
            return alist;
        }
        private int getQuanOfBook(String bookid)
        {
            int result = -1;
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Select Quantity From tbl_Book Where BookID=@id";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@id", bookid);
            try
            {
                if (con.State == ConnectionState.Closed)
                {
                    con.Open();
                }
                SqlDataReader dataReader = cmd.ExecuteReader();
                if (dataReader.HasRows)
                {
                    if (dataReader.Read())
                    {
                        result = dataReader.GetInt32(0);
                    }
                }
            }
            finally
            {
                con.Close();
            }
            return result;
        }
        private bool updateBorrowTable(string bookid, string username)
        {
            bool result = false;
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Insert Into tbl_Borrow (Username,BookID) values (@username,@book)";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@username", username);
            cmd.Parameters.AddWithValue("@book", bookid);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }
            int row = cmd.ExecuteNonQuery();
            if (row > 0)
            {
                result = true;
            }
            return result;
        }

        private bool updateStatusBook(String id, bool isResult)
        {
            bool result = false;
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Update tbl_Book Set Status = @newStatus Where BookID=@ID";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@ID", id);
            cmd.Parameters.AddWithValue("@newStatus", isResult);

            try
            {
                if (con.State == ConnectionState.Closed)

                {
                    con.Open();
                }
                int row = cmd.ExecuteNonQuery();
                if (row > 0)
                {
                    result = true;
                }
            }
            finally
            {
                con.Close();
            }
            return result;
        }

        private bool updateBookInfo(string bookid, int quan)
        {
            bool result = false;
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Update tbl_Book Set Quantity=@quan Where BookID=@id";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@quan", quan);
            cmd.Parameters.AddWithValue("@id", bookid);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }
            int row = cmd.ExecuteNonQuery();
            if (row > 0)
            {
                result = true;
                if (quan == 0)
                {
                    updateStatusBook(bookid, false);
                }
            }
            return result;
        }
        public bool isBorrowBook(string bookid, string username)
        {

            bool do2 = false;
            bool do1 = updateBorrowTable(bookid, username);
            int quan = getQuanOfBook(bookid);
            if (quan > 0)
            {
                do2 = updateBookInfo(bookid, quan - 1);
            }
            return do1 && do2;
        }
        public DataTable searchByLikeName(string searchValue)
        {
            DataTable result = new DataTable();
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Select * From tbl_Book Where Name like @searchvalue And status = @status";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@searchvalue", "%" + searchValue + "%");
            cmd.Parameters.AddWithValue("@status", true);
            SqlDataAdapter dtBook = new SqlDataAdapter(cmd);
            try
            {
                if (con.State != ConnectionState.Open)
                {
                    con.Open();
                }
                dtBook.Fill(result);
            }
            catch (SqlException ex)
            {
                throw new Exception(ex.Message);
            }
            return result;
        }
        public DataTable searchByAuthor(string searchValue)
        {
            DataTable result = new DataTable();
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Select * From tbl_Book Where Author like @searchvalue And status = @status";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@searchvalue", "%" + searchValue + "%");
            cmd.Parameters.AddWithValue("@status", true);
            SqlDataAdapter dtBook = new SqlDataAdapter(cmd);
            try
            {
                if (con.State != ConnectionState.Open)
                {
                    con.Open();
                }
                dtBook.Fill(result);
            }
            catch (SqlException ex)
            {
                throw new Exception(ex.Message);
            }
            return result;
        }
        private bool deleteInBorrowTable(string bookid, string username)
        {
            bool result = false;
            SqlConnection con = new SqlConnection(connectionString);
            string sql = "Delete From tbl_Borrow Where Username=@user And BookID=@id";
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@user", username);
            cmd.Parameters.AddWithValue("@id", bookid);
            try
            {
                if (con.State == ConnectionState.Closed)
                {
                    con.Open();
                }
                int row = cmd.ExecuteNonQuery();
                if (row > 0)
                {
                    result = true;
                }
            }
            finally
            {
                con.Close();
            }
            return result;
        }
        private bool updateBookQuan(string bookID)
        {
            bool result = false;
            int quan = getQuanOfBook(bookID);
            if (quan == 0)
            {
                updateStatusBook(bookID, true);
            }
            result = updateBookInfo(bookID, quan + 1);
            return result;
        }
        public bool returnBook(string username, string bookID)
        {
            bool do2 = false;
            bool do1 = deleteInBorrowTable(bookID, username);
            if (do1)
            {
                do2 = updateBookQuan(bookID);
            }
            return do2;
        }
    }
}
