namespace UserForm
{
    partial class LoginForm
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(LoginForm));
            this.LblTitle = new System.Windows.Forms.Label();
            this.LblUsername = new System.Windows.Forms.Label();
            this.LblPassword = new System.Windows.Forms.Label();
            this.TxtUsername = new System.Windows.Forms.TextBox();
            this.TxtPassword = new System.Windows.Forms.TextBox();
            this.BtnReset = new System.Windows.Forms.Button();
            this.BtnLogIn = new System.Windows.Forms.Button();
            this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
            this.SuspendLayout();
            // 
            // LblTitle
            // 
            this.LblTitle.AutoSize = true;
            this.LblTitle.BackColor = System.Drawing.Color.NavajoWhite;
            this.LblTitle.Font = new System.Drawing.Font("Times New Roman", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblTitle.ForeColor = System.Drawing.Color.Black;
            this.LblTitle.Location = new System.Drawing.Point(164, 47);
            this.LblTitle.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LblTitle.Name = "LblTitle";
            this.LblTitle.Size = new System.Drawing.Size(432, 42);
            this.LblTitle.TabIndex = 0;
            this.LblTitle.Text = "Welcome To My Application";
            // 
            // LblUsername
            // 
            this.LblUsername.AutoSize = true;
            this.LblUsername.BackColor = System.Drawing.Color.NavajoWhite;
            this.LblUsername.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblUsername.Location = new System.Drawing.Point(121, 146);
            this.LblUsername.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LblUsername.Name = "LblUsername";
            this.LblUsername.Size = new System.Drawing.Size(135, 34);
            this.LblUsername.TabIndex = 1;
            this.LblUsername.Text = "Username";
            // 
            // LblPassword
            // 
            this.LblPassword.AutoSize = true;
            this.LblPassword.BackColor = System.Drawing.Color.NavajoWhite;
            this.LblPassword.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LblPassword.Location = new System.Drawing.Point(121, 245);
            this.LblPassword.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LblPassword.Name = "LblPassword";
            this.LblPassword.Size = new System.Drawing.Size(128, 34);
            this.LblPassword.TabIndex = 2;
            this.LblPassword.Text = "Password";
            // 
            // TxtUsername
            // 
            this.TxtUsername.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtUsername.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtUsername.Location = new System.Drawing.Point(312, 143);
            this.TxtUsername.Margin = new System.Windows.Forms.Padding(4);
            this.TxtUsername.Name = "TxtUsername";
            this.TxtUsername.Size = new System.Drawing.Size(347, 42);
            this.TxtUsername.TabIndex = 3;
            // 
            // TxtPassword
            // 
            this.TxtPassword.BackColor = System.Drawing.Color.NavajoWhite;
            this.TxtPassword.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TxtPassword.Location = new System.Drawing.Point(312, 237);
            this.TxtPassword.Margin = new System.Windows.Forms.Padding(4);
            this.TxtPassword.Name = "TxtPassword";
            this.TxtPassword.Size = new System.Drawing.Size(347, 42);
            this.TxtPassword.TabIndex = 4;
            // 
            // BtnReset
            // 
            this.BtnReset.BackColor = System.Drawing.Color.NavajoWhite;
            this.BtnReset.Font = new System.Drawing.Font("Times New Roman", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BtnReset.Location = new System.Drawing.Point(172, 314);
            this.BtnReset.Margin = new System.Windows.Forms.Padding(4);
            this.BtnReset.Name = "BtnReset";
            this.BtnReset.Size = new System.Drawing.Size(112, 55);
            this.BtnReset.TabIndex = 5;
            this.BtnReset.Text = "Reset";
            this.BtnReset.UseVisualStyleBackColor = false;
            this.BtnReset.Click += new System.EventHandler(this.BtnReset_Click);
            // 
            // BtnLogIn
            // 
            this.BtnLogIn.BackColor = System.Drawing.Color.NavajoWhite;
            this.BtnLogIn.Font = new System.Drawing.Font("Times New Roman", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BtnLogIn.Location = new System.Drawing.Point(487, 314);
            this.BtnLogIn.Margin = new System.Windows.Forms.Padding(4);
            this.BtnLogIn.Name = "BtnLogIn";
            this.BtnLogIn.Size = new System.Drawing.Size(112, 55);
            this.BtnLogIn.TabIndex = 6;
            this.BtnLogIn.Text = "Log In";
            this.BtnLogIn.UseVisualStyleBackColor = false;
            this.BtnLogIn.Click += new System.EventHandler(this.BtnLogIn_Click);
            // 
            // LoginForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(820, 487);
            this.Controls.Add(this.BtnLogIn);
            this.Controls.Add(this.BtnReset);
            this.Controls.Add(this.TxtPassword);
            this.Controls.Add(this.TxtUsername);
            this.Controls.Add(this.LblPassword);
            this.Controls.Add(this.LblUsername);
            this.Controls.Add(this.LblTitle);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "LoginForm";
            this.Text = "LoginForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label LblUsername;
        private System.Windows.Forms.Label LblPassword;
        private System.Windows.Forms.TextBox TxtUsername;
        private System.Windows.Forms.TextBox TxtPassword;
        private System.Windows.Forms.Button BtnReset;
        private System.Windows.Forms.Button BtnLogIn;
        private System.Windows.Forms.Label LblTitle;
        private System.Windows.Forms.ToolTip toolTip1;
    }
}