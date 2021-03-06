USE [MiniMart]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 7/22/2020 9:15:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[id] [varchar](50) NOT NULL,
	[userid] [varchar](30) NULL,
	[total] [float] NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_Bill] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillDetails]    Script Date: 7/22/2020 9:15:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillDetails](
	[id] [varchar](50) NOT NULL,
	[billid] [varchar](50) NULL,
	[productid] [varchar](30) NULL,
	[amount] [int] NULL,
 CONSTRAINT [PK_BillDetails] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 7/22/2020 9:15:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[ID] [varchar](30) NOT NULL,
	[Name] [varchar](100) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 7/22/2020 9:15:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[Id] [varchar](30) NOT NULL,
	[Name] [varchar](50) NULL,
	[Category] [varchar](30) NULL,
	[UnitPrice] [float] NULL,
	[Packaging] [date] NULL,
	[Status] [bit] NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 7/22/2020 9:15:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[Role] [int] NOT NULL,
	[note] [nchar](30) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[Role] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StokeInOut]    Script Date: 7/22/2020 9:15:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StokeInOut](
	[id] [varchar](50) NOT NULL,
	[userid] [varchar](30) NULL,
	[lastmodifiedday] [date] NULL,
	[inorout] [bit] NULL,
 CONSTRAINT [PK_StokeInOut] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StokeInOutDetail]    Script Date: 7/22/2020 9:15:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StokeInOutDetail](
	[id] [varchar](50) NOT NULL,
	[stokeinoutid] [varchar](50) NULL,
	[productid] [varchar](30) NULL,
	[amount] [int] NULL,
 CONSTRAINT [PK_StokeInOutDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 7/22/2020 9:15:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Username] [varchar](30) NOT NULL,
	[Password] [varchar](30) NULL,
	[Role] [int] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Bill] ([id], [userid], [total], [date]) VALUES (N'tester 2020-06-18 0', N'tester', 23.600000381469727, CAST(N'2020-06-18' AS Date))
INSERT [dbo].[Bill] ([id], [userid], [total], [date]) VALUES (N'tester 2020-06-18 2', N'tester', 19.5, CAST(N'2020-06-18' AS Date))
INSERT [dbo].[Bill] ([id], [userid], [total], [date]) VALUES (N'tester 2020-06-24 1', N'tester', 12.5, CAST(N'2020-06-24' AS Date))
INSERT [dbo].[BillDetails] ([id], [billid], [productid], [amount]) VALUES (N'CC01', N'tester 2020-06-18 0', N'CC01', 2)
INSERT [dbo].[BillDetails] ([id], [billid], [productid], [amount]) VALUES (N'CC03', N'tester 2020-06-18 0', N'CC03', 2)
INSERT [dbo].[BillDetails] ([id], [billid], [productid], [amount]) VALUES (N'tester 2020-06-18 2 1', N'tester 2020-06-18 2', N'CC03', 3)
INSERT [dbo].[BillDetails] ([id], [billid], [productid], [amount]) VALUES (N'tester 2020-06-24 1 1', N'tester 2020-06-24 1', N'CC03', 1)
INSERT [dbo].[BillDetails] ([id], [billid], [productid], [amount]) VALUES (N'tester 2020-06-24 1 2', N'tester 2020-06-24 1', N'CC02', 1)
INSERT [dbo].[Category] ([ID], [Name], [status]) VALUES (N'CA', N'Cocacola type AAA', 1)
INSERT [dbo].[Category] ([ID], [Name], [status]) VALUES (N'CAA', N'Cocacola type A', 1)
INSERT [dbo].[Category] ([ID], [Name], [status]) VALUES (N'CC', N'Cocacola', 1)
INSERT [dbo].[Product] ([Id], [Name], [Category], [UnitPrice], [Packaging], [Status], [quantity]) VALUES (N'CC01', N'Nuoc Ngot', N'CC', 5.3000001907348633, CAST(N'2020-09-25' AS Date), 1, 3)
INSERT [dbo].[Product] ([Id], [Name], [Category], [UnitPrice], [Packaging], [Status], [quantity]) VALUES (N'CC02', N'Nuoc Ngot 11', N'CC', 6, CAST(N'2020-10-28' AS Date), 1, 7)
INSERT [dbo].[Product] ([Id], [Name], [Category], [UnitPrice], [Packaging], [Status], [quantity]) VALUES (N'CC03', N'nuoc ngot 4', N'CC', 6.5, CAST(N'2020-07-06' AS Date), 1, 9)
INSERT [dbo].[Product] ([Id], [Name], [Category], [UnitPrice], [Packaging], [Status], [quantity]) VALUES (N'CC04', N'123456', N'CC', 6.5, CAST(N'2021-01-01' AS Date), 0, 15)
INSERT [dbo].[Product] ([Id], [Name], [Category], [UnitPrice], [Packaging], [Status], [quantity]) VALUES (N'CC05', N'ngot 5', N'cc', 5.5, CAST(N'2020-12-16' AS Date), 0, 25)
INSERT [dbo].[Role] ([Role], [note]) VALUES (1, N'Admin                         ')
INSERT [dbo].[Role] ([Role], [note]) VALUES (2, N'Seller                        ')
INSERT [dbo].[Role] ([Role], [note]) VALUES (3, N'Inventory Staff               ')
INSERT [dbo].[StokeInOut] ([id], [userid], [lastmodifiedday], [inorout]) VALUES (N'160601', N'vinhInventor', CAST(N'2020-06-16' AS Date), 0)
INSERT [dbo].[StokeInOut] ([id], [userid], [lastmodifiedday], [inorout]) VALUES (N'160602', N'vinhInventor', CAST(N'2020-06-16' AS Date), 1)
INSERT [dbo].[StokeInOut] ([id], [userid], [lastmodifiedday], [inorout]) VALUES (N'16063', N'vinhInventor', CAST(N'2020-06-16' AS Date), 1)
INSERT [dbo].[StokeInOut] ([id], [userid], [lastmodifiedday], [inorout]) VALUES (N'17061', N'vinhInventor', CAST(N'2020-06-17' AS Date), 0)
INSERT [dbo].[StokeInOut] ([id], [userid], [lastmodifiedday], [inorout]) VALUES (N'17062', N'vinhInventor', CAST(N'2020-06-17' AS Date), 1)
INSERT [dbo].[StokeInOut] ([id], [userid], [lastmodifiedday], [inorout]) VALUES (N'18061', N'vinhInventor', CAST(N'2020-06-18' AS Date), 1)
INSERT [dbo].[StokeInOutDetail] ([id], [stokeinoutid], [productid], [amount]) VALUES (N'16060101', N'160601', N'CC01', 6)
INSERT [dbo].[StokeInOutDetail] ([id], [stokeinoutid], [productid], [amount]) VALUES (N'160631', N'16063', N'CC03', 6)
INSERT [dbo].[StokeInOutDetail] ([id], [stokeinoutid], [productid], [amount]) VALUES (N'170611', N'17061', N'CC03', 6)
INSERT [dbo].[StokeInOutDetail] ([id], [stokeinoutid], [productid], [amount]) VALUES (N'170612', N'17061', N'CC01', 5)
INSERT [dbo].[StokeInOutDetail] ([id], [stokeinoutid], [productid], [amount]) VALUES (N'170621', N'17062', N'CC01', 5)
INSERT [dbo].[StokeInOutDetail] ([id], [stokeinoutid], [productid], [amount]) VALUES (N'180611', N'18061', N'CC01', 1)
INSERT [dbo].[User] ([Username], [Password], [Role], [Status]) VALUES (N'tester', N'456', 1, 1)
INSERT [dbo].[User] ([Username], [Password], [Role], [Status]) VALUES (N'vinhAdmin', N'123', 2, 1)
INSERT [dbo].[User] ([Username], [Password], [Role], [Status]) VALUES (N'vinhInventor', N'123789', 3, 1)
INSERT [dbo].[User] ([Username], [Password], [Role], [Status]) VALUES (N'vinhSeller', N'123456', 1, 1)
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK_Bill_User] FOREIGN KEY([userid])
REFERENCES [dbo].[User] ([Username])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK_Bill_User]
GO
ALTER TABLE [dbo].[BillDetails]  WITH CHECK ADD  CONSTRAINT [FK_BillDetails_Bill] FOREIGN KEY([billid])
REFERENCES [dbo].[Bill] ([id])
GO
ALTER TABLE [dbo].[BillDetails] CHECK CONSTRAINT [FK_BillDetails_Bill]
GO
ALTER TABLE [dbo].[BillDetails]  WITH CHECK ADD  CONSTRAINT [FK_BillDetails_Product] FOREIGN KEY([productid])
REFERENCES [dbo].[Product] ([Id])
GO
ALTER TABLE [dbo].[BillDetails] CHECK CONSTRAINT [FK_BillDetails_Product]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category1] FOREIGN KEY([Category])
REFERENCES [dbo].[Category] ([ID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category1]
GO
ALTER TABLE [dbo].[StokeInOut]  WITH CHECK ADD  CONSTRAINT [FK_StokeInOut_User] FOREIGN KEY([userid])
REFERENCES [dbo].[User] ([Username])
GO
ALTER TABLE [dbo].[StokeInOut] CHECK CONSTRAINT [FK_StokeInOut_User]
GO
ALTER TABLE [dbo].[StokeInOutDetail]  WITH CHECK ADD  CONSTRAINT [FK_StokeInOutDetail_Product] FOREIGN KEY([productid])
REFERENCES [dbo].[Product] ([Id])
GO
ALTER TABLE [dbo].[StokeInOutDetail] CHECK CONSTRAINT [FK_StokeInOutDetail_Product]
GO
ALTER TABLE [dbo].[StokeInOutDetail]  WITH CHECK ADD  CONSTRAINT [FK_StokeInOutDetail_StokeInOut] FOREIGN KEY([stokeinoutid])
REFERENCES [dbo].[StokeInOut] ([id])
GO
ALTER TABLE [dbo].[StokeInOutDetail] CHECK CONSTRAINT [FK_StokeInOutDetail_StokeInOut]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([Role])
REFERENCES [dbo].[Role] ([Role])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Role]
GO
