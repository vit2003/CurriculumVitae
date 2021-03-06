USE [LibraryManament]
GO
/****** Object:  Table [dbo].[tbl_Account]    Script Date: 2020-04-05 11:33:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Account](
	[Username] [varchar](30) NOT NULL,
	[Password] [varchar](30) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Role] [bit] NOT NULL,
 CONSTRAINT [PK_UserName] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_Book]    Script Date: 2020-04-05 11:33:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Book](
	[BookID] [varchar](30) NOT NULL,
	[Name] [varchar](30) NOT NULL,
	[Status] [bit] NOT NULL,
	[Price] [numeric](6, 2) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Author] [nvarchar](50) NULL,
 CONSTRAINT [PK_tbl_Book] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_Borrow]    Script Date: 2020-04-05 11:33:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Borrow](
	[Username] [varchar](30) NOT NULL,
	[BookID] [varchar](30) NOT NULL,
 CONSTRAINT [PK_tbl_Borrow] PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_Account] ([Username], [Password], [Fullname], [Role]) VALUES (N'admin', N'123', N'Admin', 1)
INSERT [dbo].[tbl_Account] ([Username], [Password], [Fullname], [Role]) VALUES (N'ducdm', N'123', N'ducminh', 1)
INSERT [dbo].[tbl_Account] ([Username], [Password], [Fullname], [Role]) VALUES (N'teonv', N'123', N'teonguyen', 0)
INSERT [dbo].[tbl_Account] ([Username], [Password], [Fullname], [Role]) VALUES (N'tuine', N'123', N'tuiday', 0)
INSERT [dbo].[tbl_Account] ([Username], [Password], [Fullname], [Role]) VALUES (N'user', N'456', N'UserAhuu', 0)
INSERT [dbo].[tbl_Account] ([Username], [Password], [Fullname], [Role]) VALUES (N'vinhlp', N'123', N'vinhle', 0)
INSERT [dbo].[tbl_Book] ([BookID], [Name], [Status], [Price], [Quantity], [Author]) VALUES (N'AB', N'A Book', 1, CAST(5.20 AS Numeric(6, 2)), 1, N'vinh')
INSERT [dbo].[tbl_Book] ([BookID], [Name], [Status], [Price], [Quantity], [Author]) VALUES (N'JAD', N'Japan Ad', 1, CAST(1.60 AS Numeric(6, 2)), 4, N'duc')
INSERT [dbo].[tbl_Book] ([BookID], [Name], [Status], [Price], [Quantity], [Author]) VALUES (N'JF', N'Java Foundation', 1, CAST(8.20 AS Numeric(6, 2)), 10, N'hanh')
INSERT [dbo].[tbl_Book] ([BookID], [Name], [Status], [Price], [Quantity], [Author]) VALUES (N'PRN292', N'C#-.Net Programing', 1, CAST(10.30 AS Numeric(6, 2)), 10, N'thanh')
INSERT [dbo].[tbl_Borrow] ([Username], [BookID]) VALUES (N'tuine', N'ab')
ALTER TABLE [dbo].[tbl_Account]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Account_tbl_Account] FOREIGN KEY([Username])
REFERENCES [dbo].[tbl_Account] ([Username])
GO
ALTER TABLE [dbo].[tbl_Account] CHECK CONSTRAINT [FK_tbl_Account_tbl_Account]
GO
ALTER TABLE [dbo].[tbl_Borrow]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Borrow_tbl_Account] FOREIGN KEY([Username])
REFERENCES [dbo].[tbl_Account] ([Username])
GO
ALTER TABLE [dbo].[tbl_Borrow] CHECK CONSTRAINT [FK_tbl_Borrow_tbl_Account]
GO
ALTER TABLE [dbo].[tbl_Borrow]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Borrow_tbl_Book] FOREIGN KEY([BookID])
REFERENCES [dbo].[tbl_Book] ([BookID])
GO
ALTER TABLE [dbo].[tbl_Borrow] CHECK CONSTRAINT [FK_tbl_Borrow_tbl_Book]
GO
