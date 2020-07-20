using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DateTimeChecker
{
    [TestFixture]
    class MyTestCase
    {
        [TestCase]
        public void isValidDateTestCase1()
        {
            Form1 form = new Form1();
            Assert.AreEqual(true, form.isValidDate(28,01,2020));
        }
        [TestCase]
        public void isValidDateTestCase2()
        {
            Form1 form = new Form1();
            Assert.AreEqual(false, form.isValidDate(29,02,2018));
        }
        [TestCase]
        public void isValidDateTestCase3()
        {
            Form1 form = new Form1();
            Assert.AreEqual(false, form.isValidDate(31, 06, 2016));
        }
        [TestCase]
        public void isValidDateTestCase4()
        {
            Form1 form = new Form1();
            Assert.AreEqual(true, form.isValidDate(30, 04, 2019));
        }
        [TestCase]
        public void isValidDateTestCase5()
        {
            Form1 form = new Form1();
            Assert.AreEqual(true, form.isValidDate(29, 01, 2021));
        }
        [TestCase]
        public void isValidDateTestCase6()
        {
            Form1 form = new Form1();
            Assert.AreEqual(false, form.isValidDate(31, 02, 2018));
        }
        [TestCase]
        public void isValidDateTestCase7()
        {
            Form1 form = new Form1();
            Assert.AreEqual(true, form.isValidDate(05, 04, 2019));
        }
        [TestCase]
        public void isValidDateTestCase8()
        {
            Form1 form = new Form1();
            Assert.AreEqual(false, form.isValidDate(31, 02, 2016));
        }
        [TestCase]
        public void isValidDateTestCase9()
        {
            Form1 form = new Form1();
            Assert.AreEqual(false, form.isValidDate(29, 02, 2021));
        }
        [TestCase]
        public void isValidDateTestCase10()
        {
            Form1 form = new Form1();
            Assert.AreEqual(true, form.isValidDate(14, 01, 2020));
        }
        [TestCase]
        public void isValidDateTestCase11()
        {
            Form1 form = new Form1();
            Assert.AreEqual(false, form.isValidDate(31, 06, 2020));
        }
        [TestCase]
        public void isValidDateTestCase12()
        {
            Form1 form = new Form1();
            Assert.AreEqual(true, form.isValidDate(14, 10, 2018));
        }
        [TestCase]
        public void isValidDateTestCase13()
        {
            Form1 form = new Form1();
            Assert.AreEqual(true, form.isValidDate(01, 02, 2019));
        }
        [TestCase]
        public void isValidDateTestCase14()
        {
            Form1 form = new Form1();
            Assert.AreEqual(true, form.isValidDate(31, 01, 2021));
        }
        [TestCase]
        public void checkGetDateMonth1()
        {
            Form1 form = new Form1();
            Assert.AreEqual(30, form.getDateInMonth(6, 2016));
        }
        [TestCase]
        public void checkGetDateMonth2()
        {
            Form1 form = new Form1();
            Assert.AreEqual(29, form.getDateInMonth(2, 2020));
        }
        [TestCase]
        public void checkGetDateMonth3()
        {
            Form1 form = new Form1();
            Assert.AreEqual(28, form.getDateInMonth(2, 2018));
        }
        [TestCase]
        public void checkGetDateMonth4()
        {
            Form1 form = new Form1();
            Assert.AreEqual(29, form.getDateInMonth(2, 2016));
        }
        [TestCase]
        public void checkGetDateMonth5()
        {
            Form1 form = new Form1();
            Assert.AreEqual(31, form.getDateInMonth(10, 2019));
        }
        [TestCase]
        public void checkGetDateMonth6()
        {
            Form1 form = new Form1();
            Assert.AreEqual(31, form.getDateInMonth(3, 2019));
        }
        [TestCase]
        public void checkGetDateMonth7()
        {
            Form1 form = new Form1();
            Assert.AreEqual(28, form.getDateInMonth(2, 2018));
        }
        [TestCase]
        public void checkGetDateMonth8()
        {
            Form1 form = new Form1();
            Assert.AreEqual(30, form.getDateInMonth(6, 2016));
        }
        [TestCase]
        public void checkGetDateMonth9()
        {
            Form1 form = new Form1();
            Assert.AreEqual(31, form.getDateInMonth(3, 2020));
        }
        [TestCase]
        public void checkGetDateMonth10()
        {
            Form1 form = new Form1();
            Assert.AreEqual(28, form.getDateInMonth(2, 2021));
        }
        [TestCase]
        public void checkGetDateMonth11()
        {
            Form1 form = new Form1();
            Assert.AreEqual(30, form.getDateInMonth(6, 2021));
        }
    }
}
