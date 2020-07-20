
namespace BussinessObject
{
    public class Book
    {
        private string BookID;
        private string BookName;
        private bool BookStatus;
        private double BookPrice;
        private int BookQuantity;
        private string AuthorName;

        public Book(string bookID, string bookName, bool bookStatus, double bookPrice, int bookQuantity, string authorName)
        {
            BookID = bookID;
            BookName = bookName;
            BookStatus = bookStatus;
            BookPrice = bookPrice;
            BookQuantity = bookQuantity;
            AuthorName = authorName;
        }

        public string ID
        {
            set { this.BookID = value; }
            get { return this.BookID; }

        }

        public string Name
        {
            set { this.BookName = value; }
            get { return this.BookName; }

        }

        public bool Status
        {
            set { this.BookStatus = value; }
            get { return this.BookStatus; }
        }

        public double Price
        {
            set { this.BookPrice = value; }
            get { return this.BookPrice; }
        }

        public int Quantity
        {
            get
            {
                return this.BookQuantity;
            }
            set
            {
                this.BookQuantity = value;
            }
        }

        public string Author
        {
            get
            {
                return this.AuthorName;
            }
            set
            {
                this.AuthorName = value;
            }
        }
    }
}
