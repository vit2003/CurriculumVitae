USE [master]
GO
/****** Object:  Database [BookStore]    Script Date: 7/15/2020 9:31:21 PM ******/
CREATE DATABASE [BookStore]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookStore', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\BookStore.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BookStore_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\BookStore_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BookStore] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookStore].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookStore] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookStore] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookStore] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookStore] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookStore] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookStore] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookStore] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookStore] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookStore] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookStore] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookStore] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookStore] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookStore] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookStore] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookStore] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BookStore] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookStore] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookStore] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookStore] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookStore] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookStore] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookStore] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookStore] SET RECOVERY FULL 
GO
ALTER DATABASE [BookStore] SET  MULTI_USER 
GO
ALTER DATABASE [BookStore] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookStore] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookStore] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookStore] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BookStore] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'BookStore', N'ON'
GO
ALTER DATABASE [BookStore] SET QUERY_STORE = OFF
GO
USE [BookStore]
GO
/****** Object:  User [vinhlp]    Script Date: 7/15/2020 9:31:21 PM ******/
CREATE USER [vinhlp] FOR LOGIN [vinhlp] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[account]    Script Date: 7/15/2020 9:31:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[username] [varchar](30) NOT NULL,
	[password] [varchar](50) NULL,
	[fullname] [varchar](50) NULL,
	[isAdmin] [bit] NULL,
	[status] [bit] NULL,
	[address] [varchar](500) NULL,
 CONSTRAINT [PK_account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[bill]    Script Date: 7/15/2020 9:31:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bill](
	[id] [varchar](30) NOT NULL,
	[username] [varchar](30) NULL,
	[total] [float] NULL,
	[day] [date] NOT NULL,
	[address] [varchar](500) NULL,
 CONSTRAINT [PK_bill] PRIMARY KEY CLUSTERED 
(
	[id] ASC,
	[day] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[billdetails]    Script Date: 7/15/2020 9:31:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[billdetails](
	[id] [varchar](30) NOT NULL,
	[billid] [varchar](30) NULL,
	[bookid] [varchar](30) NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_billdetails] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[book]    Script Date: 7/15/2020 9:31:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book](
	[id] [varchar](30) NOT NULL,
	[name] [varchar](500) NULL,
	[quantity] [int] NULL,
	[category] [varchar](30) NULL,
	[price] [float] NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_book] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 7/15/2020 9:31:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [varchar](30) NOT NULL,
	[name] [varchar](50) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[account] ([username], [password], [fullname], [isAdmin], [status], [address]) VALUES (N'Admin', N'123456', N'Vinh admin', 1, 1, N'Ho Chi Minh')
INSERT [dbo].[account] ([username], [password], [fullname], [isAdmin], [status], [address]) VALUES (N'User', N'123456', N'Vinh user', 0, 1, N'Ho Chi Minh')
INSERT [dbo].[account] ([username], [password], [fullname], [isAdmin], [status], [address]) VALUES (N'vinhcuibap', N'123456', N'tao cho vui', 1, 1, N'Hai Phong')
INSERT [dbo].[account] ([username], [password], [fullname], [isAdmin], [status], [address]) VALUES (N'vinhle', N'123456', N'vinhtest', 0, 1, N'Da Nang')
INSERT [dbo].[account] ([username], [password], [fullname], [isAdmin], [status], [address]) VALUES (N'vinhle1', N'123456', N'vinhtest2', 1, 1, N'Can Tho')
INSERT [dbo].[account] ([username], [password], [fullname], [isAdmin], [status], [address]) VALUES (N'vinhle1111@gmail.com', N'123456', N'vinh do hoi', 0, 1, N'HCM-HN-HP')
INSERT [dbo].[bill] ([id], [username], [total], [day], [address]) VALUES (N'12:42:32.914_1', N'user', 78.700004577636719, CAST(N'1900-01-01' AS Date), N'Ha Noi')
INSERT [dbo].[bill] ([id], [username], [total], [day], [address]) VALUES (N'2020-07-15_1', N'user', 48.000003814697266, CAST(N'2020-07-15' AS Date), N'Ha Noi')
INSERT [dbo].[bill] ([id], [username], [total], [day], [address]) VALUES (N'2020-07-15_2', N'user', 41.400001525878906, CAST(N'2020-07-15' AS Date), N'Ha Noi')
INSERT [dbo].[bill] ([id], [username], [total], [day], [address]) VALUES (N'2020-07-15_3', N'user', 91.600006103515625, CAST(N'2020-07-15' AS Date), N'Ha Noi')
INSERT [dbo].[billdetails] ([id], [billid], [bookid], [quantity]) VALUES (N'2020-07-15_3_1', N'2020-07-15_3', N'3', 2)
INSERT [dbo].[billdetails] ([id], [billid], [bookid], [quantity]) VALUES (N'2020-07-15_3_2', N'2020-07-15_3', N'3', 2)
INSERT [dbo].[billdetails] ([id], [billid], [bookid], [quantity]) VALUES (N'2020-07-15_3_3', N'2020-07-15_3', N'1', 3)
INSERT [dbo].[billdetails] ([id], [billid], [bookid], [quantity]) VALUES (N'2020-07-15_3_4', N'2020-07-15_3', N'1', 4)
INSERT [dbo].[book] ([id], [name], [quantity], [category], [price], [status]) VALUES (N'1', N'Java', 6, N'SE', 8.8, 1)
INSERT [dbo].[book] ([id], [name], [quantity], [category], [price], [status]) VALUES (N'2', N'C# .Net', 10, N'SE', 7.2, 1)
INSERT [dbo].[book] ([id], [name], [quantity], [category], [price], [status]) VALUES (N'3', N'Accountting', 8, N'SS', 7.5, 1)
INSERT [dbo].[book] ([id], [name], [quantity], [category], [price], [status]) VALUES (N'4', N'Marketting', 9, N'SS', 6.9, 1)
INSERT [dbo].[category] ([id], [name], [status]) VALUES (N'SE', N'Programming', 1)
INSERT [dbo].[category] ([id], [name], [status]) VALUES (N'SS', N'Bussiness', 1)
USE [master]
GO
ALTER DATABASE [BookStore] SET  READ_WRITE 
GO
