package kaffplatform2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class KaffPlatForm2 {

    public static void main(String[] args) {
        KaffList f = new KaffList();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);
    }

    static class KaffList extends JFrame {

        JLabel labelMenu;
        JLabel showLbl;
        JComboBox functions;
        String[] functionsArray = {"إضافة كتاب جديد", "تعديل معلومات كتاب", "عرض معلومات الكتب او المستخدمين"};
        JButton booksButton;
        JButton usersButton;
        BorderLayout border;
        JPanel showPnl;
        JPanel menupnl;
        JPanel addpnl;

        KaffList() {
            super("منصة كاف");
            setLayout(new GridLayout(3, 1));

            functions = new JComboBox(functionsArray);
            labelMenu = new JLabel("==========  قائمة منصة كاف ==========", SwingConstants.CENTER);
            functions.setSelectedIndex(0);
            menupnl = new JPanel();
            headerPnl(labelMenu, functions, menupnl);

            showPnl = new JPanel();
            createShowPnl(showPnl);

            addpnl = new JPanel();
            createAddpnl(addpnl);

        }

        void headerPnl(JLabel labelMenu, JComboBox functions, JPanel menupnl) {
            menupnl.setLayout(new GridLayout(2, 1));
            labelMenu.setFont(new Font("Serif", Font.BOLD, 28));
            menupnl.add(labelMenu);
            menupnl.add(functions);
            add(menupnl);
        }

        void createShowPnl(JPanel showPnl) {
            showPnl.setLayout(new GridLayout(3, 1, 100, 10));
            showLbl = new JLabel(" ==عرض المعلومات ==", SwingConstants.CENTER);
            showLbl.setFont(new Font("Serif", Font.BOLD, 24));
            booksButton = new JButton("الكتب");
            usersButton = new JButton("المستخدمين");
            showPnl.add(showLbl);
            showPnl.add(booksButton);
            showPnl.add(usersButton);
            add(showPnl);
        }

        void createAddpnl(JPanel addpnl) {
            String[] levelsArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "متخرجة"};
            String text = "متوفر";
            addpnl.setLayout(new GridLayout(4, 1, 10, 10));

            JLabel titleLbl = new JLabel(" ==إضافة ==", SwingConstants.CENTER);
            titleLbl.setFont(new Font("Serif", Font.BOLD, 24));

            JPanel searchPnl = new JPanel();
            searchPnl.setLayout(new GridLayout(1, 3, 10, 10));
            Border border = BorderFactory.createLineBorder(Color.gray, 3);
            searchPnl.setBorder(border);
            JLabel lookOwner = new JLabel("بحث عن مستخدم ");
            JTextField tSearch = new JTextField();
            JButton bSearch = new JButton("بحث");
            searchPnl.add(lookOwner);
            searchPnl.add(tSearch);
            searchPnl.add(bSearch);

            JLabel addBookLbl = new JLabel("إضافة كتاب", SwingConstants.CENTER);
            addBookLbl.setFont(new Font("Serif", Font.BOLD, 20));

            JPanel addBook = new JPanel();
            addBook.setLayout(new GridLayout(9, 2, 10, 4));

            JLabel bookCode = new JLabel("رمز الكتاب ");
            JLabel bookTitle = new JLabel("عنوان الكتاب ");
            JLabel bookOwnerID = new JLabel("الرقم الأكاديمي للمستخدم");
            JLabel bookEdition = new JLabel("إصدار الكتاب");
            JLabel bookLevel = new JLabel("المستوى");
            JLabel bookStat = new JLabel("حالة الكتاب");
            JLabel bookPrice = new JLabel("سعر الكتاب");
            JLabel bookAvalabilty = new JLabel("توفر الكتاب");

            JTextField bookCodeTxtfld = new JTextField();
            JTextField bookTitleTxtfld = new JTextField();
            JTextField bookownerIDTxtfld = new JTextField();
            JTextField bookEditionTxtfld = new JTextField();
            JTextField bookPriceTxtfld = new JTextField();
            JTextField bookAvalabiltyTxtfld = new JTextField(text);
            bookAvalabiltyTxtfld.setBackground(Color.GREEN);
            bookAvalabiltyTxtfld.setFont(new Font("Serif", Font.BOLD, 12));

            JComboBox levelsComboBox = new JComboBox(levelsArray);
            levelsComboBox.setSelectedIndex(0);

            JRadioButton forSale = new JRadioButton("للبيع", true);
            JRadioButton forBorrow = new JRadioButton("للاستعارة", false);
            JRadioButton forFree = new JRadioButton("مجاناً", false);
            ButtonGroup bookStateGroup = new ButtonGroup();
            bookStateGroup.add(forSale);
            bookStateGroup.add(forBorrow);
            bookStateGroup.add(forFree);
            JPanel RButtons = new JPanel();
            RButtons.setLayout(new GridLayout(1, 3));
            RButtons.add(forSale);
            RButtons.add(forBorrow);
            RButtons.add(forFree);

            JButton bAdd = new JButton("إضافة");
            JButton bClear = new JButton("تفريغ");

            addBook.add(bookCodeTxtfld);
            addBook.add(bookCode);
            addBook.add(bookTitleTxtfld);
            addBook.add(bookTitle);
            addBook.add(bookownerIDTxtfld);
            addBook.add(bookOwnerID);
            addBook.add(bookEditionTxtfld);
            addBook.add(bookEdition);
            addBook.add(levelsComboBox);
            addBook.add(bookLevel);
            addBook.add(RButtons);
            addBook.add(bookStat);
            addBook.add(bookPriceTxtfld);
            addBook.add(bookPrice);
            addBook.add(bookAvalabiltyTxtfld);
            addBook.add(bookAvalabilty);
            addBook.add(bAdd);
            addBook.add(bClear);

            JLabel addUserLbl = new JLabel("إضافة مستخدم", SwingConstants.CENTER);
            addUserLbl.setFont(new Font("Serif", Font.BOLD, 20));

            JPanel addUser = new JPanel();
            addUser.setLayout(new GridLayout(6, 2, 10, 4));

            JLabel userName = new JLabel("الاسم ");
            JLabel userID = new JLabel("الرقم الأكاديمي ");
            JLabel userLevel = new JLabel("المستوى");
            JLabel userPhone = new JLabel("رقم الهاتف");
            JLabel userEmail = new JLabel("البريد الإلكتروني");

            JTextField userNameTxtfld = new JTextField();
            JTextField userIDTxtfld = new JTextField();
            JTextField userPhoneTxtfld = new JTextField();
            JTextField userEmailTxtfld = new JTextField();

            JComboBox userLevelsComboBox = new JComboBox(levelsArray);
            levelsComboBox.setSelectedIndex(0);

            JButton addUserbttn = new JButton("إضافة");
            JButton clrarUser = new JButton("تفريغ");

            addUser.add(userNameTxtfld);
            addUser.add(userName);
            addUser.add(userIDTxtfld);
            addUser.add(userID);
            addUser.add(userLevelsComboBox);
            addUser.add(userLevel);
            addUser.add(userPhoneTxtfld);
            addUser.add(userPhone);
            addUser.add(userEmailTxtfld);
            addUser.add(userEmail);
            addUser.add(addUserbttn);
            addUser.add(clrarUser);

            addpnl.add(titleLbl);
            addpnl.add(searchPnl);
            addpnl.add(addBookLbl);
            addpnl.add(addBook);
            addpnl.add(addUserLbl);
            addpnl.add(addUser);

            add(addpnl);
        }
    }
}
