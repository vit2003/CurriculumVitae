using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BussinessObject
{
    public class BookForUser
    {
        public string BookID
        {
            get;
            set;
        }
        public string name
        {
            get;
            set;
        }
        public bool status
        {
            get;
            set;
        }
        public float price
        {
            get;
            set;
        }
        public int quantity
        {
            get;
            set;
        }
    }
    public class tempBook
    {
        public string bookID { get; set; }
        public string bookName { get; set; }
        public float price { get; set; }
    }
}
