using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BussinessObject
{
    public class Account
    {
        private string Username;
        private string Password;
        private string Fullname;
        private bool Role;

        public Account(string username, string password, string fullname, bool role)
        {
            Username = username;
            Password = password;
            Fullname = fullname;
            Role = role;
        }
        public string AccountUserName
        {
            get
            {
                return this.Username;
            }
            set
            {
                this.Username = value;
            }
        }

        public string AccountPassword
        {
            get { return this.Password; }
            set { this.Password = value; }
        }
        public string AccountFullName
        {
            get { return this.Fullname; }
            set { this.Fullname = value; }
        }
        public bool AccoutnRole
        {
            get { return this.Role; }
            set { this.Role = value; }
        }
    }
}
