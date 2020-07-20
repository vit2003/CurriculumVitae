namespace UserForm
{
    partial class FrmAdmin
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmAdmin));
            this.lblWelcomeAdmin = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.BtnNew = new System.Windows.Forms.Button();
            this.BtnDelete = new System.Windows.Forms.Button();
            this.BtnRefresh = new System.Windows.Forms.Button();
            this.BtnUpdate = new System.Windows.Forms.Button();
            this.LblBookPrice = new System.Windows.Forms.Label();
            this.LblBookStatus = new System.Windows.Forms.Label();
            this.lblBookName = new System.Windows.Forms.Label();
            this.lblBookID = new System.Windows.Forms.Label();
            this.TxtBookID = new System.Windows.Forms.TextBox();
            this.TxtBookName = new System.Windows.Forms.TextBox();
            this.TxtBookStatus = new System.Windows.Forms.TextBox();
            this.TxtBookPrice = new System.Windows.Forms.TextBox();
            this.TxtSearchValue = new System.Windows.Forms.TextBox();
            this.lblSearchValue = new System.Windows.Forms.Label();
            this.DgvShowBook = new System.Windows.Forms.DataGridView();
            this.lblBookList = new System.Windows.Forms.Label();
            this.BtnLogout = new System.Windows.Forms.Button();
            this.LblBookQuantity = new System.Windows.Forms.Label();
            this.TxtBookQuantity = new System.Windows.Forms.TextBox();
            this.TxtAuthorName = new System.Windows.Forms.TextBox();
            this.LblAuthorName = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.DgvShowBook)).BeginInit();
            this.SuspendLayout();
            // 
            // lblWelcomeAdmin
            // 
            this.lblWelcomeAdmin.AutoSize = true;
            this.lblWelcomeAdmin.BackColor = System.Drawing.Color.NavajoWhite;
            this.lblWelcomeAdmin.Font = new System.Drawing.Font("Times New Roman", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblWelcomeAdmin.ForeColor = System.Drawing.Color.Black;
            this.lblWelcomeAdmin.Location = new System.Drawing.Point(31, 28);
            this.lblWelcomeAdmin.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblWelcomeAdmin.MaximumSize = new System.Drawing.Size(400, 37);
            this.lblWelcomeAdmin.MinimumSize = new System.Drawing.Size(133, 31);
            this.lblWelcomeAdmin.Name = "lblWelcomeAdmin";
            this.lblWelcomeAdmin.Size = new System.Drawing.Size(167, 37);
            this.lblWelcomeAdmin.TabIndex = 0;
            this.lblWelcomeAdmin.Text = "Welcome";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.NavajoWhite;
            this.label3.Font = new System.Drawing.Font("Times New Roman", 22F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(795, 103);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.MaximumSize = new System.Drawing.Size(400, 37);
            this.label3.MinimumSize = new System.Drawing.Size(133, 31);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(279, 37);
            this.label3.TabIndex = 2;
            this.label3.Text = "Book Information";
            // 
            // BtnNew
            // 
            this.BtnNew.BackColor = System.Drawing.Color.NavajoWhite;
            this.BtnNew.Font = new System.Drawing.Font("Times New Roman", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BtnNew.Location = new System.Drawing.Point(965, 602);
            this.BtnNew.Margin = new System.Windows.Forms.Padding(4);
            this.BtnNew.Name = "BtnNew";
            this.BtnNew.Size = new System.Drawing.Size(132, 47);
            this.BtnNew.TabIndex = 4;
            this.BtnNew.Text = "New";
            this.BtnNew.UseVisualStyleBackColor = false;
            this.BtnNew.Click += new System.EventHandler(this.BtnNew_Click);
            // 
            // BtnDelete
            // 
            this.BtnDelete.BackColor = System.Drawing.Color.NavajoWhite;
            this.BtnDelete.Font = new System.Drawing.Font("Times New Roman", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BtnDelete.Location = new System.Drawing.Point(1289, 602);
            this.BtnDelete.Margin = new System.Windows.Forms.Padding(4);
            this.BtnDelete.Name = "BtnDelete";
            this.BtnDelete.Size = new System.Drawing.Size(132, 47);
            this.BtnDelete.TabIndex = 6;
            this.BtnDelete.Text = "Delete";
            this.BtnDelete.UseVisualStyleBackColor = false;
            this.BtnDelete.Click += new System.EventHandler(this.BtnDelete_Click);
            // 
            // BtnRefresh
            // 
            this.BtnRefresh.BackColor = System.Drawing.Color.NavajoWhite;
            this.BtnRefresh.Font = new System.Drawing.Font("Times New Roman", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BtnRefresh.Location = new System.Drawing.Point(787, 602);
            this.BtnRefresh.Margin = new System.Windows.Forms.Padding(4);
            this.BtnRefresh.Name = "BtnRefresh";
            this.BtnRefresh.Size = new System.Drawing.Size(144, 47);
            this.BtnRefresh.TabIndex = 7;
            this.BtnRefresh.Text = "Refresh";
            this.BtnRefresh.UseVisualStyleBackColor = false;
            this.BtnRefresh.Click += new System.EventHandler(this.BtnRefresh_Click);
            // 
            // BtnUpdate
            // 
            this.BtnUpdate.BackColor = System.Drawing.Color.NavajoWhite;
            this.BtnUpdate.Font = new System.Drawing.Font("Times New Roman", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BtnUpdate.Location = new System.Drawing.Point(1127, 602);
            this.BtnUpdate.Margin = new System.Windows.Forms.Padding(4);
            this.BtnUpdate.Name = "BtnUpdate";
            this.BtnUpdate.Size = new System.Drawing.Size(132, 47);
            this.BtnUpdate.TabIndex = 8;
            this.BtnUpdate.Text = "Update";
            this.BtnUpdate.UseVisualStyleBackColor = false;
            this.BtnUpdate.Click += new System.EventHandler(this.BtnUpdate_Click);
            // 
            // LblBookPrice
            // 
            this.LblBookPrice.AutoSize = true;
            this.LblBookPrice.BackColor = System.Drawing.Color.NavajoWhite;
            this.LblBookPrice.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblBookPrice.Location = new System.Drawing.Point(796, 388);
            this.LblBookPrice.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LblBookPrice.Name = "LblBookPrice";
            this.LblBookPrice.Size = new System.Drawing.Size(147, 34);
            this.LblBookPrice.TabIndex = 10;
            this.LblBookPrice.Text = "Book Price";
            // 
            // LblBookStatus
            // 
            this.LblBookStatus.AutoSize = true;
            this.LblBookStatus.BackColor = System.Drawing.Color.NavajoWhite;
            this.LblBookStatus.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblBookStatus.Location = new System.Drawing.Point(796, 311);
            this.LblBookStatus.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LblBookStatus.Name = "LblBookStatus";
            this.LblBookStatus.Size = new System.Drawing.Size(159, 34);
            this.LblBookStatus.TabIndex = 12;
            this.LblBookStatus.Text = "Book Status";
            // 
            // lblBookName
            // 
            this.lblBookName.AutoSize = true;
            this.lblBookName.BackColor = System.Drawing.Color.NavajoWhite;
            this.lblBookName.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblBookName.Location = new System.Drawing.Point(796, 245);
            this.lblBookName.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblBookName.Name = "lblBookName";
            this.lblBookName.Size = new System.Drawing.Size(166, 34);
            this.lblBookName.TabIndex = 16;
            this.lblBookName.Text = "Book Name ";
            // 
            // lblBookID
            // 
            this.lblBookID.AutoSize = true;
            this.lblBookID.BackColor = System.Drawing.Color.NavajoWhite;
            this.lblBookID.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblBookID.Location = new System.Drawing.Point(796, 176);
            this.lblBookID.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblBookID.Name = "lblBookID";
            this.lblBookID.Size = new System.Drawing.Size(126, 34);
            this.lblBookID.TabIndex = 17;
            this.lblBookID.Text = "Book ID ";
            // 
            // TxtBookID
            // 
            this.TxtBookID.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtBookID.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtBookID.Location = new System.Drawing.Point(1073, 185);
            this.TxtBookID.Margin = new System.Windows.Forms.Padding(4);
            this.TxtBookID.Name = "TxtBookID";
            this.TxtBookID.Size = new System.Drawing.Size(348, 35);
            this.TxtBookID.TabIndex = 18;
            // 
            // TxtBookName
            // 
            this.TxtBookName.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtBookName.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtBookName.Location = new System.Drawing.Point(1073, 254);
            this.TxtBookName.Margin = new System.Windows.Forms.Padding(4);
            this.TxtBookName.Name = "TxtBookName";
            this.TxtBookName.Size = new System.Drawing.Size(348, 35);
            this.TxtBookName.TabIndex = 20;
            // 
            // TxtBookStatus
            // 
            this.TxtBookStatus.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtBookStatus.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtBookStatus.Location = new System.Drawing.Point(1072, 314);
            this.TxtBookStatus.Margin = new System.Windows.Forms.Padding(4);
            this.TxtBookStatus.Name = "TxtBookStatus";
            this.TxtBookStatus.Size = new System.Drawing.Size(348, 35);
            this.TxtBookStatus.TabIndex = 23;
            // 
            // TxtBookPrice
            // 
            this.TxtBookPrice.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtBookPrice.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtBookPrice.Location = new System.Drawing.Point(1073, 388);
            this.TxtBookPrice.Margin = new System.Windows.Forms.Padding(4);
            this.TxtBookPrice.Name = "TxtBookPrice";
            this.TxtBookPrice.Size = new System.Drawing.Size(348, 35);
            this.TxtBookPrice.TabIndex = 25;
            // 
            // TxtSearchValue
            // 
            this.TxtSearchValue.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtSearchValue.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtSearchValue.Location = new System.Drawing.Point(269, 602);
            this.TxtSearchValue.Margin = new System.Windows.Forms.Padding(4);
            this.TxtSearchValue.Name = "TxtSearchValue";
            this.TxtSearchValue.Size = new System.Drawing.Size(271, 35);
            this.TxtSearchValue.TabIndex = 30;
            this.TxtSearchValue.TextChanged += new System.EventHandler(this.TxtSearchValue_TextChanged);
            // 
            // lblSearchValue
            // 
            this.lblSearchValue.AutoSize = true;
            this.lblSearchValue.BackColor = System.Drawing.Color.NavajoWhite;
            this.lblSearchValue.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSearchValue.Location = new System.Drawing.Point(32, 604);
            this.lblSearchValue.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblSearchValue.Name = "lblSearchValue";
            this.lblSearchValue.Size = new System.Drawing.Size(170, 34);
            this.lblSearchValue.TabIndex = 19;
            this.lblSearchValue.Text = "Search Value";
            // 
            // DgvShowBook
            // 
            this.DgvShowBook.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.DgvShowBook.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DgvShowBook.Location = new System.Drawing.Point(31, 176);
            this.DgvShowBook.Margin = new System.Windows.Forms.Padding(4);
            this.DgvShowBook.Name = "DgvShowBook";
            this.DgvShowBook.RowHeadersWidth = 51;
            this.DgvShowBook.Size = new System.Drawing.Size(679, 372);
            this.DgvShowBook.TabIndex = 31;
            // 
            // lblBookList
            // 
            this.lblBookList.AutoSize = true;
            this.lblBookList.BackColor = System.Drawing.Color.NavajoWhite;
            this.lblBookList.Font = new System.Drawing.Font("Times New Roman", 22F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblBookList.Location = new System.Drawing.Point(31, 103);
            this.lblBookList.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblBookList.MaximumSize = new System.Drawing.Size(400, 37);
            this.lblBookList.MinimumSize = new System.Drawing.Size(133, 31);
            this.lblBookList.Name = "lblBookList";
            this.lblBookList.Size = new System.Drawing.Size(161, 37);
            this.lblBookList.TabIndex = 1;
            this.lblBookList.Text = "Book List";
            // 
            // BtnLogout
            // 
            this.BtnLogout.BackColor = System.Drawing.Color.NavajoWhite;
            this.BtnLogout.Font = new System.Drawing.Font("Times New Roman", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BtnLogout.Location = new System.Drawing.Point(1289, 28);
            this.BtnLogout.Margin = new System.Windows.Forms.Padding(4);
            this.BtnLogout.Name = "BtnLogout";
            this.BtnLogout.Size = new System.Drawing.Size(133, 47);
            this.BtnLogout.TabIndex = 28;
            this.BtnLogout.Text = "Logout";
            this.BtnLogout.UseVisualStyleBackColor = false;
            this.BtnLogout.Click += new System.EventHandler(this.BtnLogout_Click);
            // 
            // LblBookQuantity
            // 
            this.LblBookQuantity.AutoSize = true;
            this.LblBookQuantity.BackColor = System.Drawing.Color.NavajoWhite;
            this.LblBookQuantity.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblBookQuantity.Location = new System.Drawing.Point(796, 449);
            this.LblBookQuantity.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LblBookQuantity.Name = "LblBookQuantity";
            this.LblBookQuantity.Size = new System.Drawing.Size(189, 34);
            this.LblBookQuantity.TabIndex = 29;
            this.LblBookQuantity.Text = "Book Quantity";
            // 
            // TxtBookQuantity
            // 
            this.TxtBookQuantity.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtBookQuantity.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtBookQuantity.Location = new System.Drawing.Point(1073, 449);
            this.TxtBookQuantity.Margin = new System.Windows.Forms.Padding(4);
            this.TxtBookQuantity.Name = "TxtBookQuantity";
            this.TxtBookQuantity.Size = new System.Drawing.Size(348, 35);
            this.TxtBookQuantity.TabIndex = 26;
            // 
            // TxtAuthorName
            // 
            this.TxtAuthorName.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtAuthorName.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtAuthorName.Location = new System.Drawing.Point(1073, 512);
            this.TxtAuthorName.Margin = new System.Windows.Forms.Padding(4);
            this.TxtAuthorName.Name = "TxtAuthorName";
            this.TxtAuthorName.Size = new System.Drawing.Size(348, 35);
            this.TxtAuthorName.TabIndex = 27;
            // 
            // LblAuthorName
            // 
            this.LblAuthorName.AutoSize = true;
            this.LblAuthorName.BackColor = System.Drawing.Color.NavajoWhite;
            this.LblAuthorName.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblAuthorName.Location = new System.Drawing.Point(796, 514);
            this.LblAuthorName.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LblAuthorName.Name = "LblAuthorName";
            this.LblAuthorName.Size = new System.Drawing.Size(99, 34);
            this.LblAuthorName.TabIndex = 32;
            this.LblAuthorName.Text = "Author";
            // 
            // FrmAdmin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(1528, 730);
            this.Controls.Add(this.LblAuthorName);
            this.Controls.Add(this.TxtAuthorName);
            this.Controls.Add(this.TxtBookQuantity);
            this.Controls.Add(this.LblBookQuantity);
            this.Controls.Add(this.BtnLogout);
            this.Controls.Add(this.BtnRefresh);
            this.Controls.Add(this.BtnUpdate);
            this.Controls.Add(this.BtnNew);
            this.Controls.Add(this.BtnDelete);
            this.Controls.Add(this.lblBookID);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lblBookList);
            this.Controls.Add(this.DgvShowBook);
            this.Controls.Add(this.LblBookPrice);
            this.Controls.Add(this.TxtBookPrice);
            this.Controls.Add(this.TxtBookID);
            this.Controls.Add(this.TxtBookStatus);
            this.Controls.Add(this.lblSearchValue);
            this.Controls.Add(this.lblWelcomeAdmin);
            this.Controls.Add(this.TxtBookName);
            this.Controls.Add(this.lblBookName);
            this.Controls.Add(this.TxtSearchValue);
            this.Controls.Add(this.LblBookStatus);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "FrmAdmin";
            this.Text = "Admin Form";
            this.Load += new System.EventHandler(this.FrmAdmin_Load);
            ((System.ComponentModel.ISupportInitialize)(this.DgvShowBook)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblWelcomeAdmin;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button BtnNew;
        private System.Windows.Forms.Button BtnDelete;
        private System.Windows.Forms.Button BtnRefresh;
        private System.Windows.Forms.Button BtnUpdate;
        private System.Windows.Forms.Label LblBookPrice;
        private System.Windows.Forms.Label LblBookStatus;
        private System.Windows.Forms.Label lblBookName;
        private System.Windows.Forms.Label lblBookID;
        private System.Windows.Forms.TextBox TxtBookID;
        private System.Windows.Forms.TextBox TxtBookName;
        private System.Windows.Forms.TextBox TxtBookStatus;
        private System.Windows.Forms.TextBox TxtBookPrice;
        private System.Windows.Forms.TextBox TxtSearchValue;
        private System.Windows.Forms.Label lblSearchValue;
        private System.Windows.Forms.DataGridView DgvShowBook;
        private System.Windows.Forms.Label lblBookList;
        private System.Windows.Forms.Button BtnLogout;
        private System.Windows.Forms.Label LblBookQuantity;
        private System.Windows.Forms.TextBox TxtBookQuantity;
        private System.Windows.Forms.TextBox TxtAuthorName;
        private System.Windows.Forms.Label LblAuthorName;
    }
}

