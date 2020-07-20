namespace UserForm
{
    partial class UserForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UserForm));
            this.pnAvalable = new System.Windows.Forms.Panel();
            this.btnViewAllBook = new System.Windows.Forms.Button();
            this.btnSelect = new System.Windows.Forms.Button();
            this.dvgAvailableBook = new System.Windows.Forms.DataGridView();
            this.pnSearchLikeName = new System.Windows.Forms.FlowLayoutPanel();
            this.label2 = new System.Windows.Forms.Label();
            this.txtSearchLikeName = new System.Windows.Forms.TextBox();
            this.btnSearchLikeName = new System.Windows.Forms.Button();
            this.pnSearchAuthor = new System.Windows.Forms.Panel();
            this.btnSearchAuthor = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.txtSearchAuthor = new System.Windows.Forms.TextBox();
            this.pnSelectedBook = new System.Windows.Forms.Panel();
            this.btnUnselected = new System.Windows.Forms.Button();
            this.btnBorrow = new System.Windows.Forms.Button();
            this.btnUnselectedAll = new System.Windows.Forms.Button();
            this.dvgSelected = new System.Windows.Forms.DataGridView();
            this.label4 = new System.Windows.Forms.Label();
            this.pnBorrowing = new System.Windows.Forms.Panel();
            this.btnReturnAll = new System.Windows.Forms.Button();
            this.btnReturn = new System.Windows.Forms.Button();
            this.dvgBorrowing = new System.Windows.Forms.DataGridView();
            this.label5 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.lbUser = new System.Windows.Forms.Label();
            this.txtId = new System.Windows.Forms.TextBox();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtPrice = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.btnLogout = new System.Windows.Forms.Button();
            this.pnAvalable.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dvgAvailableBook)).BeginInit();
            this.pnSearchLikeName.SuspendLayout();
            this.pnSearchAuthor.SuspendLayout();
            this.pnSelectedBook.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dvgSelected)).BeginInit();
            this.pnBorrowing.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dvgBorrowing)).BeginInit();
            this.SuspendLayout();
            // 
            // pnAvalable
            // 
            this.pnAvalable.BackColor = System.Drawing.Color.Cornsilk;
            this.pnAvalable.Controls.Add(this.btnViewAllBook);
            this.pnAvalable.Controls.Add(this.btnSelect);
            this.pnAvalable.Controls.Add(this.dvgAvailableBook);
            this.pnAvalable.Location = new System.Drawing.Point(12, 25);
            this.pnAvalable.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.pnAvalable.Name = "pnAvalable";
            this.pnAvalable.Size = new System.Drawing.Size(883, 353);
            this.pnAvalable.TabIndex = 0;
            // 
            // btnViewAllBook
            // 
            this.btnViewAllBook.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnViewAllBook.Location = new System.Drawing.Point(735, 144);
            this.btnViewAllBook.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnViewAllBook.Name = "btnViewAllBook";
            this.btnViewAllBook.Size = new System.Drawing.Size(133, 86);
            this.btnViewAllBook.TabIndex = 2;
            this.btnViewAllBook.Text = "View All Book";
            this.btnViewAllBook.UseVisualStyleBackColor = false;
            this.btnViewAllBook.Click += new System.EventHandler(this.btnViewAllBook_Click);
            // 
            // btnSelect
            // 
            this.btnSelect.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnSelect.Location = new System.Drawing.Point(735, 254);
            this.btnSelect.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnSelect.Name = "btnSelect";
            this.btnSelect.Size = new System.Drawing.Size(133, 96);
            this.btnSelect.TabIndex = 1;
            this.btnSelect.Text = "Select this book to borrow";
            this.btnSelect.UseVisualStyleBackColor = false;
            this.btnSelect.Click += new System.EventHandler(this.btnSelect_Click);
            // 
            // dvgAvailableBook
            // 
            this.dvgAvailableBook.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dvgAvailableBook.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dvgAvailableBook.Location = new System.Drawing.Point(8, 21);
            this.dvgAvailableBook.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.dvgAvailableBook.Name = "dvgAvailableBook";
            this.dvgAvailableBook.RowHeadersWidth = 51;
            this.dvgAvailableBook.RowTemplate.Height = 24;
            this.dvgAvailableBook.Size = new System.Drawing.Size(701, 327);
            this.dvgAvailableBook.TabIndex = 0;
            // 
            // pnSearchLikeName
            // 
            this.pnSearchLikeName.BackColor = System.Drawing.Color.Cornsilk;
            this.pnSearchLikeName.Controls.Add(this.label2);
            this.pnSearchLikeName.Controls.Add(this.txtSearchLikeName);
            this.pnSearchLikeName.Controls.Add(this.btnSearchLikeName);
            this.pnSearchLikeName.Location = new System.Drawing.Point(919, 25);
            this.pnSearchLikeName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.pnSearchLikeName.Name = "pnSearchLikeName";
            this.pnSearchLikeName.Size = new System.Drawing.Size(419, 57);
            this.pnSearchLikeName.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.NavajoWhite;
            this.label2.Location = new System.Drawing.Point(3, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(144, 17);
            this.label2.TabIndex = 1;
            this.label2.Text = "Search By Like Name";
            // 
            // txtSearchLikeName
            // 
            this.txtSearchLikeName.BackColor = System.Drawing.Color.NavajoWhite;
            this.txtSearchLikeName.Location = new System.Drawing.Point(3, 19);
            this.txtSearchLikeName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtSearchLikeName.Name = "txtSearchLikeName";
            this.txtSearchLikeName.Size = new System.Drawing.Size(292, 22);
            this.txtSearchLikeName.TabIndex = 3;
            // 
            // btnSearchLikeName
            // 
            this.btnSearchLikeName.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnSearchLikeName.Location = new System.Drawing.Point(301, 19);
            this.btnSearchLikeName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnSearchLikeName.Name = "btnSearchLikeName";
            this.btnSearchLikeName.Size = new System.Drawing.Size(75, 23);
            this.btnSearchLikeName.TabIndex = 4;
            this.btnSearchLikeName.Text = "Search";
            this.btnSearchLikeName.UseVisualStyleBackColor = false;
            this.btnSearchLikeName.Click += new System.EventHandler(this.btnSearchLikeName_Click);
            // 
            // pnSearchAuthor
            // 
            this.pnSearchAuthor.BackColor = System.Drawing.Color.Cornsilk;
            this.pnSearchAuthor.Controls.Add(this.btnSearchAuthor);
            this.pnSearchAuthor.Controls.Add(this.label3);
            this.pnSearchAuthor.Controls.Add(this.txtSearchAuthor);
            this.pnSearchAuthor.Location = new System.Drawing.Point(917, 87);
            this.pnSearchAuthor.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.pnSearchAuthor.Name = "pnSearchAuthor";
            this.pnSearchAuthor.Size = new System.Drawing.Size(419, 57);
            this.pnSearchAuthor.TabIndex = 2;
            // 
            // btnSearchAuthor
            // 
            this.btnSearchAuthor.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnSearchAuthor.Location = new System.Drawing.Point(304, 20);
            this.btnSearchAuthor.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnSearchAuthor.Name = "btnSearchAuthor";
            this.btnSearchAuthor.Size = new System.Drawing.Size(75, 23);
            this.btnSearchAuthor.TabIndex = 3;
            this.btnSearchAuthor.Text = "Search";
            this.btnSearchAuthor.UseVisualStyleBackColor = false;
            this.btnSearchAuthor.Click += new System.EventHandler(this.btnSearchAuthor_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.NavajoWhite;
            this.label3.Location = new System.Drawing.Point(3, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(119, 17);
            this.label3.TabIndex = 0;
            this.label3.Text = "Search By Author";
            // 
            // txtSearchAuthor
            // 
            this.txtSearchAuthor.BackColor = System.Drawing.Color.NavajoWhite;
            this.txtSearchAuthor.Location = new System.Drawing.Point(5, 20);
            this.txtSearchAuthor.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtSearchAuthor.Name = "txtSearchAuthor";
            this.txtSearchAuthor.Size = new System.Drawing.Size(292, 22);
            this.txtSearchAuthor.TabIndex = 2;
            // 
            // pnSelectedBook
            // 
            this.pnSelectedBook.BackColor = System.Drawing.Color.Cornsilk;
            this.pnSelectedBook.Controls.Add(this.btnUnselected);
            this.pnSelectedBook.Controls.Add(this.btnBorrow);
            this.pnSelectedBook.Controls.Add(this.btnUnselectedAll);
            this.pnSelectedBook.Controls.Add(this.dvgSelected);
            this.pnSelectedBook.Controls.Add(this.label4);
            this.pnSelectedBook.Location = new System.Drawing.Point(919, 149);
            this.pnSelectedBook.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.pnSelectedBook.Name = "pnSelectedBook";
            this.pnSelectedBook.Size = new System.Drawing.Size(419, 229);
            this.pnSelectedBook.TabIndex = 3;
            // 
            // btnUnselected
            // 
            this.btnUnselected.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnUnselected.Location = new System.Drawing.Point(251, 201);
            this.btnUnselected.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnUnselected.Name = "btnUnselected";
            this.btnUnselected.Size = new System.Drawing.Size(125, 25);
            this.btnUnselected.TabIndex = 5;
            this.btnUnselected.Text = "Unselect";
            this.btnUnselected.UseVisualStyleBackColor = false;
            this.btnUnselected.Click += new System.EventHandler(this.btnUnselected_Click);
            // 
            // btnBorrow
            // 
            this.btnBorrow.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnBorrow.Location = new System.Drawing.Point(12, 172);
            this.btnBorrow.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnBorrow.Name = "btnBorrow";
            this.btnBorrow.Size = new System.Drawing.Size(197, 53);
            this.btnBorrow.TabIndex = 4;
            this.btnBorrow.Text = "Borrow";
            this.btnBorrow.UseVisualStyleBackColor = false;
            this.btnBorrow.Click += new System.EventHandler(this.btnBorrow_Click);
            // 
            // btnUnselectedAll
            // 
            this.btnUnselectedAll.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnUnselectedAll.Location = new System.Drawing.Point(251, 172);
            this.btnUnselectedAll.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnUnselectedAll.Name = "btnUnselectedAll";
            this.btnUnselectedAll.Size = new System.Drawing.Size(125, 23);
            this.btnUnselectedAll.TabIndex = 3;
            this.btnUnselectedAll.Text = "Unselected All";
            this.btnUnselectedAll.UseVisualStyleBackColor = false;
            this.btnUnselectedAll.Click += new System.EventHandler(this.btnUnselectedAll_Click);
            // 
            // dvgSelected
            // 
            this.dvgSelected.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dvgSelected.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dvgSelected.Location = new System.Drawing.Point(12, 34);
            this.dvgSelected.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.dvgSelected.Name = "dvgSelected";
            this.dvgSelected.RowHeadersWidth = 51;
            this.dvgSelected.RowTemplate.Height = 24;
            this.dvgSelected.Size = new System.Drawing.Size(403, 132);
            this.dvgSelected.TabIndex = 1;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.BackColor = System.Drawing.Color.NavajoWhite;
            this.label4.Location = new System.Drawing.Point(3, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(99, 17);
            this.label4.TabIndex = 0;
            this.label4.Text = "Selected Book";
            // 
            // pnBorrowing
            // 
            this.pnBorrowing.BackColor = System.Drawing.Color.Cornsilk;
            this.pnBorrowing.Controls.Add(this.btnReturnAll);
            this.pnBorrowing.Controls.Add(this.btnReturn);
            this.pnBorrowing.Controls.Add(this.dvgBorrowing);
            this.pnBorrowing.Controls.Add(this.label5);
            this.pnBorrowing.Location = new System.Drawing.Point(13, 416);
            this.pnBorrowing.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.pnBorrowing.Name = "pnBorrowing";
            this.pnBorrowing.Size = new System.Drawing.Size(903, 155);
            this.pnBorrowing.TabIndex = 4;
            // 
            // btnReturnAll
            // 
            this.btnReturnAll.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnReturnAll.Location = new System.Drawing.Point(728, 101);
            this.btnReturnAll.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnReturnAll.Name = "btnReturnAll";
            this.btnReturnAll.Size = new System.Drawing.Size(153, 39);
            this.btnReturnAll.TabIndex = 3;
            this.btnReturnAll.Text = "Return All book";
            this.btnReturnAll.UseVisualStyleBackColor = false;
            this.btnReturnAll.Click += new System.EventHandler(this.btnReturnAll_Click);
            // 
            // btnReturn
            // 
            this.btnReturn.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnReturn.Location = new System.Drawing.Point(728, 32);
            this.btnReturn.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnReturn.Name = "btnReturn";
            this.btnReturn.Size = new System.Drawing.Size(153, 43);
            this.btnReturn.TabIndex = 2;
            this.btnReturn.Text = "Return";
            this.btnReturn.UseVisualStyleBackColor = false;
            this.btnReturn.Click += new System.EventHandler(this.btnReturn_Click);
            // 
            // dvgBorrowing
            // 
            this.dvgBorrowing.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dvgBorrowing.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dvgBorrowing.Location = new System.Drawing.Point(8, 25);
            this.dvgBorrowing.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.dvgBorrowing.Name = "dvgBorrowing";
            this.dvgBorrowing.RowHeadersWidth = 51;
            this.dvgBorrowing.RowTemplate.Height = 24;
            this.dvgBorrowing.Size = new System.Drawing.Size(699, 116);
            this.dvgBorrowing.TabIndex = 1;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.BackColor = System.Drawing.Color.NavajoWhite;
            this.label5.Location = new System.Drawing.Point(3, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(107, 17);
            this.label5.TabIndex = 0;
            this.label5.Text = "Borrowing Book";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.NavajoWhite;
            this.label1.Location = new System.Drawing.Point(15, 25);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(98, 17);
            this.label1.TabIndex = 0;
            this.label1.Text = "Avalable Book";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.BackColor = System.Drawing.Color.NavajoWhite;
            this.label6.Location = new System.Drawing.Point(1167, 5);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(74, 17);
            this.label6.TabIndex = 5;
            this.label6.Text = "Welcome: ";
            // 
            // lbUser
            // 
            this.lbUser.AutoSize = true;
            this.lbUser.BackColor = System.Drawing.Color.NavajoWhite;
            this.lbUser.Location = new System.Drawing.Point(1248, 5);
            this.lbUser.Name = "lbUser";
            this.lbUser.Size = new System.Drawing.Size(73, 17);
            this.lbUser.TabIndex = 6;
            this.lbUser.Text = "Username";
            // 
            // txtId
            // 
            this.txtId.BackColor = System.Drawing.Color.NavajoWhite;
            this.txtId.Location = new System.Drawing.Point(101, 380);
            this.txtId.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtId.Name = "txtId";
            this.txtId.ReadOnly = true;
            this.txtId.Size = new System.Drawing.Size(100, 22);
            this.txtId.TabIndex = 7;
            // 
            // txtName
            // 
            this.txtName.BackColor = System.Drawing.Color.NavajoWhite;
            this.txtName.Location = new System.Drawing.Point(375, 380);
            this.txtName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtName.Name = "txtName";
            this.txtName.ReadOnly = true;
            this.txtName.Size = new System.Drawing.Size(127, 22);
            this.txtName.TabIndex = 8;
            // 
            // txtPrice
            // 
            this.txtPrice.BackColor = System.Drawing.Color.NavajoWhite;
            this.txtPrice.Location = new System.Drawing.Point(621, 380);
            this.txtPrice.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtPrice.Name = "txtPrice";
            this.txtPrice.ReadOnly = true;
            this.txtPrice.Size = new System.Drawing.Size(100, 22);
            this.txtPrice.TabIndex = 10;
            this.txtPrice.UseWaitCursor = true;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.BackColor = System.Drawing.Color.NavajoWhite;
            this.label7.Location = new System.Drawing.Point(47, 383);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(25, 17);
            this.label7.TabIndex = 11;
            this.label7.Text = "ID:";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.BackColor = System.Drawing.Color.NavajoWhite;
            this.label8.Location = new System.Drawing.Point(320, 383);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(49, 17);
            this.label8.TabIndex = 12;
            this.label8.Text = "Name:";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.BackColor = System.Drawing.Color.NavajoWhite;
            this.label9.Location = new System.Drawing.Point(565, 383);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(44, 17);
            this.label9.TabIndex = 13;
            this.label9.Text = "Price:";
            // 
            // btnLogout
            // 
            this.btnLogout.BackColor = System.Drawing.Color.NavajoWhite;
            this.btnLogout.Location = new System.Drawing.Point(1171, 448);
            this.btnLogout.Margin = new System.Windows.Forms.Padding(4);
            this.btnLogout.Name = "btnLogout";
            this.btnLogout.Size = new System.Drawing.Size(100, 73);
            this.btnLogout.TabIndex = 14;
            this.btnLogout.Text = "Logout";
            this.btnLogout.UseVisualStyleBackColor = false;
            this.btnLogout.Click += new System.EventHandler(this.btnLogout_Click);
            // 
            // UserForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(1367, 578);
            this.Controls.Add(this.btnLogout);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.txtPrice);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.txtId);
            this.Controls.Add(this.lbUser);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.pnBorrowing);
            this.Controls.Add(this.pnSelectedBook);
            this.Controls.Add(this.pnSearchAuthor);
            this.Controls.Add(this.pnSearchLikeName);
            this.Controls.Add(this.pnAvalable);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "UserForm";
            this.Text = "UserForm";
            this.Load += new System.EventHandler(this.UserForm_Load);
            this.pnAvalable.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dvgAvailableBook)).EndInit();
            this.pnSearchLikeName.ResumeLayout(false);
            this.pnSearchLikeName.PerformLayout();
            this.pnSearchAuthor.ResumeLayout(false);
            this.pnSearchAuthor.PerformLayout();
            this.pnSelectedBook.ResumeLayout(false);
            this.pnSelectedBook.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dvgSelected)).EndInit();
            this.pnBorrowing.ResumeLayout(false);
            this.pnBorrowing.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dvgBorrowing)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel pnAvalable;
        private System.Windows.Forms.Button btnSelect;
        private System.Windows.Forms.DataGridView dvgAvailableBook;
        private System.Windows.Forms.FlowLayoutPanel pnSearchLikeName;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtSearchLikeName;
        private System.Windows.Forms.Button btnSearchLikeName;
        private System.Windows.Forms.Panel pnSearchAuthor;
        private System.Windows.Forms.Button btnSearchAuthor;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtSearchAuthor;
        private System.Windows.Forms.Panel pnSelectedBook;
        private System.Windows.Forms.Button btnUnselected;
        private System.Windows.Forms.Button btnBorrow;
        private System.Windows.Forms.Button btnUnselectedAll;
        private System.Windows.Forms.DataGridView dvgSelected;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Panel pnBorrowing;
        private System.Windows.Forms.Button btnReturnAll;
        private System.Windows.Forms.Button btnReturn;
        private System.Windows.Forms.DataGridView dvgBorrowing;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label lbUser;
        private System.Windows.Forms.TextBox txtId;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.TextBox txtPrice;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Button btnViewAllBook;
        private System.Windows.Forms.Button btnLogout;
    }
}